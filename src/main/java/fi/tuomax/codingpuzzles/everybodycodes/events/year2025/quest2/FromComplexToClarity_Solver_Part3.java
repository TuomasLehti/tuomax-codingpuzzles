package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest2;

import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class FromComplexToClarity_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Complex topLeft = Complex.fromString(input.get(0).split("=")[1]);
        Complex bottomRight = topLeft.add(new Complex(1000, 1000));

        int ans = 0;
        for (long y = topLeft.y(); y <= bottomRight.y(); y += 1) {
            for (long x = topLeft.x(); x <= bottomRight.x(); x += 1) {
                Complex point = new Complex(x, y);
                if (isEngraved(point)) {
                    ans++;
                }
            }
        }
        setAnswer(Integer.toString(ans));
    }

    public boolean isEngraved(Complex a) {
        Complex result = new Complex(0, 0);
        Complex divisor = new Complex(100000, 100000); // [100000,100000]
        for (int i = 0; i < 100; i++) {
            result = result.multiply(result);
            result = result.divide(divisor);
            result = result.add(a);
            if (outOfBounds(result.x()) || outOfBounds(result.y()))
                return false;
        }
        return true;
    }

    private boolean outOfBounds(long i)
    {
        return i > 1000000 || i < -1000000;
    }
    
}
