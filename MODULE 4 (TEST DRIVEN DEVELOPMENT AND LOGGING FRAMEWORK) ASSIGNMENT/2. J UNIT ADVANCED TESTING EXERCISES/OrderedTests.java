import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    private static int counter = 0;

    @Test
    @Order(1)
    public void firstTest() {
        counter++;
        assertEquals(1, counter);
    }

    @Test
    @Order(2)
    public void secondTest() {
        counter++;
        assertEquals(2, counter);
    }

    @Test
    @Order(3)
    public void thirdTest() {
        counter++;
        assertEquals(3, counter);
    }

    @Test
    @Order(4)
    public void fourthTest() {
        counter++;
        assertEquals(4, counter);
    }
}
