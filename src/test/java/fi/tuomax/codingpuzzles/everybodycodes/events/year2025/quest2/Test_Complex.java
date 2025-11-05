package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_Complex {

    @Test
    public void test_FromString()
    {
        Complex complex = Complex.fromString("[42,-67]");
        assertEquals(42, complex.x());
        assertEquals(-67, complex.y());
    }

    @Test
    public void test_Addition()
    {
        Complex one = null;
        Complex other = null;
        Complex sum = null;

        one = Complex.fromString("[1,1]");
        other = Complex.fromString("[2,2]");
        sum = one.add(other);
        assertEquals(3, sum.x());
        assertEquals(3, sum.y());

        one = Complex.fromString("[2,5]");
        other = Complex.fromString("[3,7]");
        sum = one.add(other);
        assertEquals(5, sum.x());
        assertEquals(12, sum.y());

        one = Complex.fromString("[-2,5]");
        other = Complex.fromString("[10,-1]");
        sum = one.add(other);
        assertEquals(8, sum.x());
        assertEquals(4, sum.y());

        one = Complex.fromString("[-1,-2]");
        other = Complex.fromString(" [-3,-4]");
        sum = one.add(other);
        assertEquals(-4, sum.x());
        assertEquals(-6, sum.y());
    }

    @Test
    public void test_Multiplication()
    {
        Complex one = null;
        Complex other = null;
        Complex product = null;

        one = Complex.fromString("[1,1]");
        other = Complex.fromString("[2,2]");
        product = one.multiply(other);
        assertEquals(0, product.x());
        assertEquals(4, product.y());

        one = Complex.fromString("[2,5]");
        other = Complex.fromString("[3,7]");
        product = one.multiply(other);
        assertEquals(-29, product.x());
        assertEquals(29, product.y());

        one = Complex.fromString("[-2,5]");
        other = Complex.fromString("[10,-1]");
        product = one.multiply(other);
        assertEquals(-15, product.x());
        assertEquals(52, product.y());

        one = Complex.fromString("[-1,-2]");
        other = Complex.fromString(" [-3,-4]");
        product = one.multiply(other);
        assertEquals(-5, product.x());
        assertEquals(10, product.y());
    }

    @Test
    public void test_Division()
    {
        Complex one = null;
        Complex other = null;
        Complex division = null;

        one = Complex.fromString("[10,12]");
        other = Complex.fromString("[2,2]");
        division = one.divide(other);
        assertEquals(5, division.x());
        assertEquals(6, division.y());

        one = Complex.fromString("[11,12]");
        other = Complex.fromString("[3,5]");
        division = one.divide(other);
        assertEquals(3, division.x());
        assertEquals(2, division.y());

        one = Complex.fromString("[-10,-12]");
        other = Complex.fromString("[2,2]");
        division = one.divide(other);
        assertEquals(-5, division.x());
        assertEquals(-6, division.y());

        one = Complex.fromString("[-11,-12]");
        other = Complex.fromString(" [3,5]");
        division = one.divide(other);
        assertEquals(-3, division.x());
        assertEquals(-2, division.y());
    }
    
}
