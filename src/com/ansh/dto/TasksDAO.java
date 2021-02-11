package com.ansh.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ansh.model.Tasks;
import com.ansh.utils.JDBCUtils;

public class TasksDAO {
	private static final String SELECT_ALL_TASKS = "select idTasks, name, issued_date, last_date, assigned_to, description, status from tasks";
	private static final String UPDATE_ASSIGNEE = "update tasks set assigned_to = ? where idTasks=?";
	private static final String SELECT_USER_BY_ID = "select name, issued_date, last_date, description from tasks where assigned_to = ?";
	private static final String SELECT_TASKS_BY_MEMBER_ID = "select idTasks,name,issued_date, last_date, description, status from tasks where assigned_to = ? ";
	private static final String UPDATE_STATUS_OF_TASKS = "update tasks set status = 'c' where idTasks=?";
	private static final String SELECT_A_TASK = "select idTasks, name, issued_date, last_date, description from tasks where idTasks = ?";
	private static final String UPDATE_TASK = "update tasks set name = ?, issued_date = ?, last_date = ?, description = ? where idTasks = ?";
	private static final String DELETE_TASK = "delete from tasks where idTasks = ?";
	
	public TasksDAO(){
		
	}
	
	public List<Tasks> selectAllTasks(){
		List<Tasks> task = new ArrayList<Tasks>();
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_TASKS);){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("idTasks");
				String name = rs.getString("name");
				Date issuedDate = rs.getDate("issued_date");
				Date lastDate = rs.getDate("last_date");
				String description = rs.getString("description");
				int assignedTo = rs.getInt("assigned_to");
				String status =  rs.getString("status");
				Tasks selTasks = new Tasks(id, name, issuedDate,lastDate, description, assignedTo, status);
				task.add(selTasks);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	public boolean updateTask(Tasks task) {
		boolean updated = false;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(UPDATE_ASSIGNEE);){
				stmt.setInt(1, task.getAssignedTo());	
				stmt.setInt(2, task.getId());
				
				updated = stmt.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updated;
	}
	
	public Tasks selectUserById(int id) {
		Tasks task = null;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_USER_BY_ID);){
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					String name = rs.getString("name");
					Date issued_date = rs.getDate("issued_date");
					Date last_date = rs.getDate("last_date");
					String description = rs.getString("description");
					task = new Tasks(name, issued_date, last_date, description);					
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	
	public List<Tasks> selectMemberTasks(int id) {
		List<Tasks> task = new ArrayList<Tasks>();
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_TASKS_BY_MEMBER_ID);){
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					int idTask = rs.getInt("idTasks");
					String name = rs.getString("name");
					Date issued_date = rs.getDate("issued_date");
					Date last_date = rs.getDate("last_date");
					String description = rs.getString("description");
					String status = rs.getString("status");
					Tasks taskList = new Tasks(idTask, name, issued_date, last_date, description, status);
					task.add(taskList);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	public boolean updateStatus(int id){
		boolean updateStatus = false;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(UPDATE_STATUS_OF_TASKS);){
				stmt.setInt(1, id);
				updateStatus = stmt.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updateStatus;
	}
	
	public Tasks selectATask(int id) {
		Tasks task = null;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_A_TASK);){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int idTask = rs.getInt("idTasks");
				String name = rs.getString("name");
				Date issued_date = rs.getDate("issued_date");
				Date last_date = rs.getDate("last_date");
				String description = rs.getString("description");
				task = new Tasks(idTask, name, issued_date, last_date, description);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	
	public boolean updateTaskDetails(Tasks task) {
		boolean updated = false;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(UPDATE_TASK);){
			int id = task.getId();
			String name = task.getName();
			Date issuedDate = task.getIssuedDate();
			Date lastDate = task.getLastDate();
			java.sql.Date issuedDateSQL = new java.sql.Date(issuedDate.getTime());
			java.sql.Date lastDateSQL = new java.sql.Date(lastDate.getTime());
			
			String description = task.getDescription();
			stmt.setString(1, name);
			stmt.setDate(2, issuedDateSQL);
			stmt.setDate(3, lastDateSQL);
			stmt.setString(4, description);
			stmt.setInt(5, id);
			updated = stmt.executeUpdate() > 0 ;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updated;
		
	}
	
	public boolean deleteTask(int id) {
		boolean deleted = false;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(DELETE_TASK);){
				stmt.setInt(1, id);
				deleted = stmt.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
}
