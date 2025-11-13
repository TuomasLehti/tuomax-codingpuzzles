package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import java.util.List;

public class TheArtOfConnection_Solver_Part3
extends TheArtOfConnection_Solver_Part1
{

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
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
