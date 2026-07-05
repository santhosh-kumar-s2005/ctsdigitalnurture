import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAddWithAAAPattern() {
        int a = 6;
        int b = 4;

        int result = calculator.add(a, b);

        assertEquals(10, result);
    }

    @Test
    public void testSubtractWithAAAPattern() {
        int a = 15;
        int b = 5;

        int result = calculator.subtract(a, b);

        assertEquals(10, result);
    }

    @Test
    public void testMultiplyWithAAAPattern() {
        int a = 4;
        int b = 3;

        int result = calculator.multiply(a, b);

        assertEquals(12, result);
    }

    @Test
    public void testDivideWithAAAPattern() {
        int a = 20;
        int b = 4;

        double result = calculator.divide(a, b);

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testIsEvenWithAAAPattern() {
        int number = 8;

        boolean result = calculator.isEven(number);

        assertTrue(result);
    }

    @Test
    public void testIsPositiveWithAAAPattern() {
        int number = -3;

        boolean result = calculator.isPositive(number);

        assertFalse(result);
    }
}
