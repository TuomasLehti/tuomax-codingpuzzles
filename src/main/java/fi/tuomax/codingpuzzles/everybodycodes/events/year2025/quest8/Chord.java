package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

/** 
 * A chord is a line which endpoints lie on a circle, thus dividing the circle
 * in two.
 */
public class Chord 
{

    public static int NUM_OF_NAILS = 8;

    private int start;

    private int end;

    public Chord(int start, int end)
    {
        /*
         * The direction of the cord doesn't matter, so every chord is saved
         * with the lower endpoint as the start. This should simplify the
         * calculations.
         */
        this.start = Math.min(start, end) - 1;
        this.end = Math.max(start, end) - 1;
    }

    /**
     * Is this chord a diameter, ie does it pass through the center of the 
     * circle?
     */
    public boolean isDiameter()
    {
        return this.end == this.start + NUM_OF_NAILS / 2;
    }

    /**
     * Does this chord intersect with another chord?
     */
    public boolean intersects(Chord other)
    {
        return !(
            (
                other.start >= this.start 
                && other.start <= this.end 
                && other.end >= this.start 
                && other.end <= this.end
            ) || (
                (other.start >= this.end || other.start <= this.start)
                && (other.end >= this.end || other.end <= this.start)
            )
        );
    }

    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Chord)) return false;
        Chord other = (Chord) o;
        return this.start == other.start && this.end == other.end;
    }
    
}
