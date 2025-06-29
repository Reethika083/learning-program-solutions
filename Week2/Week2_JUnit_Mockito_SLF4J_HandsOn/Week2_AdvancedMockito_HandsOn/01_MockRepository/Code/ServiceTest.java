import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // 1. Create mock
        Repository mockRepository = mock(Repository.class);

        // 2. Stub return
        when(mockRepository.getData()).thenReturn("Mock Data");

        // 3. Inject into service
        Service service = new Service(mockRepository);
        String result = service.processData();

        // 4. Assert result
        assertEquals("Processed Mock Data", result);

        // 5. Optional: verify interaction
        verify(mockRepository).getData();
    }
}
