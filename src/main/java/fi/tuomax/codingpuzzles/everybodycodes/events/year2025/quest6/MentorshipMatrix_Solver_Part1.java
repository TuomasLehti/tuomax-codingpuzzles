package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest6;

import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class MentorshipMatrix_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        String s = input.get(0);
        int mentors = 0;
        for (int a = 0; a < s.length(); a++) {
            if (s.charAt(a) == 'a') {
                for (int A = 0; A < a; A++) {
                    if (s.charAt(A) == 'A') {
                        mentors++;
                    }
                }
            }
        }
        setAnswer(Integer.toString(mentors));
    }
    
}
