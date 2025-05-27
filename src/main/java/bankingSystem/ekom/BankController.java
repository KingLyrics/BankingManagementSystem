package bankingSystem.ekom;

import java.util.ArrayList;

public class BankController {
    private static ArrayList<BankAccount> allAccounts;

    public static BankAccount createAccount(String accountHolderName, double accountBalance){
        BankAccount newAccount = new BankAccount(accountHolderName, accountBalance);
        allAccounts.add(newAccount);
        return newAccount;


    }

    public static void setAllAccounts(ArrayList<BankAccount> allAccounts) {
        BankController.allAccounts = allAccounts;
    }
}
