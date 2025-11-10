package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest9;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class SparklingBugs_Solver_Part2
extends Solver
{

    int[] dots = new int[]{30, 25, 24, 20, 16, 15, 10, 5, 3, 1};

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> balls = IntegerList.fromStringList(input);

        int totalBeetles = 0;
        for (Integer ball : balls) {
//            System.out.print(ball + ":");
            taken = new ArrayList<>();
            minBeetles = Integer.MAX_VALUE;
            take2(ball, 0, 0);
//            System.out.println(minBeetles);
            totalBeetles += minBeetles;
        }
        setAnswer(Integer.toString(totalBeetles));
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
