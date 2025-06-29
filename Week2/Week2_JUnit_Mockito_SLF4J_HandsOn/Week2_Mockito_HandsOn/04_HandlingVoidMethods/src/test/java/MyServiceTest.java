import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        ExternalLogger mockLogger = mock(ExternalLogger.class);

        MyService service = new MyService(mockLogger);
        service.process();

        // Verify that log was called with the correct message
        verify(mockLogger).log("Processing completed");
    }
}
