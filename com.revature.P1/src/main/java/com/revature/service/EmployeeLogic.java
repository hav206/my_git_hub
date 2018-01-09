package com.revature.service;

import com.revature.model.ErsUser;

//import com.revature.model.BankUser;

public interface EmployeeLogic {
	
	public boolean validateUser(String username, String pw);
	public boolean validateUser(ErsUser emp);
	//public void emp_homepage(ErsUser emp);
	//public String employeeInfo(int emp_id);
	//public boolean employeeRegistered();
	//public  void employeeRebursement(int emp_id, boolean approval, int mulla);
	//public String emp_fromDaopw(String emp_user);
	//public String emp_fromDaousername(String emp_user);
	//public boolean validateUser(String user, String pw);
}