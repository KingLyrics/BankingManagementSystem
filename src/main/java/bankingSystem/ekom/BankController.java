package bankingSystem.ekom;

public class BankController {
    public static BankAccount createAccount(String accountHolderName, double accountBalance){
        return new BankAccount(accountHolderName, accountBalance);

    }
}
