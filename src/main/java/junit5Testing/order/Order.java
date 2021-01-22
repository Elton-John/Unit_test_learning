package junit5Testing.order;

import junit5Testing.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {


    private List<Meal> meals = new ArrayList<>();
    private OrderStatus orderStatus;

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    List<Meal> getMeals() {
        return meals;
    }

    void cancel(){
        this.meals.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
