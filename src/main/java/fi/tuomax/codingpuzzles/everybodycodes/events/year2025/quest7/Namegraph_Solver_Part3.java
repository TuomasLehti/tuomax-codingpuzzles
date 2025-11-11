package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest7;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Namegraph_Solver_Part3
extends Solver
{

    Map<Character, String[]> rules = new HashMap<>();

    @Override
    public void solve(List<String> input) 
    {
        String[] prefixes = input.get(0).split(",");
        input.remove(0);
        input.remove(0);
        for (String line : input) {
            rules.put(line.charAt(0), line.split(" > ")[1].split(","));
        }
        for (String prefix : prefixes) {
            System.out.print(prefix + " ");
            if (valid(prefix)) {
                System.out.print("valid ");
                possibilities(new StringBuilder(prefix));
            } else {
                System.out.print("invalid ");
            }
            System.out.println(names.size());
        }
        setAnswer(Integer.toString(names.size()));
    }

    Set<String> names = new HashSet<>();

    private void possibilities(StringBuilder current)
    {
        if (current.length() > 11) 
            return;
        if (current.length() >= 7) {
            names.add(current.toString());
//            System.out.println(current.toString());
        }
        if (!rules.containsKey(current.charAt(current.length() - 1)))
            return;
        String[] continuations = rules.get(current.charAt(current.length() - 1));
        for (String continuation : continuations) {
            current.append(continuation);
            possibilities(current);
            current.setLength(current.length() - 1);
        }
    }

    private boolean valid(String name)
    {
        for (int i = 0; i < name.length() - 1; i++) {
            Character cur = name.charAt(i);
            if (!rules.containsKey(cur))
                return false;
            String[] nxtchrs = rules.get(cur);
            if (!arrayContains(nxtchrs, name.substring(i+1, i+2)))
                return false;
        }
        return true;
    }

    private boolean arrayContains(String[] arr, String str)
    {
        for (String s : arr)
            if (s.equals(str))
                return true;
        return false;
    }
    
}
