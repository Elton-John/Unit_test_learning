package test02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @BeforeEach
    public void setUp() {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        //given
        int a = 5;
        int b = 2;
        int expected = 7;
        //when
        int valueToCheck = simpleCalculator.add(a, b);
        //then
        assertThat(valueToCheck, is(expected));
    }

    // @Test(expected = IllegalArgumentException.class)
    @Test
    public void shouldAddOnlyPositiveAndThrowIfOneOfTwoIsNegative() {
        //given
        int positive = 5;
        int negative = -5;
        int expected = 10;
        //when
        int addPositive = simpleCalculator.addPositive(positive, positive);
        //then
        assertThat(addPositive, is(expected));
        assertThrows(IllegalArgumentException.class, () -> simpleCalculator.addPositive(positive, negative));
        assertThrows(IllegalArgumentException.class, () -> simpleCalculator.addPositive(negative, positive));
        // simpleCalculator.addPositive(positive, negative);
        // simpleCalculator.addPositive(negative, positive);

    }
}