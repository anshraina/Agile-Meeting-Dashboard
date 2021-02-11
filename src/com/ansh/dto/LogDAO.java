package com.ansh.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ansh.model.Log;
import com.ansh.utils.JDBCUtils;
public class LogDAO {
	
public LogDAO() {
		
}
	private static final String SELECT_ALL = "select * from log";
	
	public List<Log> selectAllRecords(){
			List<Log> logValues = new ArrayList<Log>();
		
		try(Connection con = JDBCUtils.getConnection();
				PreparedStatement stmt = con.prepareStatement(SELECT_ALL);){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					int idLog = rs.getInt("idLog");
					String task_name = rs.getString("task_name");
					int assigned_to = rs.getInt("assigned_to");
					Timestamp timeStamp = rs.getTimestamp("deleted_at");
					java.util.Date deleted_at = timeStamp;
					Log entity = new Log(idLog,task_name, assigned_to, deleted_at);
					logValues.add(entity);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return logValues;
	}
		
}

