import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // 1. Create mock network client
        NetworkClient mockClient = mock(NetworkClient.class);

        // 2. Stub the connect() response
        when(mockClient.connect()).thenReturn("Mock Connection");

        // 3. Inject into service
        NetworkService service = new NetworkService(mockClient);
        String result = service.connectToServer();

        // 4. Assert the result
        assertEquals("Connected to Mock Connection", result);

        // 5. Verify that connect() was called
        verify(mockClient).connect();
    }
}
