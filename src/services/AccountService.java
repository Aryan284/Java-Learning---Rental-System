package services;

import Exceptions.AccountDoesNotExistsException;
import main.model.Account;
import main.model.AccountType;


public interface AccountService {
    Account createAccount(Account account, AccountType accountType);
    void resetPassword(String userId, String password, AccountType accountType) throws AccountDoesNotExistsException;
}
