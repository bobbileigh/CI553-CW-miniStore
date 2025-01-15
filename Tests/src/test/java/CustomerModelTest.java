/**package clients.customer;

import clients.Setup;
import middle.LocalMiddleFactory;
import middle.MiddleFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import catalogue.Basket;
import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerModelTest {
    private CustomerModel model;
    private TestObserver observer;
    private static MiddleFactory factory;

    private class TestObserver implements Observer {
        public String lastMessage;

        @Override
        public void update(java.util.Observable o, Object arg) {
            lastMessage = (String) arg;
        }
    }

    @BeforeAll
    static void setUpClass() {
        // Initialize database before any tests run
        Setup.main(new String[]{});
        factory = new LocalMiddleFactory();
    }

    @BeforeEach
    void setUp() throws Exception {
        model = new CustomerModel(factory);
        observer = new TestObserver();
        model.addObserver(observer);
    }

    @Test
    void testSearchByProductNumber() {
        // Test searching by product number
        model.doCheck("0003");  // Toaster's product number

        assertFalse(model.getBasket().isEmpty(), "Basket should not be empty");
        assertTrue(observer.lastMessage.contains("Toaster"),
                "Message should contain product description");
    }

    @Test
    void testSearchNonExistentProduct() {
        model.doCheck("9999");

        assertTrue(model.getBasket().isEmpty(), "Basket should be empty");
        assertTrue(observer.lastMessage.contains("Unknown product"),
                "Should show unknown product message");
    }
}
 */