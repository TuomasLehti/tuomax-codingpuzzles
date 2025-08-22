package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.common.RepetitionDetector;

public class EniCode_Solver_Part3
extends EniCode_Solver
{

    @Override
    protected Long getFinalEniAnswer(
        RepetitionDetector<Long> detector, 
        Long n, 
        Long exp, 
        Long mod
    ) {
        List<Long> intro = detector.getIntro();
        List<Long> repetition = detector.getRepetition();
        List<Long> outro = detector.getOutro(exp - 1);
        Long numOfRepetitions = detector.getNumOfRepetitions(exp - 1);

        Long sum = 0L;
        for (Long num : intro) {
            sum += num;
        }
        for (Long num : repetition) {
            sum += num * numOfRepetitions;
        }
        for (Long num : outro) {
            sum += num;
        }
        return sum;
    }

    
}
