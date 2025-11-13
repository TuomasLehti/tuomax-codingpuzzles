package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class TheArtOfConnection_Solver_Part3
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

        int maxKnots = 0;
        for (int i = 1; i <= Chord.NUM_OF_NAILS - 1; i++)
            for (int j = 2; j <= Chord.NUM_OF_NAILS; j++) {
                int knots = 0;
                Chord other = new Chord(i, j);
                for (Chord chord : chords) {
                    if (chord.intersects(other))
                        knots++;
                    if (chord.equals(other))
                        knots++;
                }
                maxKnots = Math.max(maxKnots, knots);
            }
        setAnswer(Integer.toString(maxKnots));

    }
    
}
