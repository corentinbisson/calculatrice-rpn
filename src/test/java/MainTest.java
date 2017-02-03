import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by coren on 02/02/2017.
 */



public class MainTest extends TestCase {
    Main main = new Main();
    @Test
    public void testEvaluerOk() throws Exception {
        double d = 35;
        assertEquals(d,main.evaluer("3 4 sqrt + 10 3 - *"));
    }

    @Test
    public void testEvaluerBadArgument() throws Exception {
        assertEquals(Double.NaN,main.evaluer("bonjour sqrt camion 9 * + 5"));
    }

    @Test
    public void testEvaluerBadCalcul() throws Exception {
        assertEquals(Double.NaN,main.evaluer("3 + 5"));
    }

    @Test
    public void testEvaluerCalculNonTermine() throws Exception {
        assertEquals(Double.NaN,main.evaluer("3 4 sqrt"));
    }

    public void testEvaluerEulerNegatif() throws Exception {
        assertEquals(Double.NaN,main.evaluer("-3 !"));
    }

}
