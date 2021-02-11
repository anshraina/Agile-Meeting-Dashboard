package com.ansh.model;

import java.util.Date;

public class Tasks {

	private int id;
	private String name;
	private Date issuedDate;
	private Date lastDate;
	private String description;
	private int assignedTo;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Tasks() {
		super();
	}
	public Tasks(int id, String name, Date issuedDate, Date lastDate, String description, int assignedTo, String status) {
		super();
		this.id = id;
		this.name = name;
		this.issuedDate = issuedDate;
		this.lastDate = lastDate;
		this.description = description;
		this.assignedTo = assignedTo;
		this.status = status;
	}
	public Tasks(int id, int assignedTo) {
		this.id = id;
		this.assignedTo = assignedTo;
	}
	public Tasks(String name, Date issued_date, Date last_date, String description) {
		this.name = name;
		this.issuedDate = issued_date;
		this.lastDate = last_date;
		this.description = description;
	}
	public Tasks(int id, String name, Date issued_date, Date last_date, String description) {
		this.id = id;
		this.name = name;
		this.issuedDate = issued_date;
		this.lastDate = last_date;
		this.description = description;
	}
	public Tasks(int idTask, String name2, Date issued_date, Date last_date, String description2, String status2) {
		this.id = idTask;
		this.name = name2;
		this.issuedDate = issued_date;
		this.lastDate = last_date;
		this.description = description2;
		this.status = status2;
	}
	
}
