package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.io.IOException;

public class Runner 
{

    public static void main(String[] args)
    {
        EniCode_Solver_Part1 solverPart1 = new EniCode_Solver_Part1();
        try {
            System.out.println(solverPart1.solve());
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
