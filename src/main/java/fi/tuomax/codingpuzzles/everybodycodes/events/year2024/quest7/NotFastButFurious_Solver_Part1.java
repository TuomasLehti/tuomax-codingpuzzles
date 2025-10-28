package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class NotFastButFurious_Solver_Part1 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Plan> plans = parse(input);
        Collections.sort(plans, new Comparator<Plan>(){
            @Override
            public int compare(Plan o1, Plan o2) {
                return o2.race(10).compareTo(o1.race(10));
            }
        });
        String ans = "";
        for (Plan plan : plans) {
            ans += plan.getId();
        }
        setAnswer(ans);
    }

    private List<Plan> parse(List<String> input)
    {
        List<Plan> plans = new ArrayList<>();
        for (String line : input)
            plans.add(new Plan(line));
        return plans;
    }
    
}
