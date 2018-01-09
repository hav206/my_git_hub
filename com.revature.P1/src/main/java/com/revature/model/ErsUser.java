package com.revature.model;


//remember to set up the html file
public class ErsUser {
	private int U_id;
	private String U_userName;
	private String U_password;
	private String U_firstname;
	private String U_lastname;
	private String U_email;
	private int Ur_id;
	//private int Ur_role;
	
	public ErsUser() {}
	
	public ErsUser(ErsUser Er)
	{
		this.U_id = Er.U_id;
		this.U_userName = Er.U_userName;
		this.U_password = Er.U_password;
		this.U_firstname = Er.U_firstname;
		this.U_lastname = Er.U_lastname;
		this.U_email = Er.U_email;
		this.Ur_id = Er.Ur_id;
		//this.Ur_role =Er.Ur_role;
	}

	//@Override
	/*public String toString() {
		return "ErsUser [U_id=" + U_id + ", U_userName=" + U_userName + ", U_password=" + U_password + ", U_firstname="
				+ U_firstname + ", U_lastname=" + U_lastname + ", U_email=" + U_email + ", Ur_id=" + Ur_id
				+ ", Ur_role=" + Ur_role + "]";
	}*/

	public int getU_id() {
		return U_id;
	}

	public void setU_id(int u_id) {
		U_id = u_id;
	}

	public String getU_userName() {
		
		return U_userName;
	}

	public void setU_userName(String u_userName) {
		U_userName = u_userName;
	}

	public String getU_password() {
		
		return U_password;
	}

	public void setU_password(String u_password) {
		U_password = u_password;
	}

	public String getU_firstname() {
		return U_firstname;
	}

	public void setU_firstname(String u_firstname) {
		U_firstname = u_firstname;
	}

	public String getU_lastname() {
		return U_lastname;
	}

	public void setU_lastname(String u_lastname) {
		U_lastname = u_lastname;
	}

	public String getU_email() {
		return U_email;
	}

	public void setU_email(String u_email) {
		U_email = u_email;
	}

	public int getUr_id() {
		return Ur_id;
	}

	public void setUr_id(int ur_id) {
		Ur_id = ur_id;
	}

	/*public int getUr_role() {
		return Ur_role;
	}*/

	/*public void setUr_role(int ur_role) {
		Ur_role = ur_role;
	}*/
	
}
