import org.junit.Test;

import static org.junit.Assert.*;

public class SecondClassForTestingTest {

    @Test
    public void getSum() {
        int a = 5;
        int b = 4;
        assertEquals(9,SecondClassForTesting.getSum(a,b));
    }


}