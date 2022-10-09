package chapter08.homework;

public class homework08 {
    public static void main(String[] args) {
        ExtendAccount account = new ExtendAccount(20000);
        account.deposit(1000);
        account.deposit(1000);
        account.deposit(1000);
        System.out.println(account.getBalance());  // 23000.0
        account.deposit(1000);
        System.out.println(account.getBalance());  // 23999.0
        account.monthAdjust();
        System.out.println(account.getBalance());  // 24958.96
        account.withdraw(2000);
        System.out.println(account.getBalance());  // 22958.96
    }
}

class BaseAccount {
    //余额
    private double balance;

    public BaseAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //存款
    public void deposit(double amount) {
        balance += amount;
    }

    //取款
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class ExtendAccount extends BaseAccount {
    private int freeCount = 3;
    private double interestRate = 0.04;

    public ExtendAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (freeCount > 0)
            super.deposit(amount);
        else
            super.deposit(amount - 1);
        freeCount--;
    }

    @Override
    public void withdraw(double amount) {
        if (freeCount > 0)
            super.withdraw(amount);
        else
            super.withdraw(amount + 1);
        freeCount--;
    }

    public void monthAdjust() {
        freeCount = 3;
        super.deposit(getBalance() * interestRate);
//        setBalance(getBalance() + getBalance() * interestRate);
    }
}