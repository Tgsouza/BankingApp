package bankingapp;

import java.util.Scanner;

/**
 *
 * @author Thiago Gomes de Souza 
 * This is a simple banking application
 */
public class BankingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Creates an Object from the costumer
         */
        BankAccount obj1 = new BankAccount("XYZ", "BA0001");
        obj1.showMenu();

    }

}

/**
 *
 * Creates a class for the banking app
 *
 */
class BankAccount {

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Create a constructo to use in the welcome message
    BankAccount(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    /**
     *
     * Creates a function for deposit
     *
     * @param amount value that the user wants to deposit
     *
     */
    void deposit(int amount) {

        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;

        }
    }

    /**
     * Creates a function for withdrawn
     *
     * @param amount value that the user wants to withdrawn
     */
    void withdraw(int amount) {

        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = amount;
        }
    }

    /**
     * Get the previous amount in the account
     */
    void getPreviousAmount() {

        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("There is no previous transaction");
        }

    }

    /**
     * Function to call the menu
     */
    void showMenu() {

        char option = '\0';
        Scanner myKB = new Scanner(System.in);

        /**
         * Display the menu
         */
        System.out.println("Welcome " + customerName + "\n"
                + "Your ID is " + customerID + "\n"
                + "A. Check balance \n"
                + "B. Deposit"
                + "\nC.Withdraw"
                + "\nD.Previous Transaction"
                + "\nE.Exit");

        /**
         * A do Loop based on the menu options and the choices from the costumer
         */
        do {
            System.out.println("===============================================\n"
                    + "Enter the option\n"
                    + "===============================================");

            option = myKB.next().charAt(0);
            System.out.println("");

            switch (option) {

                //Shows balance
                case 'A':
                    System.out.println("-----------------\n"
                            + "Balance = " + balance
                            + "\n-----------------");
                    break;
                //Deposit option
                case 'B':
                    System.out.println("-----------------\n"
                            + "Enter the amount to deposit:"
                            + "\n-----------------");
                    int amount = myKB.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                //Withdraw option    
                case 'C':
                    System.out.println("-----------------\n"
                            + "Enter the amount to withdrawn:"
                            + "\n-----------------");
                    int amount2 = myKB.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                //Shows the previous amount    
                case 'D':
                    System.out.println("-----------------\n");
                    getPreviousAmount();
                    System.out.println("-----------------\n");
                    System.out.println("\n");
                    break;
                //Exit the menu    
                case 'E':
                    System.out.println("**********************************\n");
                    break;
                //Error message in case of error    
                default:
                    System.out.println("Invalid Option! Please, try again!\n");

            }
            //loop while the user dont choose the EXIT option 
        } while (option != 'E');

        System.out.println("Thank you for using our services\n");
    }
}
