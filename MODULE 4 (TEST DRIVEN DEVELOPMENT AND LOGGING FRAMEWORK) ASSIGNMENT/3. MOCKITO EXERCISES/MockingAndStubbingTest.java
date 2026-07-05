import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MockingAndStubbingTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testExternalApiWithId() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getDataById(1)).thenReturn("Data for ID 1");
        when(mockApi.getDataById(2)).thenReturn("Data for ID 2");

        MyService service = new MyService(mockApi);

        assertEquals("Data for ID 1", service.fetchDataById(1));
        assertEquals("Data for ID 2", service.fetchDataById(2));
    }

    @Test
    public void testStubbingWithNullReturn() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn(null);

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertNull(result);
    }
}
