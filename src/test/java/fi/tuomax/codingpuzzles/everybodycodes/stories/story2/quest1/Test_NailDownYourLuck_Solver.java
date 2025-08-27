package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_NailDownYourLuck_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_ECS, 2, 0, 0, "part1", 
            NailDownYourLuck_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2()
    {
        runTest(
            Site.ID_ECS, 2, 0, 1, "part2", 
            NailDownYourLuck_Solver_Part2.class
        );
    }

    @Test
    public void test_Part3_Small()
    {
        runTest(
            Site.ID_ECS, 2, 0, 2, "part3Small", 
            NailDownYourLuck_Solver_Part3.class
        );
    }

    @Test
    public void test_Part3_Big()
    {
        runTest(
            Site.ID_ECS, 2, 0, 2, "part3Big", 
            NailDownYourLuck_Solver_Part3.class
        );
    }

    @Test
    public void test_Part3_Full()
    {
        runTest(
            Site.ID_ECS, 2, 0, 2, "part3Full", 
            NailDownYourLuck_Solver_Part3.class
        );
    }
    
}
