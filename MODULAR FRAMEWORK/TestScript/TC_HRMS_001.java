package com.hrms.TestScript;

import com.hrms.LIB.General;

public class TC_HRMS_001 extends General {
	 
	public static void main(String[] args) throws InterruptedException {
		// create object for "General" class
		General gl = new General();
		
		// Test Case steps
		gl.setUp();
		gl.adminLogin();
		gl.addEmp();
		gl.deleteEmp();
		gl.adminLogout();
		gl.tearDown();
	}

}
