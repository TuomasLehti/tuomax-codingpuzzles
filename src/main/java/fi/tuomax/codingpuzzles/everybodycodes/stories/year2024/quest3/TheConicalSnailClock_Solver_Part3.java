package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest3;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheConicalSnailClock_Solver_Part3
extends Solver
{

    private List<Snail> snails = new ArrayList<>();

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        List<Long> as = new ArrayList<>();
        List<Long> ms = new ArrayList<>();
        for (Snail snail : snails) {
            ms.add((long) snail.discLength());
            as.add((long) snail.firstAlignment());
        }
        setAnswer(crt(as, ms).toString());
    }


    public Long crt(List<Long> as, List<Long> ms)
    {
        Long M = 1L;
        for (int i = 0; i < as.size(); i++) {
            M *= ms.get(i);
        }
        List<Long> Ms = new ArrayList<>();
        List<Long> ys = new ArrayList<>();
        Long crt = 0L;
        for (int i = 0; i < as.size(); i++) {
            Ms.add(M / ms.get(i));
            ys.add(mmi(Ms.get(i), ms.get(i)));
            crt = (crt + as.get(i) * Ms.get(i) * ys.get(i)) % M;
        }
        return crt;
    }

    public Long mmi(Long a, Long m)
    {
        for (long i = 1; i <= m; i++) {
            if ((a * i) % m == 1) {
                return i;
            }
        }
        return -1L;
    }

    private void parse(List<String> input)
    {
        for (String line : input)
            snails.add(new Snail(line));
    }
    
}
