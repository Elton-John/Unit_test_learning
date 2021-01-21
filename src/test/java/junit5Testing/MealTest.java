package junit5Testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MealTest {

    @Test
    public void twoMealsShouldBeSameWhenPriceAndNameAreTheSame() {
        //given
        Meal meal1 = new Meal(10, "kawa");
        Meal meal2 = new Meal(10, "kawa");
        //then
        assertEquals(meal1, meal2);
    }

    @Test
    public void shouldReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(20, "bułka");
        //when
        int discountedPrice = meal.getDiscountedPrice(5);
        //then
        assertThat(discountedPrice, is(15));
    }

    @Test
    public void shouldThrowExceptionWhenDiscountIsHigherThanThePrice() {
        //given
        Meal meal = new Meal(10, "soup");
        //when //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(11));
    }

}