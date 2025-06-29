import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {
        // 1. Mock the repository
        Repository mockRepo = mock(Repository.class);

        // 2. Stub different return values
        when(mockRepo.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // 3. Inject into service
        Service service = new Service(mockRepo);

        // 4. Call twice and assert both
        String first = service.processData();
        String second = service.processData();

        assertEquals("Processed First Mock Data", first);
        assertEquals("Processed Second Mock Data", second);

        // 5. Verify called twice
        verify(mockRepo, times(2)).getData();
    }
}
