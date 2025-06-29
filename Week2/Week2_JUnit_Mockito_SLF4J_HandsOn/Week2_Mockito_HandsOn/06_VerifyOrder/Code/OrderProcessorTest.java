import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class OrderProcessorTest {

    @Test
    public void testInteractionOrder() {
        // 1. Mock notification service
        NotificationService mockNotifier = mock(NotificationService.class);

        // 2. Use in service
        OrderProcessor processor = new OrderProcessor(mockNotifier);
        processor.processOrder();

        // 3. ✅ Verify interaction order
        InOrder inOrder = inOrder(mockNotifier);
        inOrder.verify(mockNotifier).sendEmail("Order confirmed");
        inOrder.verify(mockNotifier).sendSMS("Order shipped");
    }
}
