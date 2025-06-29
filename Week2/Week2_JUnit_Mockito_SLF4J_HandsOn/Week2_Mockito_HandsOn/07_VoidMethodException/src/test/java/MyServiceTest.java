import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doThrow(new RuntimeException("Danger!")).when(mockApi).riskyCall();

        MyService service = new MyService(mockApi);

        RuntimeException ex = assertThrows(RuntimeException.class, service::execute);
        assertEquals("Danger!", ex.getMessage());

        verify(mockApi).riskyCall();
    }
}
