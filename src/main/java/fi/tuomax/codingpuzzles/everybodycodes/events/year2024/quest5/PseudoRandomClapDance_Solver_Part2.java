package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.codingpuzzles.framework.Solver;

public class PseudoRandomClapDance_Solver_Part2
extends Solver
{
    
    private List<List<Integer>> columns = new ArrayList<>();

    private Integer fromCol = 0;

    private Integer dance()
    {
        Integer toCol = (fromCol + 1) % columns.size();
        Integer clapper = columns.get(fromCol).remove(0);
        List<Integer> oldCol = columns.remove((int) toCol);
        List<Integer> newCol = round(oldCol, clapper);
        columns.add((int) toCol, newCol);
        fromCol = toCol;

        StringBuilder sb = new StringBuilder();
        for (List<Integer> col : columns) {
            sb.append(col.get(0));
        }
        return Integer.valueOf(sb.toString());
    }

    public List<Integer> round(List<Integer> column, int clapper)
    {
        int idx = (clapper - 1) % column.size();
        int side = (clapper - 1) / column.size();
        if (side % 2 == 0) {
            column.add(idx, clapper);
        } else {
            column.add(column.size() - idx, clapper);
        }
        return column;
    }
 
    @Override
    public void solve(List<String> input) 
    {

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

        Map<Integer, Integer> shouts = new HashMap<>();
        Integer round = 1;
        Integer shout;
        while (true) {
            shout = dance();
            Integer amount = shouts.getOrDefault(shout, 0) + 1;
            if (amount.equals(2024)) break;
            shouts.put(shout, amount);
            round++;
        }
        Long ans = (long) round * shout;
        setAnswer(ans.toString());
/*
        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        while (!detector.repetitionDetected()) {
            detector.add(dance());
        }

        long repSize = detector.getRepetition().size();
        long introSize = detector.getIntro().size();
        long numOfShouts = 2024;

        Long result = ((numOfShouts - 1) * repSize + introSize + 1) * detector.getRepetition().get(0);
        
        setAnswer(result.toString());
*/
    }
    
}
