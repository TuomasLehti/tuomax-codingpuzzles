package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class TheArtOfConnection_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Chord.NUM_OF_NAILS = jsonMetadata.getInt("numOfNails");
        List<Chord> chords = new ArrayList<>();
        List<Integer> seq = IntegerList.fromString(input.get(0), ",");
        for (int i = 0; i < seq.size() - 1; i++) {
            chords.add(new Chord(seq.get(i), seq.get(i + 1)));
        }

        int knots = 0;
        for (int i = 1; i < chords.size(); i++)
            for (int j = 0; j < i; j++)
                if (chords.get(i).intersects(chords.get(j)))
                    knots++;
        setAnswer(Integer.toString(knots));
    }
    
}
