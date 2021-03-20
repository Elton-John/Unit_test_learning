package junit5Testing.revision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


class CalculatorTest {
   private  Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldGetRestOfDivision() {
    //given
        int a = 22;
        int b = 10;
        int expected = 2;

    //when
        int result = calculator.getRestOfDivision(a, b);

    //then
        assertThat(result, is(expected));
    }

    @Test
    public void shouldThrowWhenDivideByZero() {
    //given
        Calculator calculator = new Calculator();
        int a = 22;
        int b = 0;
    //when  //then
        assertThrows(ArithmeticException.class, () -> calculator.getRestOfDivision(a, b));
    }

}