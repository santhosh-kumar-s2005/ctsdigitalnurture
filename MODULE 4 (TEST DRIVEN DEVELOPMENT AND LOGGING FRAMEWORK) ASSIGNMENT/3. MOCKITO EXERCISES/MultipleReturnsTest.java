import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultipleReturnsTest {

    @Test
    public void testConsecutiveReturnValues() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Third", service.fetchData());
    }

    @Test
    public void testLastReturnValueRepeats() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    public void testMultipleReturnsInFetchMultipleTimes() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("A")
                .thenReturn("B")
                .thenReturn("C");

        MyService service = new MyService(mockApi);
        String result = service.fetchMultipleTimes();

        assertEquals("A,B,C", result);
    }

    @Test
    public void testReturnThenThrow() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("ValidData")
                .thenThrow(new RuntimeException("API failed"));

        MyService service = new MyService(mockApi);

        assertEquals("ValidData", service.fetchData());
        assertThrows(RuntimeException.class, () -> service.fetchData());
    }
}
