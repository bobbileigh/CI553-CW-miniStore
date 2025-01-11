import static org.junit.jupiter.api.Assertions.*;

import catalogue.BetterBasket;
import catalogue.Product;
import org.junit.jupiter.api.Test;

public class clearBasketTest {

    @Test
    public void testClearBasket() {
        // Create a new BetterBasket instance
        BetterBasket br = new BetterBasket();

        // Add some products to the basket
        Product p1 = new Product("0001", "Toaster", 12.3, 1);
        Product p2 = new Product("0002", "Kettle", 12.7, 1);
        Product p3 = new Product("0003", "Microwave", 15.0, 1);

        br.add(p1);
        br.add(p2);
        br.add(p3);

        // Ensure the basket has products before clearing
        assertEquals(3, br.size(), "incorrect size before clearing");

        // Now clear the basket
        br.clearBasket();

        // Test that the basket is empty after calling clearBasket
        assertEquals(0, br.size(), "basket should be empty after clearing");
    }
}
