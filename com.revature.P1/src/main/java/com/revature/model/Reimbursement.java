package com.revature.model;

import java.security.Timestamp;

public class Reimbursement {
	private int r_id;
	private int r_amount;
	private String r_description;
	private byte[] buff;
	private Timestamp r_submitted; //timestamp
	private Timestamp r_resolve; //timestamp;
	private int id_author;
	private int id_resolver;
	private int rt_type;
	private int rt_status;
	/*
	 * Blob blob = rs.getBlob(column);
		InputStream in = blob.getBinaryStream();
		OutputStream out = new FileOutputStream(someFile);
		byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
		int len = 0;

		while ((len = in.read(buff)) != -1) {
    	out.write(buff, 0, len);
}
	 */
	
	public Reimbursement() {}
	public Reimbursement(Reimbursement Rei)
	{
		this.r_id = Rei.r_id;
		this.r_amount = Rei.r_amount;
		this.r_description = Rei.r_description;
		this.buff = new byte[4096];
		this.r_submitted = Rei.r_submitted;
		this.r_resolve = Rei.r_resolve;
		this.id_author = Rei.id_author;
		this.rt_type = Rei.rt_type;
		this.rt_status = Rei.rt_status;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getR_amount() {
		return r_amount;
	}
	public void setR_amount(int r_amount) {
		this.r_amount = r_amount;
	}
	public String getR_description() {
		return r_description;
	}
	public void setR_description(String r_description) {
		this.r_description = r_description;
	}
	public byte[] getBuff() {
		return buff;
	}
	public void setBuff(byte[] buff) {
		this.buff = buff;
	}
	public Timestamp getR_submitted() {
		return r_submitted;
	}
	public void setR_submitted(Timestamp r_submitted) {
		this.r_submitted = r_submitted;
	}
	public Timestamp getR_resolve() {
		return r_resolve;
	}
	public void setR_resolve(Timestamp r_resolve) {
		this.r_resolve = r_resolve;
	}
	public int getId_author() {
		return id_author;
	}
	public void setId_author(int id_author) {
		this.id_author = id_author;
	}
	public int getId_resolver() {
		return id_resolver;
	}
	public void setId_resolver(int id_resolver) {
		this.id_resolver = id_resolver;
	}
	public int getRt_type() {
		return rt_type;
	}
	public void setRt_type(int rt_type) {
		this.rt_type = rt_type;
	}
	public int getRt_status() {
		return rt_status;
	}
	public void setRt_status(int rt_status) {
		this.rt_status = rt_status;
	}
	
}
