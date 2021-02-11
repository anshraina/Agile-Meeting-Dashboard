package com.ansh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.dto.TasksDAO;

/**
 * Servlet implementation class CompleteTaskController
 */
@WebServlet("/completeTask")
public class CompleteTaskController extends HttpServlet {
	private TasksDAO tasksDAO;
	public void init() {
		tasksDAO = new TasksDAO();
	}
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		completeTask(request, response);
	}

	private void completeTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("taskId"));
		tasksDAO.updateStatus(id);
		response.sendRedirect("MemberWindow?");
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
