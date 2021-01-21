package test01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondClassForTestingTest {

    @Test
    public void getSum() {
        int a = 5;
        int b = 4;
        assertEquals(9, SecondClassForTesting.getSum(a,b));
    }


}