package junit5Testing;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void newAccountShouldBeNotActive(){
        //given // when
        Account account = new Account();
        //then
        assertFalse(account.isActive());
        assertThat(account.isActive(), is(false));
    }

    @Test
    public void accountShouldBeActiveAfterActivate(){
        //given
        Account account = new Account();
        //when
        account.activate();
        //then
        assertTrue(account.isActive());
        assertThat(account.isActive(), is(true));
    }

    @Test
    public void newlyCreateAccountShouldNotHaveAddressSet(){
        //given
        Account account = new Account();
        //then
        assertNull(account.getAddress());
        assertThat(account.getAddress(), nullValue());
    }

    @Test
    public void accountShouldNotBeNullWhenAddressSet(){
        //given
        Account account = new Account();
        Address address = new Address("Popowicka", "Wrocław");
        //when
        account.setAddress(address);
        //then
        assertNotNull(account.getAddress());
        assertThat(account.getAddress(), notNullValue());
    }
}