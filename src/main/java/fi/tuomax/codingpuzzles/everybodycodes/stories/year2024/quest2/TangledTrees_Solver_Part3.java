package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

public class TangledTrees_Solver_Part3
extends TangledTrees_Solver_Part1
{

    @Override
    protected void handleSwap(String line)
    {
        String[] parts = line.split(" ");
        Node leftNode = pairs.get(Integer.valueOf(parts[1]))[0];
        Node rightNode = pairs.get(Integer.valueOf(parts[1]))[1];
        leftNode.getParent().swapWithChildren(leftNode, rightNode, rightNode.getParent());
    }

}
