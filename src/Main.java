import models.Account;
import models.Transaction;
import services.AccountService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountService service = new AccountService();

        System.out.println("Welcome to Simple Bank App!");

        while (true) {
            System.out.println("\n1. Create Account\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (service.createAccount(username, password)) {
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Username already exists!");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                Account account = service.login(username, password);
                if (account != null) {
                    System.out.println("Login successful!");
                    while (true) {
                        System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transaction History\n5. Logout");
                        System.out.print("Choose an option: ");
                        int userChoice = scanner.nextInt();

                        if (userChoice == 1) {
                            System.out.println("Current Balance: $" + account.getBalance());
                        } else if (userChoice == 2) {
                            System.out.print("Enter amount to deposit: ");
                            double amount = scanner.nextDouble();
                            account.deposit(amount);
                            service.recordTransaction(username, "Deposit", amount);
                            System.out.println("Deposited successfully!");
                        } else if (userChoice == 3) {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            if (account.withdraw(amount)) {
                                service.recordTransaction(username, "Withdrawal", amount);
                                System.out.println("Withdrawn successfully!");
                            } else {
                                System.out.println("Insufficient balance!");
                            }
                        } else if (userChoice == 4) {
                            System.out.println("Transaction History:");
                            for (Transaction t : service.getTransactionHistory(username)) {
                                System.out.println(t);
                            }
                        } else if (userChoice == 5) {
                            break;
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    }
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else if (choice == 3) {
                System.out.println("Thank you for using Fajri Bank App!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
