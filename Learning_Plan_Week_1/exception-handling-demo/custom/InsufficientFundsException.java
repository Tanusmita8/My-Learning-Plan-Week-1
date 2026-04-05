public class InsufficientFundsException extends Exception {

    private double amountRequested;
    private double currentBalance;

    public InsufficientFundsException(double amountRequested, double currentBalance) {
        super("Insufficient funds! Tried to withdraw $" + amountRequested
                + " but balance is only $" + currentBalance);

        this.amountRequested = amountRequested;
        this.currentBalance = currentBalance;
    }

    public double getAmountRequested() {
        return amountRequested;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getShortfall() {
        return amountRequested - currentBalance;
    }
}