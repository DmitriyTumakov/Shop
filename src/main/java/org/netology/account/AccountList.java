package org.netology.account;

import java.util.HashMap;

// Использование принципа единственной ответственности
public class AccountList {
    private HashMap<String, AccountInterface> accountList = new HashMap<>();

    public void addAccount(String userId, AccountInterface account) {
        accountList.put(userId, account);
    }

    public boolean exists(String userId) {
        return accountList.containsKey(userId);
    }

    public boolean passwordCorrect(String userId, int password) {
        return accountList.get(userId).getPassword() == password;
    }

    public AccountInterface getAccount(String userId) {
        return accountList.get(userId);
    }
}
