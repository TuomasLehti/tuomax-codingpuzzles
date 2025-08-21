package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.io.IOException;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class Runner 
{

    public static void main(String[] args)
    {
        EniCode_Solver_Part1 solverPart1 = new EniCode_Solver_Part1();
        EniCode_Solver_Part2 solverPart2 = new EniCode_Solver_Part2();
        EniCode_Solver_Part3 solverPart3 = new EniCode_Solver_Part3();
        try {
            System.out.println(solverPart1.solve(new Metadata()));
            System.out.println(solverPart2.solve(new Metadata()));
            System.out.println(solverPart3.solve(new Metadata()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}

// 9050307829306
// 7276515438396 