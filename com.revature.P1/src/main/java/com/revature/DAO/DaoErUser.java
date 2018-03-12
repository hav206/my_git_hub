package com.revature.DAO;

import java.sql.Timestamp;

import com.revature.model.ErsUser;

public interface DaoErUser {
	public boolean isRegistered(int user_id, String U_username, String U_password, String U_firstname, String U_lastname, String U_email, int U_urid );
	public void insertEmp_Roles(int emp_id, String emp_role);

	public String emp_userName(String emp_user);
	public String emp_password(String emp_user);
	public String homepageView(ErsUser emp);
	public String emp_status(String emp);
	
	public void emp_reimbursement(int emp_id, int mulla);
	public void reimbursement_table(int r_id, int r_amount, String desc, String blob, Timestamp r_submitted,
			Timestamp r_resolved, int id_author, int rt_type, int rt_status);
	public void setup_reimbursement(int r_id, int r_amount, String desc, String blob, Timestamp r_submitted,
			Timestamp r_resolved, int id_author, int rt_type, int rt_status, int rs_id, int rs_status, int rt_id);
	
}
