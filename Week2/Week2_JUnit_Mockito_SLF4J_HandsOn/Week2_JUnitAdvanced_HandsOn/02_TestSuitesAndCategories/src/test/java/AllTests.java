import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        MathUtilsAdditionTest.class,
        MathUtilsMultiplicationTest.class
})
public class AllTests {
}
