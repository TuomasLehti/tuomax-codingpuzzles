package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest3;

public class Snail 
{

    private Integer x;

    private Integer y;

    public Snail(String ecsInput)
    {
        String[] parts = ecsInput.split(" |=");
        this.x = Integer.valueOf(parts[1]) - 1;
        this.y = Integer.valueOf(parts[3]) - 1;
    }

    public Integer position(Integer days)
    {
        Integer discLength = x + y + 1;
        Integer xPos = (x + days) % (discLength) + 1;
        Integer yPos = discLength - xPos + 1;
        return xPos + 100 * yPos;
    }

    public Boolean alignsAt(Integer days)
    {
        Integer discLength = x + y + 1;
        Integer xPos = (x + days) % (discLength) + 1;
        Integer yPos = discLength - xPos + 1;
        return yPos.equals(1);
    }
    
}