package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.metadata.Metadata;
import fi.tuomax.codingpuzzles.metadata.TestCase;

public class Test_Enicode_Solver_Part1 
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part1 solver = new EniCode_Solver_Part1();
        assertEquals(1342, solver.eni(2, 4, 5));
        assertEquals(311193, solver.eni(3, 5, 16));
    }

    @Test
    public void test_Solve()
    {
        Metadata metadata = new Metadata();
        TestCase testcase = null;
        try {
            testcase =
                metadata.getTestCase("everybodyCodesStories", 2024, 1, "part1");
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }

        EniCode_Solver_Part1 solver = new EniCode_Solver_Part1();
        assertEquals(
            testcase.expectedAnswer(),
            solver.solve(testcase.input())
        );
    }

}
