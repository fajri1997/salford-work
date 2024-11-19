package models;

public class Transaction {
    private String type; // Deposit, Withdrawal, Transfer
    private double amount;
    private String date;

    public Transaction(String type, double amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return type + " - $" + amount + " on " + date;
    }
}
