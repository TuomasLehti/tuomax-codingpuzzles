package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest5;

import java.util.List;

import fi.tuomax.codingpuzzles.common.IntegerList;

public class Sword 
implements Comparable<Sword>
{

    private SpineSegment segment = new SpineSegment();

    public Long id;

    public Sword(String input)
    {
        id = Long.valueOf(input.split(":")[0]);
        List<Integer> numbers = IntegerList.fromString(input.split(":")[1], ",");
        for (Integer num : numbers) {
            segment.add(num);
        }
    }

    @Override
    public int compareTo(Sword o) 
    {
        if (this.segment.compareTo(o.segment) != 0)
            return this.segment.compareTo(o.segment);
        return this.id.compareTo(o.id);
    }

}
