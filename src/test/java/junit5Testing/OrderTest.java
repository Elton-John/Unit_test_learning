package junit5Testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void initialOrder() {
        order = new Order();
    }

    @AfterEach
    void cleanUp(){
        order.cancel();
    }

    @Test
    void newlyCreatedOrderShouldHaveEmptyListOfMealsSet() {
        //when
        List<Meal> meals = order.getMeals();
        //then
        assertThat(meals, empty());
    }

    @Test
    void addingMealToOrderShouldIncreaseMealList() {
        //given
        Meal meal = new Meal(10, "pizza");
        //when
        order.addMealToOrder(meal);
        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));
    }

    @Test
    void removingMealFromOrderShouldDecreaseMealList() {
        //given
        Meal meal = new Meal(10, "pizza");
        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);
        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals(), not(contains(meal)));
        assertThat(order.getMeals(), not(hasItem(meal)));
    }
}