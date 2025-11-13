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
        Chord.NUM_OF_NAILS = jsonMetadata.getInt("numOfNails");

        int ans = 0;
        for (int i = 0; i < seq.size()-1; i++) 
            if (new Chord(seq.get(i), seq.get(i + 1)).isDiameter())
                ans++;
        setAnswer(Integer.toString(ans));
    }
    
}
