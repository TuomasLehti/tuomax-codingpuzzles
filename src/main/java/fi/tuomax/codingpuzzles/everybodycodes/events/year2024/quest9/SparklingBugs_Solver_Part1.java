package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest9;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class SparklingBugs_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> balls = IntegerList.fromStringList(input);

        int[] dots = new int[]{10, 5, 3, 1};

        int totalBeetles = 0;
        for (Integer ball : balls) {
            int ballBeetles = 0;
            
            ballBeetles += ball / 10;
            ball = ball % 10;

            ballBeetles += ball / 5;
            ball = ball % 5;

            ballBeetles += ball / 3;
            ball = ball % 3;

            ballBeetles += ball;

            totalBeetles += ballBeetles;
        }
        setAnswer(Integer.toString(totalBeetles));
    }
    
}
