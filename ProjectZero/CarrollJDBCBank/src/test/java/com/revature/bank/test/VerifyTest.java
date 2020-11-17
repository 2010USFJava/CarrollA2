package com.revature.bank.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.bean.Account;
import com.revature.bank.bean.User;
import com.revature.bank.util.Verify;

public class VerifyTest {
	static Account acc;
	static User cus;
	
	@BeforeClass
	public static void makeConstructorsToTest() {
		acc = new Account("savings", "employee1");
		cus = new User();
		cus.setUsername("username", "employee1");
	}
	@Test
	public void verifyAccountTest() {
		assertTrue(Verify.isAccountInDatabase("32145"));
		assertFalse(Verify.isAccountInDatabase("5562"));
	}
	@Test
	public void findAccountTest() {
		assertEquals(acc, Verify.findAccount("32145"));
		assertEquals(null, Verify.findAccount("45623"));
	}
	@Test
	public void findCustomerTest() {
		assertEquals(cus, Verify.findUser("employee1"));
		assertEquals(null, Verify.findUser("the"));
	}
	@Test
	public void verifyTypeTest() {
		assertEquals("SAVINGS", Verify.verifyType("saVings"));
		assertEquals("Invalid type", Verify.verifyType("saVes"));
	}
	@Test
	public void verifyNumTest() {
		assertTrue(Verify.verifyNum("52"));
		assertFalse(Verify.verifyNum("5.2"));
		assertFalse(Verify.verifyNum("5-2"));
		assertFalse(Verify.verifyNum("5w2"));
	}

}