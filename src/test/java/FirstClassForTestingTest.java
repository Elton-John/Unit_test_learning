import org.junit.Test;

import static org.junit.Assert.*;

public class FirstClassForTestingTest {

    @Test
    public void getHalf() {
        String test = "Kukułka";
        assertEquals("Kuk", FirstClassForTesting.getHalf(test));
    }

    @Test
    public void test() {
        assertEquals(4, 2*2);
    }
}