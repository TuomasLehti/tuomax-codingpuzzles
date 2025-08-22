package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import fi.tuomax.codingpuzzles.common.RepetitionDetector;

public class EniCode_Solver_Part1 
extends EniCode_Solver
{

    @Override
    protected Long getFinalEniAnswer(
        RepetitionDetector<Long> detector,
        Integer n,
        Integer exp,
        Integer mod
    ) {
        StringBuilder sb = new StringBuilder();
        for (long idx = exp - 1; idx >= 0; idx--) {
            sb.append(detector.get(idx).toString());
        }
        return Long.valueOf(sb.toString());
    }

    
}
