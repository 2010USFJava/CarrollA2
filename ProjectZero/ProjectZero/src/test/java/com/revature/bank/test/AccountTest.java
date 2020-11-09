package com.revature.bank.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.beans.Account;

public class AccountTest {
	public static Account test;
	public static Account test2; 

	@BeforeClass
	public static void makeConstructorsToTest() {
		test = new Account("35205", "savings");
		test2 = new Account("32145", "savings","1500");
	}
	@Test
	public void setBalanceTest() {
		test.setBalance("10000");
		assertEquals(100.0, test.getBalance(),0);
	}
	@Test
	public void withdrawTest() {
		test2.withdraw("1000");
		assertEquals(5.0, test2.getBalance(),0);
		assertTrue(test2.withdraw("500"));
		assertFalse(test2.withdraw("4/3"));
		assertFalse(test2.withdraw("10000"));
	}
	@Test
	public void depositTest() {
		test.deposit("2000");
		assertEquals(30.0, test.getBalance(),0);
	}
	@Test
	public void transferTest() {
		test2.transfer("35205", "1000");
		assertEquals(5.0, test2.getBalance(),0);
		assertEquals(10.0, test.getBalance(),0);
	}

}
