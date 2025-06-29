import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PollingServiceTest {

    @Test
    public void testMultipleReturns() {
        // 1. Mock external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub multiple returns
        when(mockApi.getData())
                .thenReturn("First Response")
                .thenReturn("Second Response");

        // 3. Inject and call
        PollingService service = new PollingService(mockApi);
        String result = service.pollTwice();

        // 4. Assert final result
        assertEquals("First Response | Second Response", result);
    }
}
