package bankingSystem.ekom;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("********");
        System.out.println("Banking Program");
        System.out.println("********");
        boolean userSearching = true;


        while(userSearching){
            System.out.println("1. Create an Account.");
            System.out.print("Selection: ");
            int userOption = sc.nextInt();

          switch (userOption){
              case 1:
                  System.out.println("Create an account");
                  break;

              default:
                  System.out.println("Exiting");
                  userSearching = false;

          }

        }



    }
}
