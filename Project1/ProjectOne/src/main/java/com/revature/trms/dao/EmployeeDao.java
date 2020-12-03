package com.revature.trms.dao;

import java.sql.SQLException;

import com.revature.trms.model.Employee;

public interface EmployeeDao {
	
	public Employee getEmployeeByUsername(String username) throws SQLException;
	
	public boolean isUsernameInDatabase(String username) throws SQLException;
	
}
