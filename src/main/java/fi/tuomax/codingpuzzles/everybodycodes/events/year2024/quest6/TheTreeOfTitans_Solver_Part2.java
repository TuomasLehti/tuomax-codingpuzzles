package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheTreeOfTitans_Solver_Part2 
extends Solver
{

    private Map<String, Set<String>> tree = new HashMap<>();

    private Map<Integer, List<String>> routes = new HashMap<>();

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        search("RR", "RR");

        StringBuilder sb = new StringBuilder("R");
        for (Integer len : routes.keySet())
            if (routes.get(len).size() == 1)
                for (int i = 2; i < routes.get(len).get(0).length(); i += 4)
                    sb.append(routes.get(len).get(0).charAt(i));
        setAnswer(sb.toString());
    }



    private void search(String route, String branch)
    {
        if (branch.equals("@")) {
            addRoute(route);
            System.out.println(route);
        } else if (tree.containsKey(branch)) {
            for (String subbranch : tree.get(branch)) {
                search(route + subbranch, subbranch);
            }
        }
    }

    private void addRoute(String route)
    {
        if (!routes.containsKey(route.length()))
            routes.put(route.length(), new ArrayList<>());
        routes.get(route.length()).add(route);
    }

    protected void parse(List<String> input)
    {
        for (String line : input) {
            tree.put(
                line.split(":")[0],
                new HashSet<>(Arrays.asList(line.split(":")[1].split(",")))
            );
        }
    }


    
}
// RLLWLMDTTL@