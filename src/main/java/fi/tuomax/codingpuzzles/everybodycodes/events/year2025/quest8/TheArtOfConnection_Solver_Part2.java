package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import java.util.List;

public class TheArtOfConnection_Solver_Part2
extends TheArtOfConnection_Solver_Part1
{

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        int knots = 0;
        for (int i = 1; i < chords.size(); i++)
            for (int j = 0; j < i; j++)
                if (chords.get(i).intersects(chords.get(j)))
                    knots++;
        setAnswer(Integer.toString(knots));
    }
    
}
