package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import java.io.IOException;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class Runner 
{

    public static void main(String[] args)
    {
        System.out.println();
        TangledTrees_Solver solverPart1 = new TangledTrees_Solver();
        TangledTrees_Solver_Part2 solverPart2 = new TangledTrees_Solver_Part2();
        try {
            System.out.println("Part 1: " + solverPart1.solve(new Metadata().getInput("everybodyCodesStories", 2024, 2, 1)));
            System.out.println("Part 2: " + solverPart2.solve(new Metadata().getInput("everybodyCodesStories", 2024, 2, 2)));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}