import java.util.Scanner;

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    public final void clrscr() {
        // Code to clear the screen (implementation omitted for brevity)
    }

    void checkId() {
        clrscr();
        System.out.println("Welcome to XYZ Bank, " + customerName);
        System.out.print("Please enter your Customer ID: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            initiateBankingOperations();
        } else {
            System.out.println("=================================");
            System.out.println("Wrong Login!!");
            System.out.println("=================================");
            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance >= amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            System.out.println("=================================");
            System.out.println("Sufficient Balance not available for withdrawal!");
            System.out.println("=================================");
        }
    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: $" + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdrawn: $" + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    private void initiateBankingOperations() {
        char option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nOptions:");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println();

            switch (option) {
                case 'A':
                    clrscr();
                    System.out.println("Current Balance: $" + balance);
                    break;

                case 'B':
                    clrscr();
                    System.out.print("Enter the amount to deposit: $");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    break;

                case 'C':
                    clrscr();
                    System.out.print("Enter the amount to withdraw: $");
                    int withdrawalAmount = scanner.nextInt();
                    withdraw(withdrawalAmount);
                    break;

                case 'D':
                    clrscr();
                    getPrevTransaction();
                    break;

                case 'E':
                    clrscr();
                    System.out.println("Thank you for using XYZ Bank services!");
                    break;

                default:
                    clrscr();
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println();
        } while (option != 'E');
    }
}

public class ModifiedATM {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount("Alice", "2001");
        userAccount.checkId();
    }
}
