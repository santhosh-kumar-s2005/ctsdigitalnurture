import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

public class InteractionOrderTest {

    @Test
    public void testMethodsCalledInOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Data");

        MyService service = new MyService(mockApi);
        service.performOrderedOperations("payload");

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("payload");
        inOrder.verify(mockApi).processData("payload");
    }

    @Test
    public void testInOrderAcrossMultipleMocks() {
        ExternalApi mockApi1 = Mockito.mock(ExternalApi.class);
        ExternalApi mockApi2 = Mockito.mock(ExternalApi.class);

        when(mockApi1.getData()).thenReturn("From API 1");
        when(mockApi2.getData()).thenReturn("From API 2");

        mockApi1.getData();
        mockApi2.getData();

        InOrder inOrder = inOrder(mockApi1, mockApi2);
        inOrder.verify(mockApi1).getData();
        inOrder.verify(mockApi2).getData();
    }

    @Test
    public void testNoMoreInteractionsAfterVerified() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Data");

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
        verifyNoMoreInteractions(mockApi);
    }
}
