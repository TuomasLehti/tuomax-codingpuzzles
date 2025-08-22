package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;

import fi.tuomax.codingpuzzles.metadata.Metadata;

public class TangledTrees_Solver_Part3
{

    private Node leftTree = new Node(-1, -1, "");

    private Node rightTree = new Node(-1, -1, "");

    private Map<Integer, Node[]> pairs = new HashMap<>();

    public String solve(List<String> ecsInput)
    {
        for (String line : ecsInput) {
            if (line.startsWith("ADD")) {
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
                pairs.put(nodes[0].getId(), nodes);
            } else {
                System.out.println("L before:" + print(leftTree));
                System.out.println("R before:" + print(rightTree));

                String[] parts = line.split(" ");
                
                Node leftNode = pairs.get(Integer.valueOf(parts[1]))[0];
                Node rightNode = pairs.get(Integer.valueOf(parts[1]))[1];
                leftNode.getParent().swapWithChildren(leftNode, rightNode, rightNode.getParent());

                System.out.println("L after:" + print(leftTree));
                System.out.println("R after:" + print(rightTree));
                System.out.println("---");
            }
        }
        return getLongestMessage(leftTree) + getLongestMessage(rightTree);
    }

    public String print(Node tree)
    {
        StringBuilder sb = new StringBuilder();
        List<List<Node>> levels = new ArrayList<>();
        levels = tree.getLevels(0, levels);
        for (List<Node> level : levels) {
            for (Node node : level) {
                sb.append(node.getSymbol());
            }
            sb.append("-");
        }
        return sb.toString();
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
       
    
}
