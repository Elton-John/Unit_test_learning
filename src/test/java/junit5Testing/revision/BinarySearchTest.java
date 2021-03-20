package junit5Testing.revision;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    public void shouldGetIndexOfKeyValue(){
        //given
        int[] arr = {1,2,3,4};
        int key = 1;
        //when
        int index = BinarySearch.binarySearch(arr,key);
        //then
        assertThat(index, is(0));
    }

    @Test
    public void  shouldThrowsIfArrayIsNotSorted(){
        //given
        int[] notSortedArr = {4,1,2,3};
        //when // then
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearch(notSortedArr,2));

    }

    @Test
    public void shouldGetMinusOneIfKeyIsNotFound(){
        //given
        int[] arr = {1,2,3};
        int key = 4;
        //when
        int result = BinarySearch.binarySearch(arr, key);
        //then
        assertThat(result, is(-1));
    }

}