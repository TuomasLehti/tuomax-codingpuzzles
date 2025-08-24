package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.common.RepetitionDetector;
import fi.tuomax.codingpuzzles.framework.Solver;

/**
 * A base class for solvers, which takes care of the common stuff.
 */
public abstract class EniCode_Solver 
extends Solver
{

    public Long eni(Long n, Long exp, Long mod)
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
        Long n,
        Long exp,
        Long mod
    );

    public Long summedEni(EniParams params)
    {
        return 
            eni(params.a(), params.x(), params.m())
            + eni(params.b(), params.y(), params.m())
            + eni(params.c(), params.z(), params.m());
    }

    public void solve(List<String> input)
    {
        Long answer = Long.MIN_VALUE;
        for (String line : input) {
            answer = Math.max(
                answer, 
                summedEni(EniParams.fromEcInput(line))
            );
        }
        setAnswer(answer.toString());
    }
    
}
