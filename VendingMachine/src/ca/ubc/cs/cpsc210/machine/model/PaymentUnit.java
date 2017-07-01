package ca.ubc.cs.cpsc210.machine.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the payment unit in a vending machine.
 */
public class PaymentUnit {
    private int numLoonies;   // number of loonies available in machine for making change
    private int numQuarters;  // number of quarters available in machine for making change
    private int numDimes;     // number of dimes available in machine for making change
    private int numNickels;   // number of nickels available in machine for making change
    private List<Coin> currentTransaction;   // list of coins inserted into machine during transaction

    // Constructor
    // EFFECTS: there are no banked coins and no coins have been inserted into the machine
    // as part of a payment
    public PaymentUnit() {

        numLoonies = 0;
        numQuarters = 0;
        numDimes = 0;
        numNickels = 0;
        currentTransaction = new LinkedList<Coin>();
    }

    // Clear all the coins banked in the unit
    // MODIFIES: this
    // EFFECTS: clears all the coins banked in the unit
    public void clearCoinsBanked() {
        this.numDimes = 0;
        this.numNickels = 0;
        this.numQuarters = 0;
        this.numLoonies = 0;

    }

    // Add a number of coins of a certain type to the banked coins in the unit
    // REQUIRES: number > 0
    // MODIFIES: this
    // EFFECTS: adds number coins of type c to the banked coins in the unit
    public void addCoinsToBanked(Coin c, int number) {
        if (c.getValue() == 100) {
            this.numLoonies += number;
        } else if (c.getValue() == 25) {
            this.numQuarters += number;
        } else if (c.getValue() == 10) {
            this.numDimes += number;
        } else {
            this.numNickels += number;
        }

    }

    // Gets the number of coins banked in the unit of the given type
    // EFFECTS: returns number of coins banked of the given type
    public int getNumberOfCoinsBankedOfType(Coin c) {
        if (c.getValue() == 100) {
            return this.numLoonies;
        } else if (c.getValue() == 25) {
            return this.numQuarters;
        } else if (c.getValue() == 10) {
            return this.numDimes;
        } else {
            return this.numNickels;
        }
    }

    // Gets total value of coins banked
    // EFFECTS: returns the total value of all coins banked in the unit
    public int getValueOfCoinsBanked() {
        int totalValue = (numLoonies * 100) + (numQuarters * 25) + (numDimes * 10) + (numNickels * 5);

        return totalValue;
    }

    // Insert a coin as part of a transaction
    // MODIFIES: this
    // EFFECTS: adds coin c to the unit as a part of a transaction
    public void insertCoin(Coin c) {
        this.currentTransaction.add(c);

    }

    // Get value of coins inserted for current payment
    // EFFECTS: returns value of coins inserted for current transaction
    public int getValueOfCoinsInserted() {
        int totalValueInserted = 0;

        for (Coin c : currentTransaction) {
            totalValueInserted += c.getValue();
        }
        return totalValueInserted;
    }

    // Cancel current transaction
    // MODIFIES: this
    // EFFECTS: coins inserted for current transaction are cleared; list of coins
    // inserted for current transaction is returned in the order in which they were inserted.
    public List<Coin> cancelTransaction() {
        List<Coin> returnedCoins = new LinkedList<Coin>();

        for (Coin c : currentTransaction) {
            returnedCoins.add(c);
        }

        this.currentTransaction.clear();

        return returnedCoins;
    }

    // Make a purchase of an item with given cost
    // REQUIRES: cost <= total value of coins inserted as part of current transaction
    // MODIFIES: this
    // EFFECTS: adds coins inserted to coins banked in unit and returns list of coins that will be provided as change.
    // Coins of largest possible value are used when determining the change.  Change in full is not guaranteed -
    // will provide only as many coins as are banked in the machine, without going over the amount due.
    public List<Coin> makePurchase(int cost) {
        int amountDue = this.getValueOfCoinsInserted() - cost;

        List<Coin> change = new LinkedList<Coin>();

        this.updatedBankedCoins();

        while (amountDue >= 5) {
            if (amountDue >= 100 && this.numLoonies >= 1) {
                change.add(Coin.LOONIE);
                amountDue -= 100;
                this.numLoonies -= 1;
            } else if (amountDue >= 25 && this.numQuarters >=1) {
                change.add(Coin.QUARTER);
                amountDue -= 25;
                this.numQuarters -= 1;
            } else if (amountDue >= 10 && this.numDimes >= 1) {
                change.add(Coin.DIME);
                amountDue -= 10;
                this.numDimes -= 1;
            } else if (amountDue >= 5 && this.numNickels >= 1) {
                change.add(Coin.NICKEL);
                amountDue -= 5;
                this.numNickels -= 1;
            }

            else { break;
            }
        }

        return change;
    }


    // adds coins inserted to coins banked in unit
    // REQUIRES: nothing
    // MODIFIES: this
    // EFFECTS: adds coins in the currentTransaction to the numLoonies, numQuarters, numDimes, and numNickels. Also,
    // clear the currentTransaction
    public void updatedBankedCoins () {
        for (Coin c: currentTransaction) {
            if (c.getValue() == 100) {
                this.numLoonies += 1;
            }
            else if (c.getValue() == 25) {
                this.numQuarters += 1;
            }
            else if (c.getValue() == 10) {
                this.numDimes += 1;
            }
            else {
                this.numNickels += 1;
            }
        }

        this.currentTransaction.clear();
    }


}
