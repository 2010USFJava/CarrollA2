package com.revature.bank;

import com.revature.bank.beans.User;
import com.revature.bank.menu.OptionMenu;
import com.revature.bank.util.Filing;
import com.revature.bank.util.Verify;

public class BankApp {
	static {Filing.readUserFile();}

	public static void main(String[] args) {
		//User admin = new User();
		//admin.setUserId("32165");
		//admin.setUsername("theAdmin");
		//admin.setPassword("password");
		//admin.setType("admin");
		System.out.println(Verify.userList);
		System.out.println(Verify.userList.get(0).getAccounts());
		System.out.println(Verify.accountList);
		
		OptionMenu.startup();


		
	}

}
