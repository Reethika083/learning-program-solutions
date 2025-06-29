import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Simulate different return values
        when(mockApi.fetchStatus())
                .thenReturn("Loading")
                .thenReturn("In Progress")
                .thenReturn("Completed");

        MyService service = new MyService(mockApi);

        assertEquals("Loading", service.getStatus());
        assertEquals("In Progress", service.getStatus());
        assertEquals("Completed", service.getStatus());
    }
}
