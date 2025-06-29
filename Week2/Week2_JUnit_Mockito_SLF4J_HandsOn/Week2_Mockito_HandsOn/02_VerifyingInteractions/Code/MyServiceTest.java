import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Mock the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub method (optional if return value is unused)
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Call method on service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 4. ✅ Verify interaction happened
        verify(mockApi).getData();
    }
}
