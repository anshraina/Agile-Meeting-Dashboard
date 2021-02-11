package com.ansh.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.dto.TasksDAO;
import com.ansh.model.Tasks;

/**
 * Servlet implementation class SaveDetailsController
 */
@WebServlet("/saveDetails")
public class SaveDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TasksDAO tasksDAO;
	public void init() {
		tasksDAO = new TasksDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateTask(request, response);
	}
	
	private void updateTask(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String task_name = request.getParameter("name");
			String issuedDate = request.getParameter("issued_date");
			String lastDate = request.getParameter("last_date");
			String description = request.getParameter("description");
			System.out.println(id + task_name + issuedDate + lastDate + description);
			Date utilDate_issued = new SimpleDateFormat("yyyy-MM-dd").parse(issuedDate);
			Date utilDate_last = new SimpleDateFormat("yyyy-MM-dd").parse(lastDate);
			
			Tasks task = new Tasks(id, task_name, utilDate_issued, utilDate_last, description);
			tasksDAO.updateTaskDetails(task);
			response.sendRedirect("managerController?Manager+Window=Manager+Window");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
