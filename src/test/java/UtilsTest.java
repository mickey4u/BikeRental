import junit.framework.TestCase;
import org.junit.Test;
import utilities.Utils;

public class UtilsTest extends TestCase {
    Utils utils = new Utils();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testUtils() {
        String id = utils.createBookingID();
        assertNotNull(id);
    }
}
