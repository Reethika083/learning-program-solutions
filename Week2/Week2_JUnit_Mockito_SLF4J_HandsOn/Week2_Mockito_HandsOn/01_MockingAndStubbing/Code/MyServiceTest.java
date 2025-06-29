import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Mock the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub its method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject mock into service
        MyService service = new MyService(mockApi);

        // 4. Call method and verify output
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}
