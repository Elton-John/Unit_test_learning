package test01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstClassForTestingTest {


    @Test
    public void test() {
        assertEquals(4, 2 * 2);
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