package junit5Testing.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

class OrderStatusTest {

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void orderStatusShouldBeShortThan15Chars(OrderStatus status) {
        assertThat(status.toString().length(), lessThan(15));
    }


}