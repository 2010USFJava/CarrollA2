package com.revature.driver;

import com.revature.beans.Accounts;
import com.revature.menu.Menu;
import com.revature.util.Files;

public class Driver {
	static {Files.readFile();}
	
	public static void main(String[] args) {
		Accounts account = new Accounts("123", 0.0, "chacking");
		Menu.startupMenu(account);

	}

}
