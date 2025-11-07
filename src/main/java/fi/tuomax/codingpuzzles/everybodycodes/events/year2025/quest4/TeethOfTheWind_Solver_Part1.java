package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest4;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class TeethOfTheWind_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> gears = new ArrayList<>();
        for (String line : input) {
            gears.add(Integer.valueOf(line));
        }

        /*
         * Only the first and last gears matter.
         * 
         * The gear ratio between two gears is the number of teeth in the 
         * second (driven) gear divided by the number of teeth in the first
         * (driver) gear.
         * 
         * For example, if the first gear has 8 teeth and the second one has 2
         * teeth, the gear ratio is 2 / 8, which simplifies to 1 / 4. This 
         * means that for every revolution of the first gear the second gear 
         * does 4 revolutions.
         * 
         * For a set of multiple gears, the individual gear ratios are 
         * multiplied together to get the total gear ratio of the whole system.
         * 
         * For example: 
         *  - first gear has 8 teeth 
         *  - second gear har 4 teeth
         *  - third gear has 2
         * 
         * The ratios:
         *  - first and second gear : 4 / 8 = 1 / 2
         *  - second and third gear: 2 / 4 = 1 / 2
         * 
         * Total ratio:
         *  - (4 / 8) * (2 / 4) = (1 / 2) * (1 / 2) = (1 / 4)
         * 
         * The end result is the same as in the earlier example: The total gear 
         * ratio is 1 / 4, and the last gear makes 4 revolutions for each 
         * revolution of the first gear.
         * 
         * I struggled a bit to understand why the middle gear doesn't play 
         * part in this, and putting the ratios (fractions) in a proper format 
         * helped me figure it out.
         * 
         * The gear ratio of the first example can be expressed as a fraction:
         * 
         *  2     1
         * --- = --- 
         *  8     4
         * 
         * For the second example, we just multiply two fractions.
         * 
         *  4     2
         * --- * ---
         *  8     4
         * 
         * Notice how the 4s cancel out. This was the light bulb moment for 
         * me. All that's left is
         *
         *  2     1
         * --- = --- 
         *  8     4
         * 
         * This can be generalized to any number of gears. Lets define the 
         * number of teeth in a gear n as T_n. The total gear ratio is
         * 
         *  T_2     T_3           T_(n-1)       T_n       T_n
         * ----- * ----- * ... * --------- * --------- = -----
         *  T_1     T_2           T_(n-2)     T_(n-1)     T_1
         */


        Double totalRatio = 
            (double) gears.get(0) 
            / (double) gears.get(gears.size() - 1);
        Double outputRotations = 2025 * totalRatio;
        setAnswer(Long.toString(Math.round(Math.floor(outputRotations))));
    }
    
}
