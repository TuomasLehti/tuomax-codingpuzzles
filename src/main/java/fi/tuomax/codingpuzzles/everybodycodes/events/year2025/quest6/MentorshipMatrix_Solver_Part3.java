package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest6;

import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class MentorshipMatrix_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        int repetitions = jsonMetadata.getInt("repetitions");
        int distance = jsonMetadata.getInt("distance");

        System.out.println("repeating");
        String s = input.get(0).repeat(repetitions);
        System.out.println("done");

        int ans = 0;

        for (int pupilIdx = 0; pupilIdx < s.length(); pupilIdx++) {
            
            if (Character.isUpperCase(s.charAt(pupilIdx)))
                continue;

            char pupil = s.charAt(pupilIdx);
            char mentor = Character.toUpperCase(pupil);

            int left = Math.max(0, pupilIdx - distance);
            int right = Math.min(pupilIdx + distance, s.length()-1);

            for (int mentorIdx = left; mentorIdx <= right; mentorIdx++) {
                if (s.charAt(mentorIdx) == mentor)
                    ans++;
            }

        }
        setAnswer(Integer.toString(ans));
    }
    
}
