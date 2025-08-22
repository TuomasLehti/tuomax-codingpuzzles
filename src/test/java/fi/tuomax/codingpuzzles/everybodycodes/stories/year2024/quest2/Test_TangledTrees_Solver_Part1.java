package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.metadata.Metadata;
import fi.tuomax.codingpuzzles.metadata.TestCase;

public class Test_TangledTrees_Solver_Part1 {

    @Test
    public void test_Solve_Simple()
    {
        Metadata metadata = new Metadata();
        TestCase testcase = null;
        try {
            testcase =
                metadata.getTestCase("everybodyCodesStories", 2024, 2, "part1Simple");
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }

        TangledTrees_Solver solver = new TangledTrees_Solver();
        assertEquals(
            testcase.expectedAnswer(),
            solver.solve(testcase.input())
        );
    }

    @Test
    public void test_Solve_Complex()
    {
        Metadata metadata = new Metadata();
        TestCase testcase = null;
        try {
            testcase =
                metadata.getTestCase("everybodyCodesStories", 2024, 2, "part1Complex");
        } catch (JSONException | IOException e) {
            fail(e.getMessage());
        }

        TangledTrees_Solver solver = new TangledTrees_Solver();
        assertEquals(
            testcase.expectedAnswer(),
            solver.solve(testcase.input())
        );
    }
    
}
