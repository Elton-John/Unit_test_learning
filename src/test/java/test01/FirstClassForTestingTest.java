package test01;

import org.junit.Test;
import test01.FirstClassForTesting;

import static org.junit.Assert.*;

public class FirstClassForTestingTest {


    @Test
    public void test() {
        assertEquals(4, 2*2);
    }

    @Test
    public void getFirstHalf() {
        String test = "Kukułka";
        assertEquals("Kuk", FirstClassForTesting.getFirstHalf(test));
    }

    @Test
    public void getSecondHalf() {
        String test = "Kukułka";
        assertEquals("ułka", FirstClassForTesting.getSecondHalf(test));
    }
}