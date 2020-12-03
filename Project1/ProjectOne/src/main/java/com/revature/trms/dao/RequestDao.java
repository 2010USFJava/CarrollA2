package com.revature.trms.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.trms.model.RequestForm;

public interface RequestDao {
	
	public RequestForm getRequestByEmployeeId(int employeeId) throws SQLException;
	
	public List<RequestForm> viewAllRequest() throws SQLException;
	
	public void insertNewRequest(RequestForm request) throws SQLException;
	
	public void updateRequest(String field, String newInfo) throws SQLException;
	
	public void cancelRequest(int requestId) throws SQLException;
}
