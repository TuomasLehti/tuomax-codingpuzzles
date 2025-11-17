package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest9;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class SparklingBugs_Solver_Part3
extends Solver
{

    int[] dots = new int[]{101, 100, 75, 74, 50, 49, 38, 37, 30, 25, 24, 20, 16, 15, 10, 5, 3, 1};

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> balls = IntegerList.fromStringList(input);

        long totalBeetles = 0;
        for (Integer ball : balls) {
//            System.out.print(ball + ":");
            System.out.println("--"+ball+"--");
            totalBeetles += brightness(ball);
//            System.out.println(minBeetles);
        }
        setAnswer(Long.toString(totalBeetles));
    }
//146499
    private long brightness(int ball)
    {
        long minBrightness = Integer.MAX_VALUE;
        for (int pivot = -52; pivot <= 52; pivot++) {
            int lower = ball / 2 + pivot;
            int upper = ball - lower;
            System.out.print(lower + "-" + upper + " " + Math.abs(upper - lower) + " : ");
            if (Math.abs(upper - lower) > 100) continue;
            taken = new ArrayList<>();
            minBeetles = Integer.MAX_VALUE;
            take2(lower, 0, 0);
            int lowerBrightness = minBeetles;
            taken = new ArrayList<>();
            minBeetles = Integer.MAX_VALUE;
            take2(upper, 0, 0);
            int upperBrightness = minBeetles;
            minBrightness = Math.min(minBrightness, lowerBrightness + upperBrightness);
            System.out.println(
                lowerBrightness + " " + upperBrightness + " " + minBrightness);
        }
        return minBrightness;
    }
    
    List<Integer> taken = new ArrayList<>();

    List<Integer> minTaken = null;

    Integer minBeetles = Integer.MAX_VALUE;

    private void take2(int ball, int dotIdx, int taken)
    {
        if (taken >= minBeetles) {
//            System.out.println("longer");
            return;
        }
        if (dotIdx >= dots.length) {
            if (ball == 0) {
//                System.out.println("tot:" + taken + "\n");
                minBeetles = Math.min(minBeetles, taken);
            }
            return;
        }
        int m = ball / dots[dotIdx];
        if ((taken + m) > minBeetles) {
//            System.out.println("prelinger");
            return;
        }
        for (int i = m; i >= 0; i--) {
//            System.out.println(dots[dotIdx] + ":" + i);
            ball -= i * dots[dotIdx];
            take2(ball, dotIdx + 1, taken + i);
            ball += i * dots[dotIdx];
        }
    }
    
}
