public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive. Got: " + amount);
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " | New balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive. Got: " + amount);
        }

        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }

        balance -= amount;
        System.out.println("Withdrew $" + amount + " | New balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}
