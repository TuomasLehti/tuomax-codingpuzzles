package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest5;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FishboneOrder_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Sword> swords = new ArrayList<>();
        for (String line : input) 
            swords.add(new Sword(line));
        Collections.sort(swords);
        Collections.reverse(swords);
        Long ans = 0L;
        for (int i = 0; i < swords.size(); i++) {
            ans += (i + 1) * swords.get(i).id;
        }
        setAnswer(ans.toString());
    }
    
}
