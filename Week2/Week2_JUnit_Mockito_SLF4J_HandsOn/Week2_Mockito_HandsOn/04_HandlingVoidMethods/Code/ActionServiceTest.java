import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ActionServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        // 1. Mock the void-using dependency
        Logger mockLogger = mock(Logger.class);

        // 2. Stub the void method (optional if not throwing)
        doNothing().when(mockLogger).log(anyString());

        // 3. Inject into service
        ActionService service = new ActionService(mockLogger);
        service.performAction("MockTask");

        // 4. ✅ Verify that void method was called
        verify(mockLogger).log(eq("Action performed: MockTask"));
    }
}
