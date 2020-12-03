package com.revature.trms.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.trms.model.Document;

public interface DocumentDao {
	
	public List<Document> getDocsByRequestId(int requestId) throws SQLException;
	
	public void insertDoc(Document doc) throws SQLException;
}
