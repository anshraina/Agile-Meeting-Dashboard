package com.ansh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.dto.TasksDAO;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private TasksDAO tasksDAO;
	private static final long serialVersionUID = 1L;
	
	public void init() {
		tasksDAO = new TasksDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deleteTask(request, response);
	}
	
	private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tasksDAO.deleteTask(id);
		response.sendRedirect("managerController?");
		
	}

}
