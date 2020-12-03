package com.revature.trms.controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
	
	public static String requestHome(HttpServletRequest req) {
		return "resources/html/request.html";
	}
	public static String employeeHome(HttpServletRequest req) {
		return "resources/html/employee.html";
	}
	public static String managerHome(HttpServletRequest req) {
		return "resources/html/manager.html";
	}
	public static String supervisorHome(HttpServletRequest req) {
		return "resources/html/supervisor.html";
	}
	public static String benCoHome(HttpServletRequest req) {
		return  "resources/html/benCo.html";
	}

}
