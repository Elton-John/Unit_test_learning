package junit5Testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(BeforeAfterExtension.class)
class MealTest {

    @Test
    void twoMealsShouldBeSameWhenPriceAndNameAreTheSame() {
        //given
        Meal meal1 = new Meal(10, "kawa");
        Meal meal2 = new Meal(10, "kawa");
        //then
        assertEquals(meal1, meal2);
    }

    @Test
     void shouldReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(20, "bułka");
        //when
        int discountedPrice = meal.getDiscountedPrice(5);
        //then
        assertThat(discountedPrice, is(15));
    }

    @Test
    void shouldThrowExceptionWhenDiscountIsHigherThanThePrice() {
        //given
        Meal meal = new Meal(10, "soup");
        //when //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(11));
    }

    @ParameterizedTest
    @ValueSource(ints = {10,15,18})
    void priceShouldBeLowerThan20(int price){
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNamesShouldEndWithCake(String cakeName){
        assertThat(cakeName, endsWith("cake"));
    }

    private static Stream<String> createCakeNames(){
        List<String> names = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return names.stream();
    }

}