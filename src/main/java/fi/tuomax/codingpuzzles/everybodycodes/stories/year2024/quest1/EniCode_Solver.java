package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.common.RepetitionDetector;

/**
 * A base class for solvers, which takes care of the common stuff.
 */
public abstract class EniCode_Solver 
{

    public Long eni(Integer n, Integer exp, Integer mod)
    {
        RepetitionDetector<Long> detector = new RepetitionDetector<>();
        Long score = 1L;
        while (!detector.repetitionDetected()) {
            score = (score * n) % mod;
            detector.add(score);
        }
        return getFinalEniAnswer(detector, n, exp, mod);
    }

    protected abstract Long getFinalEniAnswer(
        RepetitionDetector<Long> detector,
        Integer n,
        Integer exp,
        Integer mod
    );

    public Long summedEni(EniParams params)
    {
        return 
            Long.valueOf(eni(params.a(), params.x(), params.m())) 
            + Long.valueOf(eni(params.b(), params.y(), params.m())) 
            + Long.valueOf(eni(params.c(), params.z(), params.m()));
    }

    public String solve(List<String> input)
    {
        Long answer = Long.MIN_VALUE;
        for (String line : input) {
            answer = Math.max(
                answer, 
                summedEni(EniParams.fromEcInput(line))
            );
        }
        return answer.toString();
        
    }
    
}
