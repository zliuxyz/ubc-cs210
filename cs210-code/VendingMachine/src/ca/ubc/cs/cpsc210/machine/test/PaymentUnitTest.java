package ca.ubc.cs.cpsc210.machine.test;

import ca.ubc.cs.cpsc210.machine.model.Coin;
import ca.ubc.cs.cpsc210.machine.model.PaymentUnit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PaymentUnitTest {
    private PaymentUnit vm;

    @Before
    //construct a new PaymentUnit object prior to running each test
    public void setUp() throws Exception {
        vm = new PaymentUnit();
    }


    //TODO: add tests
    // Clear all the coins banked in the unit
    // MODIFIES: this
    // EFFECTS: clears all the coins banked in the unit
    @Test
    public void testclearCoinsBanked() {
        vm.addCoinsToBanked(Coin.LOONIE, 10);
        vm.addCoinsToBanked(Coin.NICKEL, 44);
        vm.clearCoinsBanked();
        assertEquals(vm.getValueOfCoinsBanked(), 0);
    }


    // Add a number of coins of a certain type to the banked coins in the unit
    // REQUIRES: number > 0
    // MODIFIES: this
    // EFFECTS: adds number coins of type c to the banked coins in the unit
    @Test
    public void testaddCoinsToBanked(){
        vm.addCoinsToBanked(Coin.DIME, 20);
        vm.addCoinsToBanked(Coin.LOONIE, 10);
        assertEquals(vm.getValueOfCoinsBanked(), 1200);
    }

    // Gets the number of coins banked in the unit of the given type
    // EFFECTS: returns number of coins banked of the given type
    @Test
    public void testgetNumberOfCoinsBankedOfType() {
        vm.addCoinsToBanked(Coin.QUARTER, 1);
        vm.addCoinsToBanked(Coin.LOONIE, 10);
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.QUARTER), 1);
        assertEquals(vm.getNumberOfCoinsBankedOfType(Coin.LOONIE), 10);
        assertFalse(vm.getNumberOfCoinsBankedOfType(Coin.NICKEL) == 100);
    }


    // Gets total value of coins banked
    // EFFECTS: returns the total value of all coins banked in the unit
    @Test
    public void testgetValueOfCoinsBanked(){
        assertEquals(vm.getValueOfCoinsBanked(), 0);
    }

    // Insert a coin as part of a transaction
    // MODIFIES: this
    // EFFECTS: adds coin c to the unit as a part of a transaction
    @Test
    public void testinsertCoin(){
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.NICKEL);
        assertEquals(vm.getValueOfCoinsInserted(), 30);

    }


    // Get value of coins inserted for current payment
    // EFFECTS: returns value of coins inserted for current transaction
    @Test
    public void testgetValueOfCoinsInserted() {
        vm.insertCoin(Coin.LOONIE);
        assertEquals(vm.getValueOfCoinsInserted(), 100);

    }


    // Cancel current transaction
    // MODIFIES: this
    // EFFECTS: coins inserted for current transaction are cleared; list of coins
    // inserted for current transaction is returned in the order in which they were inserted.
    @Test
    public void testcancelTransaction() {
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKEL);


        List<Coin> ListofCoins = new LinkedList<Coin>();
        ListofCoins.add(Coin.LOONIE);
        ListofCoins.add(Coin.QUARTER);
        ListofCoins.add(Coin.DIME);
        ListofCoins.add(Coin.NICKEL);

        assertTrue(ListofCoins.equals(vm.cancelTransaction()));

    }

    // Make a purchase of an item with given cost
    // REQUIRES: cost <= total value of coins inserted as part of current transaction
    // MODIFIES: this
    // EFFECTS: adds coins inserted to coins banked in unit and returns list of coins that will be provided as change.
    // Coins of largest possible value are used when determining the change.  Change in full is not guaranteed -
    // will provide only as many coins as are banked in the machine, without going over the amount due.
    @Test
    public void testmakePurchase() {
        List<Coin> change = new LinkedList<Coin>();
        vm.clearCoinsBanked();
        vm.addCoinsToBanked(Coin.LOONIE, 3);
        vm.addCoinsToBanked(Coin.QUARTER, 3);
        vm.addCoinsToBanked(Coin.NICKEL, 3);
        vm.addCoinsToBanked(Coin.DIME, 3);
        vm.insertCoin(Coin.LOONIE);
        vm.insertCoin(Coin.LOONIE);
        change.add(Coin.QUARTER);
        change.add(Coin.QUARTER);
        change.add(Coin.DIME);
        change.add(Coin.NICKEL);
        assertTrue(vm.makePurchase(135).equals(change));

        vm.addCoinsToBanked(Coin.NICKEL, 1);
        vm.addCoinsToBanked(Coin.DIME, 1);
        vm.insertCoin(Coin.QUARTER);
        change.clear();
        change.add(Coin.DIME);
        change.add(Coin.NICKEL);
        assertTrue(vm.makePurchase(10).equals(change));


        change.clear();
        vm.clearCoinsBanked();
        vm.insertCoin(Coin.NICKEL);
        assertTrue(vm.makePurchase(4).equals(change));

        vm.clearCoinsBanked();
        change.clear();
        vm.addCoinsToBanked(Coin.DIME, 10);
        vm.addCoinsToBanked(Coin.NICKEL, 1);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        change.add(Coin.QUARTER);
        change.add(Coin.QUARTER);
        change.add(Coin.QUARTER);
        change.add(Coin.QUARTER);
        change.add(Coin.QUARTER);
        assertTrue(vm.makePurchase(75).equals(change));

        vm.clearCoinsBanked();
        change.clear();
        vm.addCoinsToBanked(Coin.DIME, 2);
        vm.addCoinsToBanked(Coin.NICKEL, 1);
        change.add(Coin.DIME);
        change.add(Coin.DIME);
        change.add(Coin.NICKEL);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.DIME);
        assertTrue(vm.makePurchase(5).equals(change));

        vm.clearCoinsBanked();
        change.clear();
        vm.addCoinsToBanked(Coin.DIME, 1);
        vm.addCoinsToBanked(Coin.NICKEL, 3);
        change.add(Coin.DIME);
        change.add(Coin.NICKEL);
        change.add(Coin.NICKEL);
        change.add(Coin.NICKEL);
        vm.insertCoin(Coin.LOONIE);
        assertTrue(vm.makePurchase(75).equals(change));

        vm.clearCoinsBanked();
        change.clear();
        vm.insertCoin(Coin.LOONIE);
        change.add(Coin.LOONIE);
        assertTrue(vm.makePurchase(0).equals(change));

        vm.clearCoinsBanked();
        change.clear();
        assertTrue(vm.getValueOfCoinsInserted() == 0);
        assertTrue(vm.getValueOfCoinsBanked() == 0);
        vm.insertCoin(Coin.LOONIE);
        vm.addCoinsToBanked(Coin.NICKEL, 1);
        change.add(Coin.NICKEL);
        assertTrue(vm.makePurchase(50).equals(change));
    }

    @Test
    public void testupdatedBankedCoins (){
        vm.insertCoin(Coin.LOONIE);
        assertEquals(vm.getValueOfCoinsBanked(), 0);
        vm.updatedBankedCoins();
        assertEquals(vm.getValueOfCoinsBanked(), 100);
    }


}
