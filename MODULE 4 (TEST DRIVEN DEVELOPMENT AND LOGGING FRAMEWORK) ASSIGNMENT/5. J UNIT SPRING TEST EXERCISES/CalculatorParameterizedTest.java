import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParameterizedTest {

    private CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 5, 10",
        "0, 0, 0",
        "-3, 3, 0",
        "100, 200, 300"
    })
    public void testAdd(int a, int b, int expected) {
        int result = calculatorService.add(a, b);
        assertEquals(expected, result);
    }
}
