package repository;

import Exceptions.AccountDoesNotExistsException;
import main.model.Account;
import main.model.Admin;


import java.util.ArrayList;
import java.util.HashMap;

public class AdminRepository {
    public static HashMap<String, Admin> adminMap = new HashMap<>();
    public static ArrayList<Admin> admins = new ArrayList<>();

    public Account createAccount(Account account) {
        adminMap.putIfAbsent(account.getEmail(), (Admin) account);
        return account;
    }

    public void resetPassword(String userId, String password) throws AccountDoesNotExistsException {
        if (adminMap.get(userId) == null)
            throw new AccountDoesNotExistsException("Account does not exist.");
        adminMap.get(userId).setPassword(password);
    }
}
