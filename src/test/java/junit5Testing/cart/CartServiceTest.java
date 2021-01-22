package junit5Testing.cart;

import junit5Testing.order.Order;
import junit5Testing.order.OrderStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @Test
    void shouldChangeOrderStatusToPreparingWhenCartCanHandle() {
        //given
        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrder(order);
        given(cartHandler.canHandleCart(cart)).willReturn(true);

        //when
        cartService.processCart(cart);

        //then
//        verify(cartHandler).canHandleCart(cart);
//        verify(cartHandler).sendToPrepare(cart);

//        then(cartHandler).should().canHandleCart(cart);
//        then(cartHandler).should().sendToPrepare(cart);

        InOrder inOrder = inOrder(cartHandler);
        inOrder.verify(cartHandler).canHandleCart(cart);
        inOrder.verify(cartHandler, atLeastOnce()).sendToPrepare(cart);

        assertEquals(cart.getOrders().get(0).getOrderStatus(), OrderStatus.PREPARING);
    }


    @Test
    void shouldChangeOrderStatusToRejectedWhenCartCanHandleIsFalse() {
        //given
        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrder(order);
        given(cartHandler.canHandleCart(cart)).willReturn(false);

        //when
        cartService.processCart(cart);

        //then
        verify(cartHandler).canHandleCart(cart);
        verify(cartHandler, never()).sendToPrepare(cart);

//        then(cartHandler).should().canHandleCart(cart);
//        then(cartHandler).should().sendToPrepare(cart);

        assertEquals(cart.getOrders().get(0).getOrderStatus(), OrderStatus.REJECTED);
    }
}