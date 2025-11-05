package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest2;

public record Complex(
    long x,
    long y
) {

    public static Complex fromString(String input) 
    {
        String[] parts = input.split("\\[|,|\\]");
        return new Complex(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    public Complex add(Complex other) 
    {
        return new Complex(x() + other.x(), y() + other.y());
    }

    public Complex multiply(Complex other) 
    {
        return new Complex(
            x() * other.x() - y() * other.y(),
            x() * other.y() + y() * other.x()
        );
    }

    public Complex divide(Complex other) 
    {
        return new Complex(x() / other.x(), y() / other.y());
    }

    public String toString()
    {
        return String.format("[%d,%d]", x(), y());
    }

    
}
