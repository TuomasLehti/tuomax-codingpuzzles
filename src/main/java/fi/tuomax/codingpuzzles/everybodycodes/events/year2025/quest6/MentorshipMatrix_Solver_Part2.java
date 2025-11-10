package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest6;

import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class MentorshipMatrix_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        String s = input.get(0);
        setAnswer(Integer.toString(
            mentors(s, 'A', 'a')
            + mentors(s, 'B', 'b')
            + mentors(s, 'C', 'c')
        ));
    }

    private int mentors(String s, char mentor, char pupil)
    {
        int m = 0;
        for (int a = 0; a < s.length(); a++) {
            if (s.charAt(a) == pupil) {
                for (int A = 0; A < a; A++) {
                    if (s.charAt(A) == mentor) {
                        m++;
                    }
                }
            }
        }
        return m;
    }
    
}
