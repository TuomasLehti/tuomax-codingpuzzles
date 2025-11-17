package fi.tuomax.codingpuzzles.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerList 
{

    public static List<Integer> fromString(String input, String separator)
    {
        List<Integer> ints = new ArrayList<>();
        for (String part : input.split(separator))
            ints.add(Integer.valueOf(part));
        return ints;
    }

    public static List<Integer> fromStringCollection(Collection<String> strs)
    {
        List<Integer> ints = new ArrayList<>();
        for (String str : strs)
            ints.add(Integer.valueOf(str));
        return ints;
    }

    /**
     * Removes duplicates from a list of integers. Doesn't guarantee that
     * ordering remains the same.
     */
    public static List<Integer> removeDuplicates(List<Integer> ints)
    {
        Set<Integer> unique = new HashSet<>(ints);
        return new ArrayList<Integer>(unique);
    }

    public static Long sum(List<Integer> ints)
    {
        Long sum = 0L;
        for (Integer i : ints)
            sum += i;
        return sum;
    }

}
