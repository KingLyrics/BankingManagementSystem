package bankingSystem.ekom;

import java.time.LocalDateTime;

public class Transaction {
    private static int accountVal = 100;
    private final String transactionID;
    private  String transactionType ;
    private double amount = 0;
    private  LocalDateTime dateAndTime;
    private String description;


    public Transaction(String transactionType,
                       double amount ){
        this.amount = amount;
        this.transactionID = "T" + accountVal++;
        this.dateAndTime = LocalDateTime.now();
        this.transactionType = transactionType;

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


}
