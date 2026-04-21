// Custom Exception
class LessBalanceException extends Exception {
    LessBalanceException(String msg) {
        super(msg);
    }
}

// Bank Account Class
class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    void withdraw(double amount) throws LessBalanceException {
        if(balance - amount < 1000) {
            throw new LessBalanceException(
                "Withdraw amount (Rs " + amount + ") is not valid. Insufficient balance."
            );
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// Main Class
public class BankingSystem {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount(2000);

        try {
            acc.deposit(500);
            acc.withdraw(1800);   // may cause custom exception
        } 
        catch(LessBalanceException e) {
            System.out.println(e.getMessage());
        }

        acc.displayBalance();

        // Demonstrating ArithmeticException
        try {
            int a = 10;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } 
        catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception: Division by zero is not allowed.");
        }
    }
}
