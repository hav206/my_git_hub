package com.revature.model;

public class ReimbursementType {
	private int rt_id;
	private int rs_type;
	
	public ReimbursementType() {}
	public ReimbursementType(int rs_id_args, int rs_type_args)
	{
		rt_id = rs_id_args;
		rs_type = rs_type_args;
	}
	public int getRs_id() {
		return rt_id;
	}
	public void setRs_id(int rs_id) {
		this.rt_id = rs_id;
	}
	public int getRs_status() {
		return rs_type;
	}
	public void setRs_status(int rs_status) {
		this.rs_type = rs_status;
	}
	@Override
	public String toString() {
		return "ReimbursementType [rs_id=" + rt_id + ", rs_status=" + rs_type + "]";
	}
		
}
