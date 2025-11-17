package fi.tuomax.codingpuzzles.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Counts the amount of different things in a collections of things.
 */
public class Counter<T>
{

    private Map<T, Long> amounts = new HashMap<>();

    public void count(T item)
    {
        if (!amounts.containsKey(item))
            amounts.put(item, 0L);
        amounts.put(item, amounts.get(item) + 1);
    }

    public void countAll(Collection<T> items)
    {
        for (T item : items)
            count(item);
    }

    public Long getAmount(T item)
    {
        return amounts.get(item);
    }

    public Long getMaxAmount()
    {
        Long maxAmount = 0L;
        for (T item : amounts.keySet())
            maxAmount = Math.max(maxAmount, amounts.get(item));
        return maxAmount;
    }
    
}
