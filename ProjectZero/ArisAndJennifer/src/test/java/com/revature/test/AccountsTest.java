package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.beans.Accounts;

public class AccountsTest {
	static Accounts accountA = new Accounts("147", 100.0, "checking");
	
	@Test
	public void withdrawTest() {
		double remaining = accountA.withdraw(25.0);
		assertEquals(remaining, 75.0); 
	}
	@Test
	public void depositTest() {
		
	}

}
