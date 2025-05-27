package bankingSystem.ekom;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("********");
        System.out.println("Banking Program");
        System.out.println("********");
        boolean userActive = true;


        while(userActive){
            boolean userSearching = true;
            System.out.println("1. Create An Account.");
            System.out.println("2. View All Accounts.");

            System.out.print("Selection: ");
            int userOption = sc.nextInt();

         while(userSearching){
             switch (userOption){
                 case 1:
                     System.out.println(" Account Creation: ");
                     System.out.print("Please input the starting account balance: ");
                     double accountBalance = sc.nextDouble();
                     sc.nextLine();

                     System.out.print("Please input the account holders name: ");
                     String accountHolderName = sc.nextLine();

                     try{
                         BankController.createAccount(accountHolderName, accountBalance);
                         System.out.println("Account created! Thank you.");
                     } catch (Exception e) {
                         System.out.println("Error Creating account...");
                         throw new RuntimeException(e);
                     }
                     userSearching = false;
                     break;

                 case 2:


                 default:
                     System.out.println("Exiting.");
                     System.out.println("Have a great day!");
                     userActive = false;
                     userSearching = false;

             }
         }

        }



    }
}
