package bankingSystem.ekom;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class BankAccount {
    static Random random = new Random();
    private static int nextId = random.nextInt(900) + 100;
    private final String accountId;
    private final String accountHolderName;
    private double accountBalance;
    private ArrayList<Transaction> transactions;


    public BankAccount(String accountHolder, double balance){
        this.accountId = "ACC" + nextId++;
        this.accountHolderName = accountHolder;
        this.accountBalance = balance;
        transactions = new ArrayList<>();
        transactions.add(new Transaction(
                "DEPOSIT",
                accountBalance, "Initial Deposit"));
        try{
            File allAccounts = new File("AccountsList.txt");
            FileWriter fileWriter = new FileWriter(allAccounts.getName(),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(toString());
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Error creating file.");
            throw new RuntimeException(e);
        }
    }

    public void deposit(double newAmount, String description){
        this.accountBalance += newAmount;
        transactions.add(new Transaction("DEPOSIT", newAmount, description));
    }

    public void withDraw(double amountToRemove, String description){
        try {
            if(amountToRemove < this.accountBalance) {
                this.accountBalance -= amountToRemove;
            }
        }catch (Exception e) {
            System.out.println("Insufficient Funds");
            e.getStackTrace();
        }
        transactions.add(new Transaction("WITHDRAWAL", amountToRemove, description));
    }

    public double getAccountBalance(){
        return this.accountBalance;
    }

    public void transfer(BankAccount recipient, double amount, String description){
        this.accountBalance -= amount;
        recipient.deposit(amount, description);
        transactions.add(new Transaction("TRANSFER SENT", amount, description));

        recipient.transactions.add(new Transaction("TRANSACTION RECEIVED", amount, description));
    }

    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }

    @Override
    public String toString(){
        return "AccountID: " + this.accountId + " Account Name: " + this.accountHolderName + " Account Balance: $" + this.accountBalance;
    }


}
