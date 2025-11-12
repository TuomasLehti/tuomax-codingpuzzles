package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class TheArtOfConnection_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> seq = IntegerList.fromString(input.get(0), ",");
        int numOfNails = jsonMetadata.getInt("numOfNails");
        int oppSep = numOfNails / 2;
        int ans = 0;
        for (int i = 0; i < seq.size()-1; i++) {
            int sep = Math.abs(seq.get(i) - seq.get(i+1));
            if (sep == oppSep)
                ans ++;
        }
        setAnswer(Integer.toString(ans));
    }
    
}
