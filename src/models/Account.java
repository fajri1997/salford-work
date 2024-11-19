package models;

public class Account {
    private String username;
    private String password;
    private double balance;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0; // Default balance
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
