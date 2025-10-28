package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import java.util.ArrayList;
import java.util.List;

public class Planner 
{

    List<StringBuilder> combs = new ArrayList<>();


    public void combinations(int pluses, int minuses, int equalses, StringBuilder current)
    {
        if (pluses == 0 && minuses == 0 && equalses == 0) {
            combs.add(current);
            System.out.println(current.toString() + " (" + combs.size() + ")");
            return;
        }
        if (pluses > 0) {
            current.append("+");
            combinations(pluses - 1, minuses, equalses, current);
            current.deleteCharAt(current.length() - 1);
        }
        if (minuses > 0) {
            current.append("-");
            combinations(pluses, minuses - 1, equalses, current);
            current.deleteCharAt(current.length() - 1);
        }
        if (equalses > 0) {
            current.append("=");
            combinations(pluses, minuses, equalses - 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
}
