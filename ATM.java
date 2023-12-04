import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("    _    _______   _      _ ");
        System.out.println("   / \\      |     | \\    / |");
        System.out.println("  /___\\     |     |  \\  /  |");
        System.out.println(" /     \\    |     |   \\/   |");
        System.out.println("/       \\   |     |        |\n");

        // Display welcome message
        System.out.println("***** Welcome to 'AFFAN' ATM! ******");

        // Get user credentials
        System.out.print("Enter your UserID: ");
        String userid = sc.nextLine();
        System.out.println("Enter your pin: ");
        int pin = sc.nextInt();

        // Initialize account variables
        int amount = 10000;
        int transactions = 0;
        String historyList = "";

        // Set loop condition
        boolean condition = true;

        // Authenticate user
        if (UserAuthentication(userid, pin)) {

            // Main ATM functionality loop
            while (condition) {
                System.out.println("\n---------------------------------");
                System.out.println("What would you like to do? " + userid);

                // Display menu options
                System.out.println("1. Check your Transaction History");
                System.out.println("2. Withdraw cash");
                System.out.println("3. Deposit money");
                System.out.println("4. Transfer");
                System.out.println("5. check balance");
                System.out.println("6. Quit");

                // Get user choice
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        // Display transaction history
                        if (transactions <= 0) {
                            System.out.println("\n\t\tNo Transactions yet...");
                        } else {
                            System.out.println("\n\t\t---Transaction history---");
                            System.out.println("Total No of Transactions:" + transactions + "" + historyList);
                        }
                        break;

                    case 2:
                        // Withdraw cash
                        System.out.println("\t\t---Withdraw Cash---");

                        if (amount < 0) {
                            System.out.println("You have '0' balance");
                        }

                        // Get withdrawal amount
                        System.out.println("Enter the amount you want to Withdraw cash:");
                        int withdraw = sc.nextInt();

                        if (withdraw > amount) {
                            System.out.println(
                                    "Sorry... you'r balance limit is " + amount + "Rs only Transaction Unsuccessful\"");
                        } else {
                            // Process withdrawal
                            amount -= withdraw;
                            transactions++;
                            System.out.println("\t" + withdraw + "Rs withdrew Successfully...");
                                // modifying transaction history
                            historyList += "\n" + transactions + ". Withdraw cash: ";
                            historyList += Integer.toString(withdraw);
                        }
                        break;

                    case 3:
                        // Deposit money
                        System.out.println("\n\t\t---Deposit---");
                        System.out.println("Enter the amount you want to deposit:");
                        int deposit = sc.nextInt();

                        if (deposit <= 0) {
                            System.out.println("Amount should be at least 1Rs");
                        } else {
                            // Process deposit
                            amount += deposit;
                            transactions++;
                            System.out.println("\t" + deposit + "Rs deposited Successfully...");
                                // modifying transaction history
                            historyList += "\n" + transactions + ". deposit cash: ";
                            historyList += Integer.toString(deposit);
                        }
                        break;

                    case 4:
                        // Transfer money
                        System.out.println("\n\t\t---Transfer Money---");
                        sc.nextLine(); // Consume the newline character
                        System.out.println("Enter the valid Account Username :");
                        String recipient = sc.nextLine();

                        // Get transfer amount
                        System.out.println("Enter the amount you want to Transfer Money:");
                        int recipientAmount = sc.nextInt();

                
                        if (recipientAmount < 0 || recipientAmount > amount) {
                            System.out.println(
                                    "\n\tSorry... you'r balance limit is " + amount + "Rs only Transaction Unsuccessful");
                        } else {
                            // Process transfer
                            amount -= recipientAmount;
                            transactions++;
                            System.out.println(
                                    "\t" + recipientAmount + "Rs Transferred from " + userid + " to " + recipient);
                            historyList += "\n" + transactions + ". Transferred : ";
                            historyList += Integer.toString(recipientAmount) + "Rs to " + recipient;
                        }
                        break;

                    case 5:
                        // Check balance
                        System.out.println("\n\t\t---Total Balance Amount---");
                        System.out.println("Your balance amount is: " + amount + "Rs");
                        break;

                    case 6:
                        // Quit the ATM
                        System.out.println("\t\t***Thank you for using the ATM!***");
                        condition = false;
                        break;

                    default:
                        // Invalid choice
                        System.out.println("Invalid Choice");
                        break;
                }

            }
        }
        sc.close();
    }

    // User authentication method
    private static boolean UserAuthentication(String userid, int pin) {
        // These are the some valid user ID's
        if (userid.equals("affan") && pin == 1111) {
            return true;
        } else if (userid.equals("adnan") && pin == 2222) {
            return true;
        } else if (userid.equals("safwan") && pin == 3333) {
            return true;
        } else if (userid.equals("usman") && pin == 4444) {
            return true;
        }
        System.out.println("Invalid UserId or Pin");
        return false;
    }
}
