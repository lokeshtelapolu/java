import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Class to store user information
class User {
    private String username;
    private String password; // In a real application, passwords should be hashed

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Class to store transaction details
class Transaction {
    private String type; // "Income" or "Expense"
    private double amount;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}

// Class to manage users and their transactions
class FinanceManager {
    private Map<String, User> users = new HashMap<>();
    private Map<String, List<Transaction>> userTransactions = new HashMap<>();

    // Add a new user
    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
        userTransactions.put(username, new ArrayList<>());
    }

    // Add a transaction for a user
    public void addTransaction(String username, Transaction transaction) {
        if (users.containsKey(username)) {
            userTransactions.get(username).add(transaction);
        } else {
            System.out.println("User not found!");
        }
    }

    // Get the summary of transactions
    public void printSummary(String username) {
        if (users.containsKey(username)) {
            List<Transaction> transactions = userTransactions.get(username);
            double incomeTotal = 0;
            double expenseTotal = 0;

            for (Transaction transaction : transactions) {
                if (transaction.getType().equalsIgnoreCase("Income")) {
                    incomeTotal += transaction.getAmount();
                } else if (transaction.getType().equalsIgnoreCase("Expense")) {
                    expenseTotal += transaction.getAmount();
                }
            }

            System.out.println("\nSummary for " + username + ":");
            System.out.println("Total Income: " + incomeTotal);
            System.out.println("Total Expenses: " + expenseTotal);
            System.out.println("Net Savings: " + (incomeTotal - expenseTotal));
        } else {
            System.out.println("User not found!");
        }
    }
}

// Main class to handle user input and program execution
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();
        
        while (true) {
            System.out.println("\nPersonal Finance Management System");
            System.out.println("1. Register User");
            System.out.println("2. Add Transaction");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Register user
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    manager.addUser(username, password);
                    System.out.println("User registered successfully.");
                    break;

                case 2:
                    // Add transaction
                    System.out.print("Enter username: ");
                    String user = scanner.nextLine();
                    System.out.print("Enter transaction type (Income/Expense): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    manager.addTransaction(user, new Transaction(type, amount, description));
                    System.out.println("Transaction added successfully.");
                    break;

                case 3:
                    // View summary
                    System.out.print("Enter username: ");
                    String summaryUser = scanner.nextLine();
                    manager.printSummary(summaryUser);
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}