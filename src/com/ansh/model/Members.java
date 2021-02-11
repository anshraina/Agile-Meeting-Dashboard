package com.ansh.model;

public class Members {
	
	private int members_id;
	private String members_name;
	private String members_email;
	private String members_password;
	public String getMembers_password() {
		return members_password;
	}
	public void setMembers_password(String members_password) {
		this.members_password = members_password;
	}
	public int getMembers_id() {
		return members_id;
	}
	public Members(int members_id, String members_name, String members_email, String members_password) {
		super();
		this.members_id = members_id;
		this.members_name = members_name;
		this.members_email = members_email;
		this.members_password = members_password;
	}
	public void setMembers_id(int members_id) {
		this.members_id = members_id;
	}
	public String getMembers_name() {
		return members_name;
	}
	public void setMembers_name(String members_name) {
		this.members_name = members_name;
	}
	public String getMembers_email() {
		return members_email;
	}
	public void setMembers_email(String members_email) {
		this.members_email = members_email;
	}
	public Members(int members_id, String members_name, String members_email) {
		super();
		this.members_id = members_id;
		this.members_name = members_name;
		this.members_email = members_email;
	}
	public Members(){
		super();
	}
	
	
}
