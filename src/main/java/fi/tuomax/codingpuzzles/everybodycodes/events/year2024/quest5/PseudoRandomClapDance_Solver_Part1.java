package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest5;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class PseudoRandomClapDance_Solver_Part1 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {

        List<List<Integer>> columns = new ArrayList<>();
        for (String row : input) {
            Integer colIdx = 0;
            for (String col : row.split(" ")) {
                if (columns.size() == colIdx) {
                    columns.add(new ArrayList<>());
                }
                columns.get(colIdx).add(Integer.valueOf(col));
                colIdx++;
            }
        }

        for (int i = 0; i < 10; i++) {
            Integer fromCol = i % columns.size();
            Integer toCol = (i + 1) % columns.size();

            Integer clapper = columns.get(fromCol).remove(0);
            if (clapper <= columns.get(toCol).size()) {
                columns.get(toCol).add(clapper - 1, clapper);
            } else {
                int left = clapper - columns.get(toCol).size();
                int newIdx = columns.get(toCol).size() - left + 1;
                columns.get(toCol).add(newIdx, clapper);
            }

/*            
            System.out.println();
            for (List<Integer> col : columns) {
                for (Integer row : col) {
                    System.out.print(row);
                }
                System.out.println();
            }
                */
        }
        
        StringBuilder sb = new StringBuilder();
        for (List<Integer> col : columns) {
            sb.append(col.get(0));
        }
        setAnswer(sb.toString());

    }
    
}
