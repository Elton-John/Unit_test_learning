package test02;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


    //  @Test(expected = RuntimeException.class)
    @Test
    public void shouldThrowExceptionWhenArrayIsEmpty() {
        //given
        int[] emptyArray = {};
        //when //then
        // MaxValue.largest(emptyArray);
        assertThrows(RuntimeException.class, () -> MaxValue.largest(emptyArray));

    }
}