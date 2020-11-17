package com.revature.bank.doaImpl;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.bean.*;
import com.revature.bank.dao.UserDao;
import com.revature.bank.exception.CannotDeleteAccountException;
import com.revature.bank.util.DBConnection;
import com.revature.bank.util.Verify;

public class UserDaoImpl implements UserDao {
	public static DBConnection db = DBConnection.getInstance();

	@Override
	public List<User> loadUsers() throws SQLException {
		Connection connect = db.getConnection();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		List<User> uList = new ArrayList<>();
		User a = null;
		while (rs.next()) {
			//for each field and data type
			a = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), 
					rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10),rs.getString(11));
			uList.add(a);
		}
		return uList;
	}
	@Override
	public List<Account> getAccountsByUsername(String username) throws SQLException {
		List<Account> aList = new ArrayList<>();
		Connection connect = db.getConnection();
		String selectQuery = "select * from user_accounts where username=?";
		PreparedStatement prepStmt = connect.prepareStatement(selectQuery);
		prepStmt.setString(1, username);
		ResultSet rs = prepStmt.executeQuery();
		Account a = null;
		if (rs.next()) {
			//for each field and data type
			a = new Account(rs.getInt(2), rs.getString(4), rs.getDouble(5));
			aList.add(a);
		}
		return aList;
	}
	@Override
	public int getUserIdFromDatabase(String username) throws SQLException {
		Connection connect = db.getConnection();
		String selectQuery = "select id from users where username=?";
		PreparedStatement prepStmt = connect.prepareStatement(selectQuery);
		prepStmt.setString(1, username);
		ResultSet rs = prepStmt.executeQuery();
		int id = 0;
		while (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}
	@Override
	public boolean verifyUsername(String username) throws SQLException {
		//test if username exists
		Connection connect = db.getConnection();
		String selectQuery = "select * from users where username=?";
		PreparedStatement prepStmt = connect.prepareStatement(selectQuery);
		prepStmt.setString(1, username);
		ResultSet rs = prepStmt.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	@Override
	public User findUserByUsername(String username) throws SQLException {
		//return user based on username
		Connection connect = db.getConnection();
		String selectQuery = "select * from users where username=?";
		PreparedStatement prepStmt = connect.prepareStatement(selectQuery);
		prepStmt.setString(1, username);
		ResultSet rs = prepStmt.executeQuery();
		User user = null;
		while (rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), 
				rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10),rs.getString(11));
		}
		return user;
	}
	@Override
	public void addUser(User user) throws SQLException {
		//add new user to database
		Connection connect = db.getConnection();
		String insertQuery = "insert into users values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement prepStmt = connect.prepareStatement(insertQuery);
		prepStmt.setString(1, user.getFirstName());
		prepStmt.setString(2, user.getLastName());
		prepStmt.setString(3, user.getSs());
		prepStmt.setString(4, user.getStreet());
		prepStmt.setString(5, user.getCity());
		prepStmt.setString(6, user.getState());
		prepStmt.setInt(7, user.getZip());
		prepStmt.setString(8, user.getUsername());
		prepStmt.setString(9, user.getPassword());
		prepStmt.setString(10, user.getType());
		prepStmt.executeUpdate();	
	}
	@Override
	public void updateUserInfo(String field, String newInfo, String username) throws SQLException {
		//update user info based on field name
		Connection connect = db.getConnection();
		String updateQuery = "update users set street=? where username=?";
		PreparedStatement prepStmt = connect.prepareStatement(updateQuery);
/*		switch (field.toLowerCase()) {
		case "first name": 
			prepStmt.setString(1, "'first_name'");
			prepStmt.setString(2, newInfo);
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();
		case "last name": 
			prepStmt.setString(1, "last_name");
			prepStmt.setString(2, newInfo);
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();*/
//		case "street address": 
//			prepStmt.setString(1, "street");
			prepStmt.setString(1, newInfo);
			prepStmt.setString(2, username);
			prepStmt.executeUpdate();
/*		case "city": 
			prepStmt.setString(1, "city");
			prepStmt.setString(2, newInfo);
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();
		case "state": 
			prepStmt.setString(1, "state");
			prepStmt.setString(2, newInfo);
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();
		case "zip code": 
			prepStmt.setString(1, "zip");
			prepStmt.setInt(2, Integer.valueOf(newInfo));
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();
		case "username": 
			prepStmt.setString(1, "username");
			prepStmt.setString(2, newInfo);
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();
		case "password": 
			prepStmt.setString(1, "password");
			prepStmt.setString(2, newInfo);
			prepStmt.setString(3, username);
			prepStmt.executeUpdate();
		}*/
	}
	@Override
	public void deleteCustomerAndAccounts(User user) throws SQLException, CannotDeleteAccountException {
		Connection connect = db.getConnection();
		String selectQuery = "select balance from accounts where id=?";
		PreparedStatement prepStmt = connect.prepareStatement(selectQuery);
		//before deletion check if accounts are empty
		if (!(user.getAccounts().contains(null))) {
			for (int i=0; i<user.getAccounts().size(); i++) {
				prepStmt.setInt(1, user.getAccounts().get(i).getAccountId());
				ResultSet rs = prepStmt.executeQuery();
				while (rs.next()) {
					double balance = rs.getDouble(1);
				if (balance > 0) {
					throw new CannotDeleteAccountException("There is money in account. Account cannot be deleted.");
				} else {
					String deleteQuery = "delete from accounts where id=?";
					prepStmt = connect.prepareStatement(deleteQuery);
					prepStmt.setInt(1, user.getAccounts().get(i).getAccountId());
					prepStmt.executeQuery();
					//After deleting accounts on accounts table, delete them from user_account table
					deleteQuery = "delete from user_account where id=?";
					prepStmt = connect.prepareStatement(deleteQuery);
					prepStmt.setInt(1, user.getAccounts().get(i).getAccountId());
					prepStmt.executeQuery();
				}
				}
			} 
		}
		String deleteQuery = "delete from users where username=?";
		prepStmt = connect.prepareStatement(deleteQuery);
		prepStmt.setString(1, user.getUsername());
		prepStmt.executeQuery();
	}
}
