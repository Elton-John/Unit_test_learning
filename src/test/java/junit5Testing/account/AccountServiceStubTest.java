package junit5Testing.account;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceStubTest {

    @Test
    void shouldGetAllActiveAccounts() {
        //given
        AccountRepository accountRepositoryStub = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepositoryStub);

        //when
        List<Account> allActiveAccounts = accountService.getAllActiveAccounts();

        //then
        allActiveAccounts.forEach(account -> assertTrue(account.isActive()));
    }
}