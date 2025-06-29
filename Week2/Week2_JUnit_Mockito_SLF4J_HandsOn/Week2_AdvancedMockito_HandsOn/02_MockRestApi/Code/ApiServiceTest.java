import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // 1. Mock REST client
        RestClient mockClient = mock(RestClient.class);

        // 2. Stub the API response
        when(mockClient.getResponse()).thenReturn("Mock Response");

        // 3. Inject into service
        ApiService apiService = new ApiService(mockClient);
        String result = apiService.fetchData();

        // 4. Assert result
        assertEquals("Fetched Mock Response", result);

        // 5. Verify interaction (optional)
        verify(mockClient).getResponse();
    }
}
