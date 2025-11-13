package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class TheArtOfConnection_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        int numOfNails = jsonMetadata.getInt("numOfNails");
        int[][] conns = new int[numOfNails][];
        for (int i = 0; i < conns.length; i++) {
            conns[i] = new int[numOfNails];
            for (int j = 0; j < conns[i].length; j++)
                conns[i][j] = 0;
        }

        int knots = 0;

        List<Integer> seq = IntegerList.fromString(input.get(0), ",");
        for (int i = 0; i < seq.size() - 1; i++) {
            int cur = (seq.get(i) + numOfNails - 1) % numOfNails;
            int nxt = (seq.get(i + 1) + numOfNails - 1) % numOfNails;
//            System.out.println(cur + "---" + nxt);

            if (
                Math.abs(nxt - cur) == 1 
                || (nxt == 0 && cur == (numOfNails - 1))
                || (cur == 0 && nxt == (numOfNails - 1))
            )
                continue;

            int startStart = cur + 1;
            int startEnd = nxt - 1;
            if (startEnd < startStart)
                startEnd += numOfNails;
            
            int endStart = nxt + 1;
            int endEnd = cur - 1;
            if (endEnd < endStart)
                endEnd += numOfNails;

//            System.out.println("check " + startStart + "->" + startEnd + " and " + endStart + "->" + endEnd);

            for (int j = startStart; j  <= startEnd; j++) {
                for (int k = endStart; k <= endEnd; k++) {
                    int jm = j % numOfNails;
                    int km = k % numOfNails;
                    int ks = conns[Math.max(jm, km)][Math.min(jm, km)];
                    knots += ks;
                    if (ks > 0) {
//                        System.out.println(jm + "-" + km);
                    }

//                    System.out.println((j % numOfNails) + "-" + (k % numOfNails));
                }
            }
//            System.out.println("step " + (i + 1) + "   total knots " + knots);

            conns[Math.max(cur, nxt)][Math.min(cur, nxt)]++;
        }

        /*
        for (int row = 0; row < conns.length; row++) {
            for (int col = 0; col < conns[row].length; col++) {
                System.out.printf("% 4d ", conns[col][row]);
            }
            System.out.println("");
        }*/
        setAnswer(Integer.toString(knots));
    }
    
}
