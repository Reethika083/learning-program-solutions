import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub behavior (optional)
        when(mockApi.process(anyString())).thenReturn("OK");

        // 3. Use the mock through service
        MyService service = new MyService(mockApi);
        service.handle("hello");

        // 4. 🎯 Verify that method was called with "hello"
        verify(mockApi).process(eq("hello"));
    }
}
