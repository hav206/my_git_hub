package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.model.ErsUser;
import com.revature.service.Emp_reimbursement;

public class DaoUserDBConnection implements DaoErUser{
	
	      

	private String url = "jdbc:oracle:thin:@usfdbjava.cbacfsb9ddtg.us-east-2.rds.amazonaws.com:1521:orcl";
	private String username = "user00";
	private String password = "pass1234";
	
	static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	public boolean isRegistered(int user_id, String U_username, String U_password, String U_firstname, String U_lastname,
	String U_email, int U_urid)
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//System.out.println("Test");
			String sql = "insert into ers_users (U_ID , U_USERNAME , U_PASSWORD , U_FIRSTNAME , U_LASTNAME ,  U_EMAIL , UR_ID) "
					+ "values(?,?,?,?,?,?,?) ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, U_username);
			ps.setString(3, U_password);
			ps.setString(4,U_firstname);
			ps.setString(5, U_lastname);
			ps.setString(6, U_email);
			ps.setInt(7, U_urid);
			ps.executeQuery();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public void insertEmp_Roles(int emp_id, String emp_role) {
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "insert into user_roles (UR_ID, UR_ROLE) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ps.setString(2, emp_role);
			ps.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public String emp_userName(String emp_user)
	{
		//System.out.println("username " + emp_user);
		String sql = "select U_USERNAME from ers_users where U_USERNAME = ?";
		String user_id = "";
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//System.out.println("connecting with data");
			//System.out.println("username " + emp_user);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp_user);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				user_id = rs.getString(1);
			}
			//System.out.println("user_id " + user_id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user_id;
	}
	
	public String emp_password(String emp_user)
	{
		String sql = "select U_PASSWORD from ers_users where U_PASSWORD = ?";
		String pword = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp_user);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
		
