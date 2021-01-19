package test02;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FirstTest {

    @Test
    public void shouldConcatString() {
        //given
        String a = "ma";
        String b = "ma";
        String expected = "mama";
        //when
        String valueToCheck = First.concatString(a, b);
        //then
        assertEquals("should be concat", expected, valueToCheck);
    }

    @Test
    public void shouldMultiplyTwoNumbers() {
        //given
        double a = 2.0;
        double b = 1.5;
        double expected = 3.0;
        //when
        double valueToCheck = First.multiply(a, b);
        //then
        assertEquals(expected, valueToCheck, 0.1);
    }

    @Test
    public void shouldConcatStringWithHamcrest() {
        //given
        String a = "ma";
        String b = "ma";
        String expected = "mama";
        //when
        String valueToCheck = First.concatString(a, b);
        //then
       assertThat(valueToCheck, is(expected));
    }

    @Test
    public void shouldMultiplyTwoNumbersWithHamcrest() {
        //given
        double a = 2.0;
        double b = 1.5;
        double expected = 3.0;
        //when
        double valueToCheck = First.multiply(a, b);
        //then
       assertThat(valueToCheck, is(expected));
    }
}