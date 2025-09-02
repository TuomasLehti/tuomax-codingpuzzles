package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.codingpuzzles.framework.Solver;

/** TODO: clean it up and comment it */

public class TheRunesOfPower_Solver_Part3 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<String> words = Arrays.asList(input.get(0).split(":")[1].split(","));
        input.remove(0);
        input.remove(0);

        List<Set<Integer>> scales = new ArrayList<>();

//        Integer lnIdx = 0;
        for (String text : input) {
            Set<Integer> runeIdxs = new HashSet<>();
            for (String word : words) {
                String txttxt = text + text;
                for (int idx = 0; idx < text.length(); idx++) {
                    String drow = new StringBuilder(word).reverse().toString();
                    if (txttxt.startsWith(word, idx) || txttxt.startsWith(drow, idx)) {
                        for (int jdx = 0; jdx < word.length(); jdx++) {
                            runeIdxs.add((idx + jdx) % text.length());
                        }
//                        System.out.println("L " + lnIdx + " R " + idx + " " + word);
                    }
                }
//                System.out.print("");
            }
//            lnIdx++;
            scales.add(runeIdxs);
        }
        
        List<String> txet = new ArrayList<>();
        for (int idx = 0; idx < input.get(0).length(); idx++) {
            StringBuilder sb = new StringBuilder();
            for (String text : input) {
                sb.append(text.charAt(idx));
            }
            txet.add(sb.toString());
        }

        Integer lineNo = 0;
        for (String text : txet) {
            for (String word : words) {
                for (int idx = 0; idx < text.length(); idx++) {
                    String drow = new StringBuilder(word).reverse().toString();
                    if (text.startsWith(word, idx) || text.startsWith(drow, idx)) {
                        for (int jdx = 0; jdx < word.length(); jdx++) {
                            scales.get(jdx + idx).add(lineNo);
                        }
                    }
                }
            }
            lineNo++;
        }
/*
        for (int lineIdx = 0; lineIdx < input.size(); lineIdx++) {
            for (int idx = 0; idx < input.get(lineIdx).length(); idx++) {
                if (scales.get(lineIdx).contains(idx)) {
                    System.out.print(Character.toLowerCase(input.get(lineIdx).charAt(idx)));
                } else {
                    System.out.print(input.get(lineIdx).charAt(idx));
                }
            }
            System.out.println();
        }
*/        
        Integer answer = 0;
        for (Set<Integer> runeIdxs : scales) {
            answer += runeIdxs.size();
        }
        setAnswer(answer.toString());
    }

}
