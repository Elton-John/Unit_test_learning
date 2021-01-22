package junit5Testing.cart;

import junit5Testing.order.OrderStatus;

public class CartService {

    private CartHandler cartHandler;

    public CartService(CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    Cart processCart(Cart cart) {
        if (cartHandler.canHandleCart(cart)) {
            cartHandler.sendToPrepare(cart);
            cart.getOrders().forEach(order -> order.setOrderStatus(OrderStatus.PREPARING));
        } else {
            cart.getOrders().forEach(order -> order.setOrderStatus(OrderStatus.REJECTED));
        }
        return cart;
    }
}
