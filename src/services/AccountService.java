package services;

import models.Account;
import models.Transaction;

import java.util.*;

public class AccountService {
    private Map<String, Account> accounts = new HashMap<>(); // Store accounts
    private Map<String, List<Transaction>> transactions = new HashMap<>(); // Transaction history

    public boolean createAccount(String username, String password) {
        if (accounts.containsKey(username)) {
            return false; // Account already exists
        }
        accounts.put(username, new Account(username, password));
        transactions.put(username, new ArrayList<>());
        return true;
    }

    public Account login(String username, String password) {
        Account account = accounts.get(username);
        if (account != null && account.validatePassword(password)) {
            return account;
        }
        return null;
    }

    public void recordTransaction(String username, String type, double amount) {
        String date = new Date().toString();
        transactions.get(username).add(new Transaction(type, amount, date));
    }

    public List<Transaction> getTransactionHistory(String username) {
        return transactions.get(username);
    }
}
