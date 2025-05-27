package bankingSystem.ekom;

import java.time.LocalDateTime;

public class Transaction {
    private static int accountVal = 100;
    private final String transactionID;
    private  final String transactionType ;
    private final double amount;
    private final LocalDateTime dateAndTime;
    private final String description;



    public Transaction(String transactionType,
                       double amount, String description){
        this.amount = amount;
        this.transactionID = "T" + accountVal++;
        this.dateAndTime = LocalDateTime.now();
        this.transactionType = transactionType;
        this.description = description;

    }

    public String getTransactionID(){
        return this.transactionID;
    }
    public  String getTransactionType(){
        return this.transactionType;
    }

    public  double getAmount(){
        return this.amount;
    }

    public LocalDateTime getDateAndTime(){
        return this.dateAndTime;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public  String toString(){
        return "Transaction Details{ " +
                "Transaction ID: " + this.transactionID +
                " Transaction Type: " + this.transactionType +
                " Transaction Date and Time: " + this.dateAndTime+
                " Transaction Amount: " + this.amount +
                " Transaction Description: " + this.description + " }";
    }

}
