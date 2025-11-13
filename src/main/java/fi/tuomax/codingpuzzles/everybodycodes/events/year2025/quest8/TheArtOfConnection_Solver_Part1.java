package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class TheArtOfConnection_Solver_Part1
extends Solver
{

    protected List<Integer> seq = null;

    protected List<Chord> chords = null;

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        int ans = 0;
        for (Chord chord : chords) 
            if (chord.isDiameter())
                ans++;
        setAnswer(Integer.toString(ans));
    }

    protected void parse(List<String> input)
    {
        Chord.NUM_OF_NAILS = jsonMetadata.getInt("numOfNails");
        seq = IntegerList.fromString(input.get(0), ",");
        chords = new ArrayList<>();
        for (int i = 0; i < seq.size() - 1; i++) {
            chords.add(new Chord(seq.get(i), seq.get(i + 1)));
        }
    }
    
}
