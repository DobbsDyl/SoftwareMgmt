package ca.sheridan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestProduct {
    @Test
    public void testSellProduct() {
        Product product = new Product("Book", 30.99, 40, 0);
        product.sellProduct(10);
        assertEquals(30, product.getQuantity());
    }

    @Test
    public void testBuyProducts() {
        Product product = new Product("Book", 30.99, 40, 0);
        product.buyProduct(10);
        assertEquals(50, product.getQuantity());
    }

    @Test
    public void testApplyDiscount() {
        Product product = new Product("Book", 100, 40, 0);
        product.applyDiscount(20);
        assertEquals(0.2, product.getDiscount());
        assertEquals(80, product.getPrice());
    }

    @Test
    public void testRemoveDiscount() {
        Product product = new Product("Book", 80, 40, 0.2);
        product.removeDiscount();
        assertEquals(100, product.getPrice());
        assertEquals(0, product.getDiscount());
    }

    @Test
    public void testSetPrice() {
        Product product = new Product("Book", 30.99, 40, 0);
        product.setPrice(40.99);
        assertEquals(40.99, product.getPrice());
    }

    @Nested
    class TestNegativeCases {

        @Test
        public void testSellProductNegative() {
            Product product = new Product("Book", 100, 40, 0);
            assertThrows(RuntimeException.class, ()-> product.sellProduct(50));
        }

        @Test
        public void testBuyProductNegative() {
            Product product = new Product("Book", 100, 40, 0);
            assertThrows(RuntimeException.class, ()-> product.buyProduct(-10));
        }

        @Test
        public void testApplyDiscountNegative() {
            Product product = new Product("Book", 100, 40, 0);
            assertThrows(RuntimeException.class, ()-> product.applyDiscount(-10));
        }

        @Test
        public void testSetPriceNegative() {
            Product product = new Product("Book", 100, 40, 0);
            assertThrows(RuntimeException.class, ()-> product.setPrice(-10));
        }
    }

}
