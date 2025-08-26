package fi.tuomax.codingpuzzles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

import org.json.JSONException;
import org.json.JSONObject;

import fi.tuomax.codingpuzzles.framework.Solver;
import fi.tuomax.codingpuzzles.metadata.Metadata;
import fi.tuomax.codingpuzzles.metadata.TestCase;

/**
 * A base class for testing a solver.
 */
public class Test_Solver 
{

    public void runTest(
        String site,
        Integer event,
        Integer day,
        Integer part,
        String testName,
        Class<?> solverClass
    ) {
        Metadata metadata = null;
        try {
            metadata = Metadata.fromJson(
                new JSONObject(Files.readString(new File("metadata.json").toPath()))
            );
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }

        TestCase testcase = metadata.getSite(site).getEvent(event).getDay(day).getTest(testName);

        Solver solver = null;
        try {
            solver = (Solver) solverClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            fail(e.getMessage());
        }
        
        solver.solve(testcase.input());
        assertEquals(
            testcase.expectedAnswer(),
            solver.getAnswer()
        );

    }
    
}
