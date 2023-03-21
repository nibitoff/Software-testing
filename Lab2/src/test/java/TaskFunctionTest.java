import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TaskFunctionTest {
    @BeforeAll
    public static void initTest() {
        System.out.println("test init");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void simpleTest(int value) {
        System.out.println(value);
    }
}
