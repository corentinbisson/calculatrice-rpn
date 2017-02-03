import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by coren on 02/02/2017.
 */



public class MainTest extends TestCase {
    Main main = new Main();
    @Test
    public void testCalculer() throws Exception {
        double d = 35;
        assertEquals(d,main.evaluer("3 4 sqrt + 10 3 - *"));
    }

}
