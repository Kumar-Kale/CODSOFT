import java.util.Scanner;


public class ATMInterface {

    private BankAccount account;

    
    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    
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
                    
                    System.out.printf("Your current balance is: $%.2f\n", account.getBalance());
                    break;

                case 2:
                    
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

    
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(500.00);

        
        ATMInterface atm = new ATMInterface(userAccount);

        
        atm.displayMenu();
    }
}

class BankAccount {
    private double balance;

    
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    
    public double getBalance() {
        return balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

