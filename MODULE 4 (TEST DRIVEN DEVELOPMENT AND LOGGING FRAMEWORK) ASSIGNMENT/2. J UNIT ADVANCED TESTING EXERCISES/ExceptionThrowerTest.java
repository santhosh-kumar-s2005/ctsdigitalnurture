import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    private ExceptionThrower thrower;

    @BeforeEach
    public void setUp() {
        thrower = new ExceptionThrower();
    }

    @Test
    public void testThrowsNullPointerException() {
        NullPointerException ex = assertThrows(NullPointerException.class, () -> {
            thrower.throwException(null);
        });
        assertEquals("Input cannot be null", ex.getMessage());
    }

    @Test
    public void testThrowsIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("");
        });
        assertEquals("Input cannot be empty", ex.getMessage());
    }

    @Test
    public void testThrowsRuntimeException() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            thrower.throwException("runtime");
        });
        assertEquals("Runtime error triggered", ex.getMessage());
    }

    @Test
    public void testThrowsArithmeticException() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
            thrower.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", ex.getMessage());
    }

    @Test
    public void testNoExceptionForValidInput() {
        assertDoesNotThrow(() -> thrower.throwException("valid"));
    }

    @Test
    public void testDivideNoException() {
        assertDoesNotThrow(() -> thrower.divide(10, 2));
    }
}
