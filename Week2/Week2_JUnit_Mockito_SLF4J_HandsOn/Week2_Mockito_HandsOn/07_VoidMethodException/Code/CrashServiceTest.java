import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CrashServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        // 1. Create mock
        Logger mockLogger = mock(Logger.class);

        // 2. Stub to throw exception
        doThrow(new RuntimeException("Logger failure"))
                .when(mockLogger)
                .log("CRITICAL ERROR");

        // 3. Inject and test
        CrashService service = new CrashService(mockLogger);

        // 4. Assert exception is thrown
        assertThrows(RuntimeException.class, () -> {
            service.crashOperation();
        });
    }
}
