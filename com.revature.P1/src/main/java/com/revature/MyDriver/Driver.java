package com.revature.MyDriver;

import java.io.File;

import com.revature.DAO.DaoUserDBConnection;
import com.revature.model.ErsUser;
import com.revature.service.EmployeeService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DaoUserDBConnection DuDB = new DaoUserDBConnection();
		////String filepath = "C:\\Users\\hav20\\Desktop\\cute.jpg";
	    //DuDB.reimbursement_table(10, 20, "something was wrong",
	    		//filepath, "JAN-8-2017 13:10:11",
	    		//"JAN-8-2017 13:10:11", 5460, 1,1);
		//DuDB.insertEmp_Roles(1, "Manager");
		//DuDB.insertUser(5460, "206", "123", "Long", "Ha", "", 1);
		EmployeeService emp = new EmployeeService();
		emp.validateUser("206", "123");
		//DuDB.insertUser(5461, "207", "1234", "SASA", "Ha", "", 2);
		//DuDB.homepageView(5460);
		//Employee emp = new Employee();
		//emp.employeeInfo(5460);
	}

}
