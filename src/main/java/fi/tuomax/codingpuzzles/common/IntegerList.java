package fi.tuomax.codingpuzzles.common;

import java.util.ArrayList;
import java.util.List;

public class IntegerList 
{

    public static List<Integer> fromString(String input, String separator)
    {
        List<Integer> ints = new ArrayList<>();
        for (String part : input.split(separator))
            ints.add(Integer.valueOf(part));
        return ints;
    }

    public static Long sum(List<Integer> ints)
    {
        Long sum = 0L;
        for (Integer i : ints)
            sum += i;
        return sum;
    }

}
