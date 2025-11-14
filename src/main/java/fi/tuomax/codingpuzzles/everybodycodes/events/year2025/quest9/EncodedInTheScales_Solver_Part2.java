package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest9;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodedInTheScales_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Map<Integer, String> dna = new HashMap<>();
        for (String line : input)
            dna.put(
                Integer.valueOf(line.split(":")[0]),
                line.split(":")[1]
            );

        int ans = 0;

        for (int childIdx = 1; childIdx <= dna.size(); childIdx++) {
            System.out.println("child " + childIdx);
            for (int momIdx = 1; momIdx <= dna.size(); momIdx++) {
                for (int dadIdx = 1; dadIdx <= dna.size(); dadIdx++) {
                    if (childIdx == momIdx || childIdx == dadIdx || momIdx == dadIdx)
                        continue;
                    if (isChildOf(dna.get(childIdx), dna.get(momIdx), dna.get(dadIdx)))  
                        ans += similarity(dna.get(childIdx), dna.get(momIdx)) * similarity(dna.get(childIdx), dna.get(dadIdx));

                }
            }
        }

        setAnswer(Integer.toString(ans / 2));
    }

    private boolean isChildOf(String child, String mom, String dad)
    {
        for (int i = 0; i < child.length(); i++) {
            char symC = child.charAt(i);
            char symM = mom.charAt(i);
            char symD = dad.charAt(i);
            if (symC != symM && symC != symD)
                return false;
        }
        return true;
    }

    private int similarity(String child, String parent)
    {
        int similarity = 0;
        for (int i = 0; i < child.length(); i++) 
            if (child.charAt(i) == parent.charAt(i))
                similarity++;
        return similarity;
    }
    
}
