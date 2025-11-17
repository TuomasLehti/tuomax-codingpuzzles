package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest9;

import fi.tuomax.codingpuzzles.common.IntegerList;
import java.util.List;

public class SparklingBugs_Solver_Part3
extends SparklingBugs_Solver_Part2
{

    private int[] dots = new int[]{101, 100, 75, 74, 50, 49, 38, 37, 30, 25, 24, 20, 16, 15, 10, 5, 3, 1};

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> balls = IntegerList.fromStringCollection(input);

        long totalBeetles = 0;
        for (Integer brightness : balls) {
            totalBeetles += calculateMinBeetles(brightness);
        }
        setAnswer(Long.toString(totalBeetles));
    }

    private long calculateMinBeetles(int targetBrightness)
    {
        long minBeetles = Integer.MAX_VALUE;
        for (int pivot = -52; pivot <= 52; pivot++) {
            
            int lower = targetBrightness / 2 + pivot;
            int upper = targetBrightness - lower;
            if (Math.abs(upper - lower) > 100) 
                continue;
            
            int lowerBeetles = calculateMinBeetlesForAHalfBall(lower);
            int upperBeetles = calculateMinBeetlesForAHalfBall(upper);
            minBeetles = Math.min(minBeetles, lowerBeetles + upperBeetles);
        }
        return minBeetles;
    }

    private int calculateMinBeetlesForAHalfBall(int targetBrightness)
    {
        minNumOfTakenBeetles = Integer.MAX_VALUE;
        calculateMinNumOfBeetles(targetBrightness, dots, 0, 0);
        return minNumOfTakenBeetles;

    }
    
}
