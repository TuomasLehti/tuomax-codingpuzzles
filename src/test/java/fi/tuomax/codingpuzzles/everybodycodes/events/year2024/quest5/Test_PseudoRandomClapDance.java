package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_PseudoRandomClapDance 
extends Test_Solver
{

    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_EC, 2024, 4, 0, "part1",
            PseudoRandomClapDance_Solver_Part1.class
        );
    }

    @Test
    public void test_Round()
    {
        PseudoRandomClapDance_Solver_Part2 solver = new PseudoRandomClapDance_Solver_Part2();

        List<Integer> column;
        List<Integer> expected;

        column = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 5, 6, 7, 8, 9}));
        assertTrue(equals(expected, solver.round(column, 1)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{5, 2, 6, 7, 8, 9}));
        assertTrue(equals(expected, solver.round(column, 2)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 3, 7, 8, 9}));
        assertTrue(equals(expected, solver.round(column, 3)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 4, 8, 9}));
        assertTrue(equals(expected, solver.round(column, 4)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 5, 9}));
        assertTrue(equals(expected, solver.round(column, 5)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        assertTrue(equals(expected, solver.round(column, 6)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 7, 5}));
        assertTrue(equals(expected, solver.round(column, 7)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 8, 4, 5}));
        assertTrue(equals(expected, solver.round(column, 8)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 9, 3, 4, 5}));
        assertTrue(equals(expected, solver.round(column, 9)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{1, 10, 2, 3, 4, 5}));
        assertTrue(equals(expected, solver.round(column, 10)));

        column = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        expected = new ArrayList<>(Arrays.asList(new Integer[]{11, 1, 2, 3, 4, 5}));
        assertTrue(equals(expected, solver.round(column, 11)));
    }

    public Boolean equals(List<?> one, List<?> other)
    {
        if (one.size() != other.size()) return false;
        for (int i = 0; i < one.size(); i++) {
            Object oneItem = one.get(i);
            Object otherItem = other.get(i);
            if (!oneItem.equals(otherItem)) return false;
        }
        return true;
    }

    @Test
    public void test_Part2()
    {
        runTest(
            Site.ID_EC, 2024, 4, 1, "part2",
            PseudoRandomClapDance_Solver_Part2.class
        );
    }

    @Test
    public void test_Part3()
    {
        runTest(
            Site.ID_EC, 2024, 4, 2, "part3",
            PseudoRandomClapDance_Solver_Part3.class
        );
    }
    
}
