package test02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @Before
    public void setUp() {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void shouldReturnSumOfThoNumbers() {
        //given
        int a = 5;
        int b = 2;
        int expected = 7;
        //when
        int valueToCheck = simpleCalculator.add(a, b);
        //then
        assertThat(valueToCheck, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddOnlyPositiveAndThrowIfOneOfThoIsNegative() {
        //given
        int positive = 5;
        int negative = -5;
        int expected = 10;
        //when
        int addPositive = simpleCalculator.addPositive(positive, positive);
        //then
        assertThat(addPositive, is(expected));
        simpleCalculator.addPositive(positive, negative);
        simpleCalculator.addPositive(negative, positive);

    }
}