package com.ansh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.dto.TasksDAO;
import com.ansh.model.Tasks;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/edit")
public class EditController extends HttpServlet {
	private TasksDAO tasksDAO;
	private static final long serialVersionUID = 1L;
	
	public void init() {
		tasksDAO = new TasksDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		editTask(request,response);
	}

	
	private void editTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Tasks task = tasksDAO.selectATask(id);
		System.out.println(task.getName());
		System.out.println(task.getIssuedDate());
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		request.setAttribute("task", task);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
