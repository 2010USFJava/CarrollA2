package com.revature.trms.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.trms.model.*;

public class ModelController {
	
	public static void getSessionEmployee(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Employee emp = (Employee) req.getSession().getAttribute("currentEmployee");
		res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}
	public static void getSessionRequest(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		RequestForm reqForm = (RequestForm) req.getSession().getAttribute("currentRequest");
		res.getWriter().write(new ObjectMapper().writeValueAsString(reqForm));
	}
}
