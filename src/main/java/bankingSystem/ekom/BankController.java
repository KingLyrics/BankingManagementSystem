package bankingSystem.ekom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class BankController {
    private static ArrayList<BankAccount> allAccounts  = new ArrayList<BankAccount>();

    public static void createAccount(String accountHolderName, double accountBalance){
        allAccounts.add(new BankAccount(accountHolderName, accountBalance));
    }

    public static void loadAllAccountsFromFile(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] divide = line.split("AccountID: | Account Name: | Account Balance: \\$");
                if (divide.length ==  4){
                    String accountId = divide[1].trim();
                    String accountHolderName = divide[2].trim();
                    double accountBalance  = Double.parseDouble(divide[3].trim());
                    BankAccount userAccount = new BankAccount(accountHolderName, accountBalance);
                    allAccounts.add(userAccount);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading accounts file: " + e.getMessage());
        }
    }

    public static ArrayList<BankAccount> getAllAccounts(){
        return allAccounts;
    }


}
