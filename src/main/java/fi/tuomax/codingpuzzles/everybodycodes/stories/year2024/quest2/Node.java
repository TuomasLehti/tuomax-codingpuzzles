package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import java.util.ArrayList;
import java.util.List;

/**
 * A node of a tangled tree.
 */
public class Node 
{

    private Integer id;

    public Integer getId() 
    {
        return id;
    }

    private Integer rank;

    public Integer getRank() 
    {
        return rank;
    }

    private String symbol;

    public String getSymbol() 
    {
        return symbol;
    }

    private Node left = null;

    private Node right = null;

    public Node(Integer id, Integer rank, String symbol)
    {
        this.id = id;
        this.symbol = symbol;
        this.rank = rank;
    }

    public static Node[] fromEcsInput(String line)
    {
        String[] parts = line.split("=\\[|\\] | |=|,|\\]");
        return new Node[]{
            new Node(
                Integer.valueOf(parts[2]),
                Integer.valueOf(parts[4]),
                parts[5]
            ),
            new Node(
                Integer.valueOf(parts[2]),
                Integer.valueOf(parts[7]),
                parts[8]
            )        
        };
    }

    public void add(Node node)
    {
        if (node.getRank() < this.getRank()) {
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }
    }

    public List<List<Node>> getLevels(
        Integer currentLevel,
        List<List<Node>> levels    
    ) {

        if (levels.size() <= currentLevel) {
            levels.add(new ArrayList<Node>());
        }
        levels.get(currentLevel).add(this);

        if (left != null) {
            levels = left.getLevels(currentLevel + 1, levels);
        }
        if (right != null) {
            levels = right.getLevels(currentLevel + 1, levels);
        }
        return levels;
    }
    
}
