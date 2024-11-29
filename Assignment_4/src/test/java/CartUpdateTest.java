import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class CartUpdateTest extends TestCase {

    Customer test_cust = new Customer("abc", "xyz");
    Product item_NA = new Product("na product", 1, false);
    Product item_AV = new Product("na product", 1, true);

    @Test
    public void testUnavailable() {
        assertThrows(ItemNotAvailableError.class,
                () -> {
                    Customer.cartUpdate(item_NA, 1, test_cust);
                });
    }

    @Test
    public void testAvailable() {
        try {
            Customer.cartUpdate(item_AV, 1, test_cust);
        } catch (ItemNotAvailableError e) {
            fail("ItemNotAvailableError was not expected but thrown");
        }
    }
}