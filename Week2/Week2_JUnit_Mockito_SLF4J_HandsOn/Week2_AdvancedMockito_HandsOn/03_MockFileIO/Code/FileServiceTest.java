import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // 1. Create mocks
        FileReader mockReader = mock(FileReader.class);
        FileWriter mockWriter = mock(FileWriter.class);

        // 2. Stub the read
        when(mockReader.read()).thenReturn("Mock File Content");

        // 3. Inject mocks into service
        FileService service = new FileService(mockReader, mockWriter);
        String result = service.processFile();

        // 4. Assert final result
        assertEquals("Processed Mock File Content", result);

        // 5. Verify that write was called with processed data
        verify(mockWriter).write("Processed Mock File Content");
    }
}
