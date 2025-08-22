package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.metadata.Metadata;
import fi.tuomax.codingpuzzles.metadata.TestCase;

public class Test_Enicode_Solver_Part3
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
        assertEquals(19, solver.eni(2L, 7L, 5L));
        assertEquals(48, solver.eni(3L, 8L, 16L));
        assertEquals(559940, solver.eni(4L, 14000L, 120L));
        assertEquals(640000, solver.eni(7L, 16000L, 120L));
    }

    @Test
    public void test_Solve_Small()
    {
        Metadata metadata = new Metadata();
        TestCase testcase = null;
        try {
            testcase =
                metadata.getTestCase("everybodyCodesStories", 2024, 1, "part3Small");
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }

        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
        assertEquals(
            testcase.expectedAnswer(),
            solver.solve(testcase.input())
        );
    }

    @Test
    public void test_Solve_Big()
    {
        Metadata metadata = new Metadata();
        TestCase testcase = null;
        try {
            testcase =
                metadata.getTestCase("everybodyCodesStories", 2024, 1, "part3Big");
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }

        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
        assertEquals(
            testcase.expectedAnswer(),
            solver.solve(testcase.input())
        );
    }


}
