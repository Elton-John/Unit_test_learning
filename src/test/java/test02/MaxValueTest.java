package test02;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MaxValueTest {

    @Test
    public void shouldReturnLargestFromArray() {
        //given
        int[] arrayDesc = {1, 2, 3};
        int[] arrayAsc = {3, 2, 1};
        int[] arrayWithNegative = {3, 2, 1, -4};
        int expected = 3;
        //when
        int valueToCheckDesc = MaxValue.largest(arrayDesc);
        int valueToCheckAsc = MaxValue.largest(arrayAsc);
        int valueToCheckWithNegative = MaxValue.largest(arrayWithNegative);
        //then
        assertThat(valueToCheckDesc, is(expected));
        assertThat(valueToCheckAsc, is(expected));
        assertThat(valueToCheckWithNegative, is(expected));

    }


    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenArrayIsEmpty() {
        //given
        int[] emptyArray = {};
        //when //then
        MaxValue.largest(emptyArray);

    }
}