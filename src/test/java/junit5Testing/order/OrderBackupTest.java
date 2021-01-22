package junit5Testing.order;


import junit5Testing.Meal;
import junit5Testing.order.Order;
import junit5Testing.order.OrderBackup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @Test
    public void shouldAppendOrderToFile() throws IOException {
        //given
        Order order = new Order();
        Meal meal = new Meal(10, "burger");
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println(order.toString() + "backed up");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

}