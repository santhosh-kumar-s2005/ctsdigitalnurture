import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertSame() {
        String str = "hello";
        String ref = str;
        assertSame(str, ref);
    }

    @Test
    public void testAssertNotSame() {
        String a = new String("hello");
        String b = new String("hello");
        assertNotSame(a, b);
    }
}
