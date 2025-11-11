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

        if (input.get(0).length() > distance) {
            int ans = 0;
            if (repetitions > 3) {
                int first = mentors(input.get(0), 1, distance);
                int second = mentors(input.get(0), 2, distance);
                int third = mentors(input.get(0), 3, distance);
                ans = first + (third - second) * (repetitions - 1);
            } else {
                ans = mentors(input.get(0), repetitions, distance);
            }
            setAnswer(Integer.toString(ans));

        } else {

            /* This is here just to make the examples work lol. */

            int preRepetitions = (repetitions / input.get(0).length()) + 1;
            int otherRepetitions = repetitions - preRepetitions;
            int pre = mentors(input.get(0), preRepetitions, distance);
            int others = mentors(input.get(0), preRepetitions + 1, distance) - pre;
            int ans = pre + otherRepetitions * others;
            setAnswer(Integer.toString(ans));

        }
    }

    private int mentors(String s, int repetitions, int distance)
    {
        s = s.repeat(repetitions);

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
        return ans;
    }
    
}
