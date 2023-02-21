package repository;

import Exceptions.AccountDoesNotExistsException;
import main.model.Account;
import main.model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserRepository implements AccountRepository{
    public static HashMap<String, User> userMap = new HashMap<String, User>();
    public static HashMap<String, User> userUserIdMap = new HashMap<>();
    public static ArrayList<User> users = new ArrayList<>();

    public Account createAccount(Account account) {
        userMap.putIfAbsent(account.getEmail(), (User) account);
        userUserIdMap.putIfAbsent(account.getId(), (User) account);
        return account;
    }

    public void resetPassword(String userId, String password) throws AccountDoesNotExistsException {
        if (userMap.get(userId) == null)
            throw new AccountDoesNotExistsException("Account does not exist.");
        userMap.get(userId).setPassword(password);
    }

}
