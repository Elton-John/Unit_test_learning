package junit5Testing.cart;

import junit5Testing.cart.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Cart tests:")
class CartTest {

    //@Disabled
    @DisplayName("Cart is able to process 1000 orders in 100 ms")
    @Test
    void simulateManyOrders() {
        //given
        Cart cart = new Cart();

        //when //then
        assertTimeout(Duration.ofMillis(100), cart::simulateManyOrders);
    }
}