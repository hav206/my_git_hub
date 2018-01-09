package com.revature.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;

public class Emp_reimbursement implements Reimbursement{

	@Override
	public void reimbursementInfo(int r_id, int r_amount, String desc, String blob, 
			Timestamp r_submitted,Timestamp r_resolved, int u_id, 
			int u_id_resolver, int rt_type, int rt_status) {
		
		
	}

	@Override
	public byte[] readBlob(String file) 
	{
		ByteArrayOutputStream bos = null;
		try 
		{
			File f = new File(file); // needs to ask
			FileInputStream fis = new FileInputStream(f);
			byte[] buffer = new byte[1024];
			bos = new ByteArrayOutputStream();
			for (int len = 0; fis.read(buffer) != -1;)
			{
				bos.write(buffer,0,len);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return bos != null? bos.toByteArray() : null;
		
	}

}
