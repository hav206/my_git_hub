package com.revature.service;

import java.sql.Timestamp;

public interface Reimbursement {
	public void reimbursementInfo(int r_id, int r_amount, String desc, String blob,
			Timestamp r_submitted, Timestamp r_resolved, int u_id, 
			int u_id_resolver, int rt_type,int rt_status );
	
	public byte[] readBlob(String file);
}
