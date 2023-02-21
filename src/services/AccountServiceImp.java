package services;

import Exceptions.AccountDoesNotExistsException;
import main.model.Account;
import main.model.AccountType;
import repository.AccountRepository;
import repository.AccountRepositoryFactory;

public class AccountServiceImp implements AccountService{
    public Account createAccount(Account account, AccountType accountType){
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository(accountType);
        return accountRepository.createAccount(account);
    }
    public void resetPassword(String userId, String password, AccountType accountType) throws AccountDoesNotExistsException{
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository(accountType);
        accountRepository.resetPassword(userId, password);

    }


}
