package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest7;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Namegraph_Solver_Part2
extends Solver
{

    Map<Character, String> rules = new HashMap<>();

    @Override
    public void solve(List<String> input) 
    {
        String[] names = input.get(0).split(",");
        input.remove(0);
        input.remove(0);
        for (String line : input) {
            rules.put(line.charAt(0), line.split(" > ")[1]);
        }

        setAnswer("n/a");
        int i = 1;
        int ans = 0;
        for (String name : names) {
            if (valid(name))
                ans += i;
            i++;
        }
        setAnswer(Integer.toString(ans));
    }

    private boolean valid(String name)
    {
        for (int i = 0; i < name.length() - 2; i++) {
            if (!rules.containsKey(name.charAt(i)))
                return false;
            if (!rules.get(name.charAt(i)).contains(name.substring(i+1, i+2)))
                return false;
        }
        return true;
    }
    
}
