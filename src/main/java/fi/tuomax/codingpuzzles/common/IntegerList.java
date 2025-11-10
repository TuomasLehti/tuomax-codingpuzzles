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

    public static List<Integer> fromStringList(List<String> input)
    {
        List<Integer> ints = new ArrayList<>();
        for (String line : input)
            ints.add(Integer.valueOf(line));
        return ints;
    }

    public static String toString(List<Integer> ints, String separator)
    {
        List<String> strs = new ArrayList<>();
        for (Integer i : ints) 
            strs.add(i.toString());
        return String.join(separator, strs);
    }

    public static Integer sum(List<Integer> ints)
    {
        Integer sum = 0;
        for (Integer i : ints) 
            sum += i;
        return sum;
    }

}
