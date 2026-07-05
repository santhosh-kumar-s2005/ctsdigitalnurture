import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VoidMethodExceptionTest {

    @Test
    public void testVoidMethodThrowsRuntimeException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Send failed")).when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> service.sendData("data"));
    }

    @Test
    public void testVoidMethodThrowsIllegalArgumentException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new IllegalArgumentException("Invalid data")).when(mockApi).sendData("bad");

        MyService service = new MyService(mockApi);

        assertThrows(IllegalArgumentException.class, () -> service.sendData("bad"));
    }

    @Test
    public void testVoidMethodThrowsOnlyForSpecificArgument() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Error")).when(mockApi).processData("invalid");
        doNothing().when(mockApi).processData("valid");

        MyService service = new MyService(mockApi);

        assertDoesNotThrow(() -> service.processData("valid"));
        assertThrows(RuntimeException.class, () -> service.processData("invalid"));
    }

    @Test
    public void testVoidMethodExceptionMessageIsCorrect() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Connection timeout")).when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.sendData("payload"));
        assertEquals("Connection timeout", ex.getMessage());

        verify(mockApi).sendData("payload");
    }
}
