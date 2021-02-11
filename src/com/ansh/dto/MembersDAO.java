package com.ansh.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ansh.model.Members;
import com.ansh.utils.JDBCUtils;

public class MembersDAO {
	private static final String SELECT_ALL_MEMBERS = "select * from members;";
	private static final String SELECT_MEMBER_EMAIL = "select members_email from members where members_id = ?";
	private static final String SELECT_CREDENTIALS = "select members_id from members where members_email = ? and members_password = ?"; 
	public MembersDAO() {
		
	}
	
	public List<Members> selectAllMembers(){
		List<Members> members = new ArrayList<Members>();
		
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_ALL_MEMBERS);){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("members_id");
					String name = rs.getString("members_name");
					String email = rs.getString("members_email");
					members.add(new Members(id, name, email));
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return members;
	}
	public String getEmail(int id) {
		String email = "";
		try(Connection con = JDBCUtils.getConnection();
				
				
			PreparedStatement stmt = con.prepareStatement(SELECT_MEMBER_EMAIL);){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				email = rs.getString("members_email");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return email;
	}
	
	public int checkCredentials(String username, String password) {
		int id=0;
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_CREDENTIALS);){
				stmt.setString(1, username);
				stmt.setString(2,  password);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					id = rs.getInt("members_id");
				}
				else {
					id = -1;
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
}
