package ca.ubc.cpsc210.tests;

import static org.junit.Assert.fail;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.bank.RobustMethodsAccount;
import ca.ubc.cpsc210.bank.exceptions.IllegalValueException;
import ca.ubc.cpsc210.bank.exceptions.NotEnoughMoneyException;


public class RobustMethodsAccountTests {
	RobustMethodsAccount a;
	
	@Before
	public void beforeEachTest() throws IllegalValueException {
		a = new RobustMethodsAccount("Joe", 100.0);
	}
	
	@Test (expected = IllegalValueException.class)
	public void testBadNew() throws IllegalValueException {
		RobustMethodsAccount ra = new RobustMethodsAccount("", 0.0);
	}
	
	@Test
	public void testGoodNew() throws IllegalValueException {
		RobustMethodsAccount ra = new RobustMethodsAccount("a", 0.0);
		assertNotNull(ra);
	}
	
	@Test (expected = NotEnoughMoneyException.class)
	public void withdrawTooMuchMoney() 
			throws IllegalValueException, NotEnoughMoneyException {
		a.withdraw(101.50);
	}
	
	@Test (expected = IllegalValueException.class)
	public void withdrawNegativeAmount() 
			throws IllegalValueException, NotEnoughMoneyException {
		a.withdraw(-100.0);
	}
	
	
	@Test
	public void callWithdrawMoney() {
		try {
			withdrawMoney(101.50);
			System.out.println("Yay, I withdrew a negative amount and got away with it!");
			fail("Shouldn't have got to this point!");
		} catch (IllegalValueException e) {
			System.out.println("IllegalValueException:  " + e.getMessage());
		} catch (NotEnoughMoneyException e) {
			System.out.println("NotEnoughMoneyException:  " + e.getMessage());
		} finally {
			System.out.println("callWithdrawMoney:  Should print EVERY time, no matter what!");
		}
	}
	
	public void withdrawMoney(double amount) throws IllegalValueException, NotEnoughMoneyException {
		try {
			a.withdraw(amount);
		} finally {
			System.out.println("withdrawMoney:  Should print EVERY time, no matter what!");
		}
	}
}
