package junit5Testing.exercises;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class Exercise01Test {

    @Test
    void shouldGetMaxAndMin(){
        //given
        String numbers = "2 3 1 9 -4";
        //when
        String result = Exercise01.maxAndMin(numbers);
        //then
        assertThat(result,is("9 -4"));
    }

}