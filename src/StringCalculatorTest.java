import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    @Test
    public void testAddEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testAddOneNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(6, StringCalculator.add("1,5"));
    }

    @Test
    public void testAddMultipleNumbers() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void testAddWithNewLine() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testAddWithDifferentDelimiters() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        System.out.println(StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testAddNegativeNumbers() {
        try {
            StringCalculator.add("1,-2,3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("negative numbers not allowed: -2", e.getMessage());
        }
    }

    @Test
    public void testAddMultipleNegativeNumbers() {
        try {
            StringCalculator.add("1,-2,-3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("negative numbers not allowed: -2, -3", e.getMessage());
        }
    }
}
