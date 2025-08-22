package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import java.util.ArrayList;
import java.util.List;

/**
 * A node of a tangled tree.
 */
public class Node 
{

    private Integer id;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }

    private Integer rank;

    public void setRank(Integer rank) 
    {
        this.rank = rank;
    }

    public Integer getRank() 
    {
        return rank;
    }

    private String symbol;

    public void setSymbol(String symbol) 
    {
        this.symbol = symbol;
    }

    public String getSymbol() 
    {
        return symbol;
    }

    private Node left = null;

    private Node right = null;

    private Node parent = null;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) 
    {
        this.parent = parent;
    }

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
                node.setParent(this);
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                node.setParent(this);
                right = node;
            } else {
                right.add(node);
            }
        }
    }

    public Node find(Integer id)
    {
        if (getId().equals(id)) {
            return this;
        }
        if (left != null && left.find(id) != null) {
            return left.find(id);
        }
        if (right != null && right.find(id) != null) {
            return right.find(id);
        }
        return null;
    }

    public void swap(Node other)
    {
        Integer tmpId = this.getId();
        this.setId(other.getId());
        other.setId(tmpId);

        Integer tmpRank = this.getRank();
        this.setRank(other.getRank());
        other.setRank(tmpRank);

        String tmpSymbol = this.getSymbol();
        this.setSymbol(other.getSymbol());
        other.setSymbol(tmpSymbol);
    }

    public Node findParentOf(Integer id)
    {
        return find(id) != null ? find(id).parent : null;
    }

    public void swapWithChildren(Node node, Node other, Node otherParent)
    {
        if (left == node) {
            if (otherParent.left == other) {
                Node temp = left;
                left = otherParent.left;
                otherParent.left = temp;
            } else {
                Node temp = left;
                left = otherParent.right;
                otherParent.right = temp;
            }
        } else {
            if (otherParent.left == other) {
                Node temp = right;
                right = otherParent.left;
                otherParent.left = temp;
            } else {
                Node temp = right;
                right = otherParent.right;
                otherParent.right = temp;
            }
        }
        node.setParent(otherParent);
        other.setParent(this);
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
