package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest3;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class MiningMaestro_Solver_Part3 
extends Solver
{

    protected List<List<Integer>> area;

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        Integer depth = 1;
        Integer numOfDigs = Integer.MAX_VALUE;
        Integer total = count(1);
        while (numOfDigs > 0) {
//            System.out.println();
//            print();
            numOfDigs = dig(depth);
            total += numOfDigs;
            depth++;
        }
        setAnswer(total.toString());
    }

    private void print()
    {
        for (List<Integer> row : area) {
            for (Integer col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private Integer dig(Integer depth)
    {
        Integer numOfDigs = 0;
        List<List<Integer>> newArea = new ArrayList<>();

        newArea.add(new ArrayList<>(area.get(0)));
        for (int rowIdx = 1; rowIdx < area.size() - 1; rowIdx++) {
            List<Integer> oldRow = area.get(rowIdx);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(0);
            for (int colIdx = 1; colIdx < oldRow.size() - 1; colIdx++) {
                if (
                    area.get(rowIdx).get(colIdx).equals(depth)
                    && area.get(rowIdx - 1).get(colIdx - 1).equals(depth)
                    && area.get(rowIdx - 1).get(colIdx).equals(depth)
                    && area.get(rowIdx - 1).get(colIdx + 1).equals(depth)
                    && area.get(rowIdx).get(colIdx - 1).equals(depth)
                    && area.get(rowIdx).get(colIdx + 1).equals(depth)
                    && area.get(rowIdx + 1).get(colIdx - 1).equals(depth)
                    && area.get(rowIdx + 1).get(colIdx ).equals(depth)
                    && area.get(rowIdx + 1).get(colIdx + 1).equals(depth)
                ) {
                    newRow.add(depth + 1);
                    numOfDigs++;
                } else {
                    newRow.add(area.get(rowIdx).get(colIdx));
                }
            }
            newRow.add(0);
            newArea.add(newRow);
        }
        newArea.add(new ArrayList<>(area.get(area.size() - 1)));
        area = newArea;
        return numOfDigs;
    }

    private Integer count(Integer depth) 
    {
        Integer result = 0;
        for (List<Integer> row : area) {
            for (Integer col : row) {
                if (col.equals(depth)) {
                    result++;
                }
            }
        }
        return result;
    }

    private void parse(List<String> input) 
    {
        area = new ArrayList<>();
        for (String line : input) {
            List<Integer> row = new ArrayList<>();
            row.add(0);
            for (Character col : line.toCharArray()) {
                row.add(col == '.' ? 0 : 1);
            }
            row.add(0);
            area.add(row);
        }
        List<Integer> topRow = new ArrayList<>();
        for (int i = 0; i < area.get(0).size(); i++) {
            topRow.add(0);
        }
        area.add(0, topRow);
        area.add(topRow);
    }
    
    
}
