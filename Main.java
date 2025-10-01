import myPackage.data;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create two wallets
        System.out.print("Enter name for Wallet 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter initial balance for " + name1 + ": ");
        double bal1 = sc.nextDouble();
        System.out.print("Set PIN for " + name1 + ": ");
        int pin1 = sc.nextInt();
        data w1 = new data(name1, bal1, pin1);

        sc.nextLine(); // consume newline

        System.out.print("Enter name for Wallet 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter initial balance for " + name2 + ": ");
        double bal2 = sc.nextDouble();
        System.out.print("Set PIN for " + name2 + ": ");
        int pin2 = sc.nextInt();
        data w2 = new data(name2, bal2, pin2);

        // Menu
        int choice;
        do {
            System.out.println("\n===== Digital Wallet Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(w1.getOwner() + " Balance: " + w1.getBalance());
                    System.out.println(w2.getOwner() + " Balance: " + w2.getBalance());
                    break;
                case 2:
                    System.out.print("Deposit to (1 or 2): ");
                    int dChoice = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double damount = sc.nextDouble();
                    if (dChoice == 1) w1.deposit(damount);
                    else w2.deposit(damount);
                    break;
                case 3:
                    System.out.print("Transfer from (1 or 2): ");
                    int from = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    System.out.print("Enter PIN: ");
                    int enteredPin = sc.nextInt();

                    if (from == 1) {
                        w1.transfer(w2, amount, enteredPin);
                    } else {
                        w2.transfer(w1, amount, enteredPin);
                    }
                    break;
                case 4:
                    System.out.println("\n--- Transaction Histories ---");
                    w1.showTransactions();
                    w2.showTransactions();
                    break;
                case 5:
                    System.out.println("Exiting Wallet System...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}