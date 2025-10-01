package myPackage;
import java.util.ArrayList;
import java.util.List;

public class data {
    private final String owner;
    private double balance;
    private final int pin;
    private final List<String> transactions;

    public data(String owner, double balance, int pin) {
        this.owner = owner;
        this.balance = balance;
        this.pin = pin;
        this.transactions = new ArrayList<>();
        transactions.add("Wallet created with balance: " + balance);
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
    }

    public boolean transfer(data receiver, double amount, int enteredPin) {
        if (!checkPin(enteredPin)) {
            System.out.println("❌ Wrong PIN. Transfer failed.");
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            receiver.balance += amount;
            transactions.add("Transferred " + amount + " to " + receiver.owner + " | Balance: " + balance);
            receiver.transactions.add("Received " + amount + " from " + owner + " | Balance: " + receiver.balance);
            return true;
        } else {
            System.out.println("❌ Insufficient balance.");
            return false;
        }
    }

    public void showTransactions() {
        System.out.println("Transaction history for " + owner + ":");
        for (String t : transactions) {
            System.out.println(" - " + t);
        }
    }
}