package repository;

import Exceptions.AccountDoesNotExistsException;
import main.model.Account;

public interface AccountRepository {
    Account createAccount(Account account);
    void resetPassword(String userId, String  password) throws AccountDoesNotExistsException;

}
