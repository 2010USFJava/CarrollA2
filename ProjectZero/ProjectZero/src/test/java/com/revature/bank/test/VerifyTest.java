package com.revature.bank.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.beans.Account;
import com.revature.bank.beans.User;
import com.revature.bank.util.Verify;

public class VerifyTest {
	static Account acc;
	static User cus;
	
	@BeforeClass
	public static void makeConstructorsToTest() {
		acc = new Account("32145", "savings");
		cus = new User();
		cus.setUserId("32654");
		Verify.userIds.add("32654");
	}
	@Test
	public void verifyAccountTest() {
		assertTrue(Verify.verifyAccount("32145"));
		assertFalse(Verify.verifyAccount("5562"));
	}
	@Test
	public void findAccountTest() {
		assertEquals(acc, Verify.findAccount("32145"));
		assertEquals(null, Verify.findAccount("45623"));
	}
	@Test
	public void findCustomerTest() {
		assertEquals(cus, Verify.findCustomer("32654"));
		assertEquals(null, Verify.findCustomer("12345"));
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