			while(rs.next())
			{
				pword = rs.getString(1);
				//System.out.println("password" + pword);
			}
			//System.out.println("pass word" + pword);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return pword;
	}
	
	public String homepageView(ErsUser emp)
	{
		//System.out.println("TEST");
		//String sql = "select U_ID, U_USERNAME,U_PASSWORD,U_FIRSTNAME,U_LASTNAME, U_EMAIL, UR_ID from ers_users where U_ID = ?";
		String sql = "select ers_users.U_ID ,ers_users.U_USERNAME, ers_users.U_PASSWORD ,"
				+ "ers_users.U_FIRSTNAME, ers_users.U_LASTNAME, ers_users.U_EMAIL, "
				+ "ers_users.UR_ID, user_roles.UR_ROLE "
				+ "from ers_users  inner join user_roles ON user_roles.UR_ID = ers_users.ur_id"
				+ " WHERE U_USERNANE = ?";
		
		String employee = " ";
		//System.out.println("TEST");
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//System.out.println("TEST");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getU_userName());
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				//System.out.println("TEST");
				employee = rs.getString(1);
				employee += " " + rs.getString(2);
				employee += " " + rs.getString(3);
				employee += " " + rs.getString(4);
				employee += " " +rs.getString(5);
				employee += " " + rs.getString(6);
				employee += " " +rs.getString(7);
				employee += " " + rs.getString(8);
				System.out.println("String " + employee);
			}
			//System.out.println("TEST");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void emp_reimbursement(int emp_id, int mulla) {
		String sql = " ";
		try
		{
			if( mulla <= 0)
			{
				System.out.println("the reimbursement can't <= 0 ");
				return;
			}
			else
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/*@Override
	public String emp_status(int emp_id) {
		String sql = "select user_roles.UR_ROLE from user_roles \r\n" + 
				"inner join ERS_USERS ON user_roles.UR_ID = ers_users.ur_id\r\n" + 
				"WHERE ers_users.u_id = ?";
		String em_status = " ";
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//System.out.println("TEST");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				em_status = rs.getString(1);
				
			}
			System.out.print("emp " + em_status);
			return em_status;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return em_status;
	}*/

	@Override
	public void setup_reimbursement(int r_id, int r_amount, String desc, String blob, Timestamp r_submitted,
			Timestamp r_resolved, int id_author, int rt_type, int rt_status, int rs_id, int rs_status, int rt_id) {
		/*String sql = "select ers_users.U_ID, \r\n" + 
				"\r\n" + 
				"ers_reimbursements.R_ID,\r\n" + 
				"ers_reimbursements.R_AMOUNT,\r\n" + 
				"ERS_REIMBURSEMENTS.R_DESCRIPTION,\r\n" + 
				"ERS_REIMBURSEMENTS.R_RECEIPT,\r\n" + 
				"ERS_REIMBURSEMENTS.R_SUBMITTED,\r\n" + 
				"ERS_REIMBURSEMENTS.U_ID_RESOLVER,\r\n" + 
				"ERS_REIMBURSEMENTS.U_ID_AUTHOR,\r\n" + 
				"ERS_REIMBURSEMENTS.RT_TYPE,\r\n" + 
				"ERS_REIMBURSEMENTS.RT_STATUS,\r\n" + 
				"ers_reimbursement_status.rs_id,\r\n" + 
				"ers_reimbursement_status.rs_status,\r\n" + 
				"ers_reimbursement_type.rt_id,\r\n" + 
				"from ERS_REIMBURSEMENT_TYPE, ERS_REIMBURSEMENTS,ERS_USERS, ERS_REIMBURSEMENT_STATUS\r\n" + 
				"where ERS_USERS.UR_ID = ERS_REIMBURSEMENTS.U_ID_RESOLVER and \r\n" + 
				"ERS_REIMBURSEMENTS.RT_STATUS = ERS_REIMBURSEMENT_STATUS.RS_STATUS\r\n" + 
				"and ERS_REIMBURSEMENTS.RT_TYPE = ers_reimbursement_type.rt_type group by  \r\n" + 
				"ers_users.UR_ID, \r\n" + 
				"ers_reimbursements.R_ID,\r\n" + 
				"ers_reimbursements.R_AMOUNT,\r\n" + 
				"ERS_REIMBURSEMENTS.R_DESCRIPTION,\r\n" + 
				"ERS_REIMBURSEMENTS.R_RECEIPT,\r\n" + 
				"ERS_REIMBURSEMENTS.R_SUBMITTED,\r\n" + 
				"ERS_REIMBURSEMENTS.U_ID_AUTHOR,\r\n" + 
				"ERS_REIMBURSEMENTS.U_ID_RESOLVER,\r\n" + 
				"ERS_REIMBURSEMENTS.RT_TYPE,\r\n" + 
				"ERS_REIMBURSEMENTS.RT_STATUS,\r\n" + 
				"ers_reimbursement_status.rs_id,\r\n" + 
				"ers_reimbursement_status.rs_status,\r\n" + 
				"ers_reimbursement_type.rt_id,\r\n" + 
				"ers_reimbursement_type.rt_type having ers_users.u_id = ?";*/
		
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			//System.out.println("TEST");
			//PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, emp_id);
			//ps.executeQuery();
			//ResultSet rs = ps.executeQuery();
			
			//while(rs.next())
			//{
				
			//}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void reimbursement_table(int r_id, int r_amount, String desc, String blob, Timestamp r_submitted,
			Timestamp r_resolved, int id_author, int rt_type, int rt_status) {
		String sql = "insert into ers_reimbursements(r_id, R_AMOUNT,r_description, r_receipt, r_submitted,"
				+ " r_resolved, u_id_author, u_id_resolver, rt_type, rt_status) values(?,?,?,?,?,?,?,?,?)";
		byte []temp;
		Emp_reimbursement fileReader = new Emp_reimbursement();
		temp = fileReader.readBlob(blob);
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ps.setInt(2, r_amount);
			ps.setString(3, desc);
			ps.setBytes(4, temp);
			ps.setTimestamp(5, r_submitted);
			ps.setTimestamp(6, r_resolved);
			ps.setInt(7, id_author);
			ps.setInt(8, rt_type);
			ps.setInt(9, rt_status);
			ps.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public String emp_status(String emp) {
		String sql = "select ur_role from user_roles\r\n" + 
				"inner join ers_users on ers_users.UR_ID = user_roles.UR_ID\r\n" + 
				"where ers_users.U_USERNAME = ?";
		String status = "";
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				status = rs.getString(1);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
}
