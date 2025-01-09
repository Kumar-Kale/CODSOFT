import java.util.Scanner;


// Step 1: Create a class to represent the ATM machine
public class ATMInterface {

    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    // Step 3: Implement the method to display the ATM menu and interact with the user
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the ATM!");

        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Step 3: Implement checkBalance
                    System.out.printf("Your current balance is: $%.2f\n", account.getBalance());
                    break;

                case 2:
                    // Step 3: Implement deposit
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                        System.out.printf("$%.2f has been deposited to your account.\n", depositAmount);
                    } else {
                        System.out.println("Invalid deposit amount. Please try again.");
                    }
                    break;

                case 3:
                    // Step 3: Implement withdraw
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        if (account.withdraw(withdrawAmount)) {
                            System.out.printf("$%.2f has been withdrawn from your account.\n", withdrawAmount);
                        } else {
                            System.out.println("Insufficient balance or invalid amount. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid withdrawal amount. Please try again.");
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
                    break;
            }
        }

        scanner.close();
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Step 4: Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(500.00);

        // Step 1: Create an instance of the ATM interface connected to the bank account
        ATMInterface atm = new ATMInterface(userAccount);

        // Step 3: Display the ATM menu
        atm.displayMenu();
    }
}
// Step 4: Create a class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit an amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw an amount
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

