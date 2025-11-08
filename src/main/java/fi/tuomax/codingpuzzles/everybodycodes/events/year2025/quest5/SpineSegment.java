package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest5;

public class SpineSegment {

    private Integer left = null;
    private Integer right = null;
    private Integer current = null;
    private SpineSegment next = null;

    public void add(Integer num) 
    {
        if (current == null) {
            current = num;
        } else if (num < current) {
            if (left == null) {
                left = num;
            } else {
                addBelow(num);
            }
        } else if (num > current) {
            if (right == null) {
                right = num;
            } else {
                addBelow(num);
            }
        } else {
            addBelow(num);
        }
    }

    public void addBelow(Integer num) 
    {
        if (next == null) 
            next = new SpineSegment();
        next.add(num);
    }

    public String toString() 
    {
        if (next != null)
            return current.toString() + next.toString();
        else
            return current.toString();

    }
    
}
