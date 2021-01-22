package junit5Testing.order;

import junit5Testing.order.ORDER_STATUS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

class ORDER_STATUSTest {

    @ParameterizedTest
    @EnumSource(ORDER_STATUS.class)
    void orderStatusShouldBeShortThan15Chars(ORDER_STATUS status) {
        assertThat(status.toString().length(), lessThan(15));
    }


}