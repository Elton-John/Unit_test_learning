package junit5Testing;

import junit5Testing.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void clear(){
        orders.clear();
    }

    public void simulateManyOrders(){
        for (int i = 0; i < 1000; i++) {
            Order order = new Order();
            Meal meal = new Meal(i, "Burger N "+i);
            order.addMealToOrder(meal);
            addOrder(order);
        }
        System.out.println("Cart size: " + orders.size());
        clear();
    }
}
