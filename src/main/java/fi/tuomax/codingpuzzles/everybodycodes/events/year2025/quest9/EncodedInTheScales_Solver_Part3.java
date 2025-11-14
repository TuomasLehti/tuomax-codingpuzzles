package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest9;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EncodedInTheScales_Solver_Part3
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


        List<Set<Integer>> families = new ArrayList<>();

        for (int childIdx = 1; childIdx <= dna.size(); childIdx++) {
            System.out.println("child " + childIdx);
            for (int momIdx = 1; momIdx <= dna.size(); momIdx++) {
                for (int dadIdx = 1; dadIdx <= dna.size(); dadIdx++) {
                    if (childIdx == momIdx || childIdx == dadIdx || momIdx == dadIdx)
                        continue;
                    if (isChildOf(dna.get(childIdx), dna.get(momIdx), dna.get(dadIdx)))  {
                        Set<Integer> family = new HashSet<>();
                        family.add(childIdx);
                        family.add(momIdx);
                        family.add(dadIdx);
                        families.add(family);
                    }
                }
            }
        }

        boolean smoethingGotJoined = true;
        while (smoethingGotJoined) {
            smoethingGotJoined = false;
            List<Set<Integer>> newFamilies = new ArrayList<>();
            for (int i = 0; i < families.size(); i++) {
                Set<Integer> newI = new HashSet<>(families.get(i));
                for (int j = families.size() - 1; j >= 0; j--) {
                    if (i == j)
                        continue;
                    if (haveCommonElements(newI, families.get(j))) {
                        newI.addAll(families.get(j));
                        families.remove(j);
                        smoethingGotJoined = true;
                    }
                }
                newFamilies.add(newI);
            }
            families = newFamilies;
        }

        Collections.sort(families, new Comparator<Set<Integer>>(){
            @Override
            public int compare(Set<Integer> o1, Set<Integer> o2) {
                return o2.size() - o1.size();
            }
        });

        int ans = 0;
        for (Integer i : families.get(0)) {
            ans += i;
        }

        setAnswer(Integer.toString(ans));
    }

    private boolean haveCommonElements(Set<Integer> one, Set<Integer> other)
    {
        for (Integer anInt : one)
            for (Integer anotherInt : other)
                if (anInt.equals(anotherInt))
                    return true;
        return false;
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
    
}
