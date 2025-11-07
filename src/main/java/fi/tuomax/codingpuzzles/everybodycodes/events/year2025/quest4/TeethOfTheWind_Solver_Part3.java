package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest4;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.fraction.BigFraction;

public class TeethOfTheWind_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> inputs = new ArrayList<>();
        List<Integer> outputs = new ArrayList<>();
        for (String line : input) {
            if (!line.contains("|")) {
                inputs.add(Integer.valueOf(line));
                outputs.add(Integer.valueOf(line));
            } else {
                String[] parts = line.split("\\|");
                inputs.add(Integer.valueOf(parts[0]));
                outputs.add(Integer.valueOf(parts[1]));
            }
        }

        BigFraction totalRatio = new BigFraction(1);
        for (int i = 0; i < inputs.size() - 1; i++) {
            BigFraction ratio = new BigFraction(outputs.get(i), inputs.get(i+1));
            totalRatio = totalRatio.multiply(ratio);
        }

        setAnswer(Long.toString(Math.round(Math.floor(100 * totalRatio.doubleValue()))));

    }
    
}
