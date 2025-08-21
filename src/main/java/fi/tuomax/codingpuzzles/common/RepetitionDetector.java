package fi.tuomax.codingpuzzles.common;

import java.util.ArrayList;
import java.util.List;

/**
 * A silly little cycle detecting class.
 * 
 * Many coding puzzles have a trope in which a long list of numbers or strings
 * is calculated. This list contains repetition, and the puzzle asks for the
 * googolplexth item in the list. Calculating every value up to that point is
 * too slow, but the repetition offers a shortcut past most of the repeating
 * parts.
 * 
 * The usage of this class is two-fold. First new entries should be added to 
 * the list until repetition is detected. After that the different parts of the
 * list, namely intro, repetition, and outro, can be inspected individually.
 * 
 * The intro is the part of the list before the actual repetition starts. For
 * example the list (1, 2, 3, 4, 5, 6, 4, 5, 6, 4, 5, 6) has the intro 
 * (1, 2, 3).
 * 
 * The repetition is the part of the list which repeats over and over. In the 
 * case of the list in the previous chapter, the repetition is (4, 5, 6).
 * 
 * Outro means the part after the last complete repetition. If we consider the 
 * sublist of indexes 0 to 7 of our example, the outro would be (4, 5).
 */
public class RepetitionDetector<T> 
{

    private List<T> entries = new ArrayList<>();

    private T firstRepeatingItem = null;

    /**
     * Adds a new entry to the list. If repetition has already started, throws
     * an exception.
     * @param entry
     *      The entry to be added.
     */
    public void add(T entry)
    {
        if (repetitionDetected()) {
            throw new IllegalStateException(
                "Repetition already detected, adding new entries is not possible."
            );
        }
        if (!entries.contains(entry)) {
            entries.add(entry);
        } else {
            firstRepeatingItem = entry;
        }
    }

    public Boolean repetitionDetected()
    {
        return firstRepeatingItem != null;
    }

    /**
     * Returns the intro, which is the part of the list before the repetition
     * starts. If no repetition has been detected yet, throws an exception. If
     * there is no intro, ie. the repeating part starts from the first entry,
     * returns an empty list.
     * @return
     *      The intro.
     */
    public List<T> getIntro()
    {
        if (!repetitionDetected()) {
            throw new IllegalStateException(
                "Repetition hasn't been detected yet."
            );
        }
        return entries.subList(0, entries.indexOf(firstRepeatingItem));
    }

    /**
     * Returns the repeating part of the list.
     * @return
     *      The repeating part.
     */
    public List<T> getRepetition()
    {
        if (!repetitionDetected()) {
            throw new IllegalStateException(
                "Repetition hasn't been detected yet."
            );
        }
        return entries.subList(
            entries.indexOf(firstRepeatingItem), 
            entries.size()
        );
    }

    public List<T> getOutro(Long lastIndex)
    {
        Integer introLength = getIntro().size();
        Integer repetitionLength = getRepetition().size();
        Long outroLength = (lastIndex - introLength + 1) % repetitionLength;

        return entries.subList(
            introLength,
            (int) (introLength + outroLength) % Integer.MAX_VALUE
        );
    }

    public Long getNumOfRepetitions(Long lastIndex)
    {
        Integer introLength = getIntro().size();
        Integer repetitionLength = getRepetition().size();
        return (lastIndex - introLength + 1) / repetitionLength;
    }
    
}
