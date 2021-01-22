package junit5Testing.account;

import junit5Testing.Address;

import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {
    @Override
    public List<Account> getAllAccounts() {
        Address address1 = new Address("Zeromskiego", "77");
        Account activeAccount1 = new Account(address1);

        Address address2 = new Address("Piłsudskiego", "88");
        Account activeAccount2 = new Account(address2);

        Account nonActivatedAccount = new Account();

        return Arrays.asList(activeAccount1,activeAccount2,nonActivatedAccount);
    }
}
