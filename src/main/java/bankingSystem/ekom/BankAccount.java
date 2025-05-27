package bankingSystem.ekom;


public class BankAccount {
    private static int nextId = 1000;
    private final String accountId;
    private final String accountHolderName;
    private double accountBalance;

    BankAccount(String accountHolder, double balance){
        this.accountId = "ACC" + nextId++;
        this.accountHolderName = accountHolder;
        this.accountBalance = balance;
    }

    public void deposit(double newAmount){
        this.accountBalance += newAmount;
    }

    public void withDraw(double amountToRemove){
        this.accountBalance -= amountToRemove;
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void transfer(BankAccount recipient, double amount){
        recipient.deposit(amount);
    }

    @Override
    public String toString(){
        return "AccountID: " + this.accountId + " Account Name: " + this.accountHolderName + " Account Balance: $" + this.accountBalance;
    }


}
