package com.ansh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.dto.LogDAO;
import com.ansh.model.Log;

/**
 * Servlet implementation class ShowLogs
 */
@WebServlet("/showLogs")
public class ShowLogsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LogDAO logDAO;
	public void init() {
		logDAO = new LogDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("we are in showLogs");
		try {
			fetchLogs(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void fetchLogs(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		try {
			List<Log> log = new ArrayList<Log>();
			log = logDAO.selectAllRecords();
			request.setAttribute("logItems", log);
			RequestDispatcher rd = request.getRequestDispatcher("logs.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
