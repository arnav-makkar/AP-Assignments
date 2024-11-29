import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LoginTest {
    @Test
    public void checkBothNull() {
        assertFalse(Customer.checkUserExists("", ""));
    }

    @Test
    public void checkNameNull() {
        assertFalse(Customer.checkUserExists("", "ABC"));
    }

    @Test
    public void checkPWNull() {
        assertFalse(Customer.checkUserExists("ABC", ""));
    }

    @Test
    public void correctCred(){
        assertTrue(Customer.checkUserExists("Arvind", "Arvind123"));
    }

    @Test
    public void correctCredVIP(){
        assertTrue(Customer.checkUserExists("Sarthak", "Sarthak123"));
    }

    @Test
    public void incorrectCred(){
        assertFalse(Customer.checkUserExists("Arvind", "123"));
    }
}