package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest2;

import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class FromComplexToClarity_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Complex a = Complex.fromString(input.get(0).split("=")[1]);

        Complex result = new Complex(0, 0);

        Complex divisor = new Complex(10, 10);

        for (int i = 0; i < 3; i++) {
            result = result.multiply(result);
            result = result.divide(divisor);
            result = result.add(a);
        }

        setAnswer(result.toString());

    }
    
}
