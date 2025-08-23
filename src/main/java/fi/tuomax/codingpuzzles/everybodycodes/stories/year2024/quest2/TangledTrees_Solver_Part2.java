package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

public class TangledTrees_Solver_Part2
extends TangledTrees_Solver_Part1
{

    @Override
    protected void handleSwap(String line)
    {
        String[] parts = line.split(" ");
        Node leftNode = leftTree.find(Integer.valueOf(parts[1]));
        Node rightNode = rightTree.find(Integer.valueOf(parts[1]));
        leftNode.swap(rightNode);
    }
    
}
