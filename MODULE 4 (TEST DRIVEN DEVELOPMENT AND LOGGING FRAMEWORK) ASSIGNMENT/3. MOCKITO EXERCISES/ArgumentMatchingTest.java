import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArgumentMatchingTest {

    @Test
    public void testAnyIntArgumentMatcher() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getDataById(anyInt())).thenReturn("Generic Data");

        MyService service = new MyService(mockApi);

        assertEquals("Generic Data", service.fetchDataById(1));
        assertEquals("Generic Data", service.fetchDataById(99));
        assertEquals("Generic Data", service.fetchDataById(-5));
    }

    @Test
    public void testAnyStringArgumentMatcher() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchRecord(anyString())).thenReturn("Record Found");

        MyService service = new MyService(mockApi);

        assertEquals("Record Found", service.fetchRecord("key1"));
        assertEquals("Record Found", service.fetchRecord("anything"));
    }

    @Test
    public void testExactArgumentMatcher() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchRecord(eq("specificKey"))).thenReturn("Specific Record");

        MyService service = new MyService(mockApi);

        assertEquals("Specific Record", service.fetchRecord("specificKey"));
        assertNull(service.fetchRecord("otherKey"));
    }

    @Test
    public void testVerifyWithArgumentMatcher() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.sendData("testPayload");

        verify(mockApi).sendData(eq("testPayload"));
    }

    @Test
    public void testVerifyWithAnyMatcher() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.sendData("anyValue");

        verify(mockApi).sendData(anyString());
    }
}
