package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.common.RepetitionDetector;

public class EniCode_Solver_Part2
extends EniCode_Solver
{


    public Long getTerm(List<Long> longs, long idx)
    {
        if (idx < longs.size()) {
            return longs.get((int) idx % Integer.MAX_VALUE);
        }
        long numOfWholeCycles = idx / longs.size();
        long firstIdxOfUncompleteCycle = numOfWholeCycles * longs.size();
        long idxToCycle = idx - firstIdxOfUncompleteCycle;
        return longs.get((int) idxToCycle % Integer.MAX_VALUE);
    }

    @Override
    protected Long getFinalEniAnswer(
        RepetitionDetector<Long> detector, 
        Long n, 
        Long exp, 
        Long mod
    ) {
        /* There are cases where the number of remainders is less than 5. */
        Long lastIdx = exp - 1L;
        Long firstIdx = Math.max(0, lastIdx - 5);

        StringBuilder sb = new StringBuilder();
        for (long idx = lastIdx; idx > firstIdx; idx--) {
            sb.append(detector.get(idx).toString());
        }
        return Long.valueOf(sb.toString());
    }

    
}
