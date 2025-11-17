package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest9;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.List;

public class SparklingBugs_Solver_Part2
extends Solver
{

    private int[] dots = new int[]{30, 25, 24, 20, 16, 15, 10, 5, 3, 1};

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> balls = IntegerList.fromStringCollection(input);

        int totalBeetles = 0;
        for (Integer ball : balls) {
            minNumOfTakenBeetles = Integer.MAX_VALUE;
            calculateMinNumOfBeetles(ball, dots, 0, 0);
            totalBeetles += minNumOfTakenBeetles;
        }
        setAnswer(Integer.toString(totalBeetles));
    }
    
    protected Integer minNumOfTakenBeetles = Integer.MAX_VALUE;

    /**
     * A recursive function to find the lowest amount of beetles to create
     * a ball of given brightness.
     * @param targetBrightness
     *      Goes down as the recursion goes deeper.
     * @param dotIdx
     * @param numOfTakenBeetles
     */
    protected void calculateMinNumOfBeetles(
        int targetBrightness, 
        int[] dots,
        int dotIdx, 
        int numOfTakenBeetles
    ) {
        /* This branch can be pruned if we have already taken more beetles
         * than the minimum. */
        if (numOfTakenBeetles >= minNumOfTakenBeetles) {
            return;
        }
        /* Base case is that we've taken a certain amount of 1-beetles. If
         * the amount of beetles accumulated over the recursion reaches the 
         * target brightness, we compare if it is lower than the minimum. */
        if (dotIdx >= dots.length) {
            if (targetBrightness == 0) {
                minNumOfTakenBeetles = Math.min(minNumOfTakenBeetles, numOfTakenBeetles);
            }
            return;
        }
        /* maxDotAmount is the maximum number of beetles of the current (largest
         * remaining) dot value we could use. This gives the most brightness per
         * beetle, so it’s an optimistic lower bound on how many beetles we still
         * need from here.
         *
         * If even this best-case total (numOfTakenBeetles + maxDotAmount) is not
         * better than the current minimum, then any real solution, which can only
         * use smaller, less efficient dots, cannot improve the result. Prune. */        
        int maxDotAmount = targetBrightness / dots[dotIdx];
        if ((numOfTakenBeetles + maxDotAmount) > minNumOfTakenBeetles) {
            return;
        }
        /* Recurse to branches where we take max, max-1, max-2, ..., max-n 
         * beetles with this amount of dots. */
        for (int i = maxDotAmount; i >= 0; i--) {
            targetBrightness -= i * dots[dotIdx];
            calculateMinNumOfBeetles(
                targetBrightness, dots, dotIdx + 1, numOfTakenBeetles + i
            );
            targetBrightness += i * dots[dotIdx];
        }
    }

}