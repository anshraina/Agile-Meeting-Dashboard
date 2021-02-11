package com.ansh.model;

import java.util.Date;

public class Log {

	private int idLog;
	private String task_name;
	private int assigned_to;
	private Date deleted_at;
	public int getIdLog() {
		return idLog;
	}
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public int getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(int assigned_to) {
		this.assigned_to = assigned_to;
	}
	public Date getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	public Log(int idLog, String task_name, int assigned_to, Date deleted_at) {
		super();
		this.idLog = idLog;
		this.task_name = task_name;
		this.assigned_to = assigned_to;
		this.deleted_at = deleted_at;
	}
}
