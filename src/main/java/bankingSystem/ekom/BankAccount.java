package bankingSystem.ekom;


import java.util.ArrayList;

public class BankAccount {
    private static int nextId = 1000;
    private final String accountId;
    private final String accountHolderName;
    private double accountBalance;
    private ArrayList<Transaction> transactions;


    public BankAccount(String accountHolder, double balance){
        this.accountId = "ACC" + nextId++;
        this.accountHolderName = accountHolder;
        this.accountBalance = balance;
        transactions = new ArrayList<>();
        transactions.add(new Transaction("DEPOSIT", accountBalance));
    }

    public void deposit(double newAmount){
        this.accountBalance += newAmount;
        transactions.add(new Transaction("DEPOSIT", newAmount));
    }

    public void withDraw(double amountToRemove){
        this.accountBalance -= amountToRemove;
        transactions.add(new Transaction("WITHDRAWAL", amountToRemove));
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void transfer(BankAccount recipient, double amount){
        this.accountBalance -= amount;
        recipient.deposit(amount);
        transactions.add(new Transaction("TRANSFER SENT", amount));
    }

    @Override
    public String toString(){
        return "AccountID: " + this.accountId + " Account Name: " + this.accountHolderName + " Account Balance: $" + this.accountBalance;
    }


}
