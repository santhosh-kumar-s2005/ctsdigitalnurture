import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VoidMethodsTest {

    @Test
    public void testVoidMethodDoNothing() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);
        service.sendData("payload");

        verify(mockApi).sendData("payload");
    }

    @Test
    public void testVoidMethodCalledWithSpecificArgument() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.sendData("importantData");

        verify(mockApi, times(1)).sendData("importantData");
    }

    @Test
    public void testVoidMethodNeverCalled() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        verify(mockApi, never()).sendData(anyString());
    }

    @Test
    public void testProcessDataCalled() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).processData(anyString());

        MyService service = new MyService(mockApi);
        service.processData("processThis");

        verify(mockApi).processData("processThis");
    }
}
