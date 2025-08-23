package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class TangledTrees_Solver_Part1 
{

    protected Node leftTree = null;

    protected Node rightTree = null;

    public String solve(List<String> ecsInput)
    {
        for (String line : ecsInput) {
            if (line.startsWith("ADD")) {
                handleAdd(line);
            } else {
                handleSwap(line);
            }
        }
        return getLongestMessage(leftTree) + getLongestMessage(rightTree);
    }

    private void handleAdd(String line) 
    {
        Node[] nodes = Node.fromEcsInput(line);
        if (leftTree == null) {
            leftTree = nodes[0];
        } else {
            leftTree.add(nodes[0]);
        }
        if (rightTree == null) {
            rightTree = nodes[1];
        } else {
            rightTree.add(nodes[1]);
        }
    }

    protected void handleSwap(String line)
    {
        // does nothing in part 1
    }

    private String getLongestMessage(Node tree)
    {
        List<List<Node>> levels = new ArrayList<>();
        levels.add(new ArrayList<>());
        levels = tree.getLevels(0, levels);
        
        Integer longestLength = 0;
        Integer longestIdx = 0;
        for (int idx = 0; idx < levels.size(); idx++) {
            if (levels.get(idx).size() > longestLength) {
                longestIdx = idx;
                longestLength = levels.get(idx).size();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node : levels.get(longestIdx)) {
            sb.append(node.getSymbol());
        }

        return sb.toString();
    }
        

    public static void main(String[] args)
    {
        TangledTrees_Solver_Part1 solver = new TangledTrees_Solver_Part1();
        try {
            solver.solve(new Metadata().getInput("everybodyCodesStories", 2024, 2, 1));
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
    
}
