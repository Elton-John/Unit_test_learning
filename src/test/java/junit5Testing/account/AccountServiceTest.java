package junit5Testing.account;

import junit5Testing.Address;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Test
    void shouldGetAllActiveAccounts() {
        //given
        List<Account> accounts = prepareAccountList();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        //when(accountRepository.getAllAccounts()).thenReturn(accounts);
        given(accountRepository.getAllAccounts()).willReturn(accounts);

        //when
        List<Account> allActiveAccounts = accountService.getAllActiveAccounts();

        //then
        allActiveAccounts.forEach(account -> assertTrue(account.isActive()));
        assertThat(allActiveAccounts, hasSize(2));
    }

    private List<Account> prepareAccountList() {
        Address address1 = new Address("Zeromskiego", "77");
        Account activeAccount1 = new Account(address1);

        Address address2 = new Address("Piłsudskiego", "88");
        Account activeAccount2 = new Account(address2);

        Account nonActivatedAccount = new Account();

        return Arrays.asList(activeAccount1, activeAccount2, nonActivatedAccount);
    }
}
