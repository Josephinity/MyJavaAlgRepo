/**
 * Created by xiaobaby on 2/3/16.
 *
 * JUnit Testing
 */
import org.junit.runner.*;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
public class MyTest {
    @Test
    public void testExceptionIsThrown() {
        Run tester = new Run();
        //write a method here that throws Exception
    }
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {

        // MyClass is tested
        Run tester = new Run();

        // assert statements
        assertEquals("10 x 0 must be 0", 0,0);
        assertTrue("deadloop",true);
        fail("happy");
    }

}
