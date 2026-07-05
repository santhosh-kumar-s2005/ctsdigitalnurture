import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    private EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100, 0})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({"2, true", "3, false", "10, true", "15, false", "-4, true", "-7, false"})
    public void testIsEvenWithCsvSource(int number, boolean expected) {
        assertEquals(expected, evenChecker.isEven(number));
    }
}
