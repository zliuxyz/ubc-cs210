package ca.ubc.cpsc210.bank;

import ca.ubc.cpsc210.bank.exceptions.AccountException;
import ca.ubc.cpsc210.bank.exceptions.IllegalValueException;
import ca.ubc.cpsc210.bank.exceptions.NotEnoughMoneyException;

import java.util.Scanner;

/*
 * Bank teller using exception handling (not complete).
 */

public class Teller {
    private static RobustMethodsAccount cheq;
    private static RobustMethodsAccount sav;
    private static Scanner input;
    
    /*
     * Process user input
     */
    public static void main(String[] args) {
        boolean keepGoing = true;
        String command = null;

        try {
            init();

            while(keepGoing) {
                displayMenu();
                command = input.next();
                command = command.toLowerCase();

                if(command.equals("d"))
                    doDeposit();
                else if(command.equals("w"))
                    doWithdrawal();
                else if(command.equals("t"))
                    doTransfer();
                else if(command.equals("q"))
                    keepGoing = false;
                else
                    System.out.println("Selection not valid...");
            }
        } catch (IllegalValueException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Unable to create accounts - program terminating");
        }

        System.out.println("\nGoodbye!");
    }
    
    /*
     * Initialize accounts and scanner
     */
    private static void init() throws IllegalValueException {
        cheq = new RobustMethodsAccount("Joe", 145.00);
        sav = new RobustMethodsAccount("Joe", 256.50);
        input = new Scanner(System.in);
    }
    
    /*
     * Display main menu of options to user
     */
    private static void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\td -> deposit");
        System.out.println("\tw -> withdraw");
        System.out.println("\tt -> transfer");
        System.out.println("\tq -> quit");
    }
    
    /*
     * Conduct a deposit transaction
     */
    private static void doDeposit() {
        RobustMethodsAccount selected = selectAccount();
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();

        try {
            selected.deposit(amount);
        } catch (IllegalValueException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        printBalance(selected);
    }
    
    /*
     * Conduct a withdraw transaction
     */
    private static void doWithdrawal() {
        RobustMethodsAccount selected = selectAccount();
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();

        try {
            selected.withdraw(amount);
        } catch (IllegalValueException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        printBalance(selected);
    }
    
    /*
     * Conduct a transfer from one account to another
     */
    private static void doTransfer() {
        System.out.println("\nTransfer from?");
        RobustMethodsAccount source = selectAccount();
        System.out.println("Transfer to?");
        RobustMethodsAccount destination = selectAccount();
        
        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();

        try {
            source.withdraw(amount);
            destination.deposit(amount);
        } catch (AccountException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

//        catch (IllegalValueException e) {
//            e.printStackTrace();
//        } catch (NotEnoughMoneyException e) {
//            e.printStackTrace();
//        }


        System.out.print("Source ");
        printBalance(source);
        System.out.print("Destination ");
        printBalance(destination);
        
    }
    
    /*
     * Allows user to select an account and returns selected account
     */
    private static RobustMethodsAccount selectAccount() {
        String selection = "";  // force entry into loop
        
        while(!(selection.equals("c") || selection.equals("s"))) {
            System.out.println("c for chequing");
            System.out.println("s for savings");
            selection = input.next();
            selection = selection.toLowerCase();
        }
        
        if(selection.equals("c"))
            return cheq;
        else
            return sav;        
    }
    
    /*
     * Prints balance of selected account on the screen
     */
    private static void printBalance(RobustMethodsAccount selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
}
