package com.revature.service;

import com.revature.DAO.DaoUserDBConnection;
import com.revature.model.ErsUser;

public class EmployeeService implements EmployeeLogic {

	public boolean validateUser(String username, String pw) {
		
		DaoUserDBConnection dao = new DaoUserDBConnection();
		
	
		ErsUser ers_user = new ErsUser();
		if(ers_user != null)
		{
			ers_user.setU_userName(username);
			ers_user.setU_password(pw);
		}
	
	
		if (dao != null && ers_user != null)
		{
			
			if(dao.emp_userName(username).equals(ers_user.getU_userName())
			&& dao.emp_password(pw).equals(ers_user.getU_password()))
			{
				return true;
			}
		
		}
		return false;
	}

	public boolean validateUser(ErsUser emp) {
		DaoUserDBConnection dao = new DaoUserDBConnection();
		
		
	
		if (dao != null )
		{
			
			if(dao.emp_userName(emp.getU_userName()).equals(emp.getU_userName())
			&& dao.emp_password(emp.getU_password()).equals(emp.getU_password()))
			{
				
				return true;
			}
		
		}
		return false;
	
	}

	/*@Override
	public void employeeRebursement(int emp_id, boolean approval, int mulla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String emp_fromDaopw(String emp_user) {
		// TODO Auto-generated method stub
		return null;
	}*/

	//@Override
	/*public String emp_fromDaousername(String emp_user) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public boolean validateUser(String user, String pw) {
		// TODO Auto-generated method stub
		return false;
	} */

	
	
	/*@Override
	public boolean employeeRegistered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String employeeInfo(int emp_id) {
		String temp = " ";
		DaoUserDBConnection emp_Info = new  DaoUserDBConnection();
		
		temp =  emp_Info.homepageView(emp_id);
		if (temp == " ")
		{
			return null;
		}
		System.out.println("temp " + temp);
		return temp;
		
	}

	@Override
	public void employeeRebursement(int emp_id, boolean approval, int mulla) {
		if (approval == false)
		{
			return;
		}
		else
		{
			
		}
	}

	
	//public boolean validateUser(int id_user, String pw) {
		//if (emp_fromDaopw(id_user).equals(pw)  && emp_fromDaousername(id_user).equals(id_user) )
		//{
			//return true;
		//}
		//return false;
	//}


	public String emp_fromDaopw(String emp_pw) {
		String pw = " ";
		DaoUserDBConnection DaoUser = new DaoUserDBConnection();
		pw = DaoUser.emp_password(emp_pw);
		return pw;
	}
	
	public String emp_fromDaousername(String emp_username) {
		String username;
		DaoUserDBConnection DaoUser = new DaoUserDBConnection();
		username  = DaoUser.emp_userName(emp_username);
		return username;
	}

	@Override
	public boolean validateUser(String user, String pw) {
		if (emp_fromDaopw(pw).equals(pw)  && emp_fromDaousername(user).equals(user) )
		{
			return true;
		}
	
		return false;
	}

	
	
	/*public boolean employeeRegistered(user_id, U_username, U_password, U_firstname, U_lastname, U_email, U_urid) {
		DaoUserDBConnection emp_registered = new  DaoUserDBConnection();
		if (emp_registered != null)
		{
			emp_registered.isRegistered(user_id, U_username, U_password, U_firstname, U_lastname, U_email, U_urid)
		}
		return false;
	}*/
	
	

}
