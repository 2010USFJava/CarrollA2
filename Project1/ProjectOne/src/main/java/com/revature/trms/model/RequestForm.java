package com.revature.trms.model;

import java.sql.Timestamp;
import java.util.List;

public class RequestForm {
	
	private int requestId;
	private int employeeId;
	private Timestamp dateMade;
	private String eventDate;
	private String eventTime;
	private String eventLocation;
	private String eventType;
	private String eventDescription;
	private double cost;
	private String status;
	private List<Document> additionalDocs;

}
