import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataById(anyString())).thenReturn("Mocked Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("ABC123");

        // Verify that the method was called with any string
        verify(mockApi).getDataById(eq("ABC123"));
    }
}
