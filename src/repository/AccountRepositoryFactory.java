package repository;

import main.model.AccountType;
import main.model.Driver;

public class AccountRepositoryFactory {
    public static AccountRepository getAccountRepository(AccountType accountType){
        switch (accountType){
            case User:
                return new UserRepository();
//            case Admin:
//                return new AdminRepository();




            default:
                return null;

        }
    }
}
