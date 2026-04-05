public class BankAccountDemo {

    public static void main(String[] args) {

        System.out.println("=== Custom Exception Demo: Bank Account ===");
        System.out.println();

        System.out.println("--- Scenario 1: Successful transactions ---");
        BankAccount account = new BankAccount("Alice", 500.00);
        System.out.println("Account opened for: " + account.getOwner());
        System.out.println("Starting balance: $" + account.getBalance());
        System.out.println();

        try {
            account.deposit(200.00);
            account.withdraw(150.00);
            System.out.println("All transactions completed successfully!");

        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        System.out.println();

        System.out.println("--- Scenario 2: Trying to withdraw too much ---");
        BankAccount smallAccount = new BankAccount("Bob", 100.00);
        System.out.println("Account opened for: " + smallAccount.getOwner());
        System.out.println("Starting balance: $" + smallAccount.getBalance());
        System.out.println();

        try {
            smallAccount.withdraw(250.00);

        } catch (InsufficientFundsException e) {
            System.out.println("Transaction BLOCKED!");
            System.out.println("Reason: " + e.getMessage());
            System.out.println("You need $" + e.getShortfall() + " more to complete this withdrawal.");
        }

        System.out.println();

        System.out.println("--- Scenario 3: Invalid deposit amount ---");
        BankAccount account3 = new BankAccount("Carol", 200.00);

        try {
            account3.deposit(-50.00);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Program continues normally after handling all exceptions.");
    }
}