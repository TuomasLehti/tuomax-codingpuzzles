package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import java.io.IOException;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class Runner 
{

    public static void main(String[] args)
    {
        System.out.println();
        TangledTrees_Solver_Part1 solverPart1 = new TangledTrees_Solver_Part1();
        TangledTrees_Solver_Part2 solverPart2 = new TangledTrees_Solver_Part2();
        TangledTrees_Solver_Part3 solverPart3 = new TangledTrees_Solver_Part3();
        try {
            System.out.println("Part 1: " + solverPart1.solve(new Metadata().getInput("everybodyCodesStories", 2024, 2, 1)));
            System.out.println("Part 2: " + solverPart2.solve(new Metadata().getInput("everybodyCodesStories", 2024, 2, 2)));
            System.out.println("Part 3: " + solverPart3.solve(new Metadata().getInput("everybodyCodesStories", 2024, 2, 3)));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}