import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTesterTest {

    private PerformanceTester tester;

    @BeforeEach
    public void setUp() {
        tester = new PerformanceTester();
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testPerformTaskCompletesWithinTimeout() {
        tester.performTask();
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testComputeSumCompletesWithinTimeout() {
        int result = tester.computeSum(100000);
        assertEquals(5000050000L, (long) result, 1);
    }

    @Test
    public void testSlowTaskExceedsTimeout() {
        assertThrows(Exception.class, () -> {
            tester.performSlowTask();
        });
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testPerformTaskFastEnough() {
        assertDoesNotThrow(() -> tester.performTask());
    }
}
