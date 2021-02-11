package com.ansh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ansh.dto.MembersDAO;
import com.ansh.dto.TasksDAO;
import com.ansh.model.Members;
import com.ansh.model.Tasks;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/managerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TasksDAO taskDAO;
	private MembersDAO memberDAO;
	public void init() {
		taskDAO = new TasksDAO();
		memberDAO = new MembersDAO();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showTasks(request, response);
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private void showTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tasks> tasks = new ArrayList<Tasks>();
		List<Members> members = new ArrayList<Members>();
		tasks = taskDAO.selectAllTasks();
		members = memberDAO.selectAllMembers();
		
		/*HttpSession session = request.getSession();
		session.setAttribute("listTasks", tasks);
		session.setAttribute("listMember", members);*/
		request.setAttribute("listTasks", tasks);
		request.setAttribute("listMember", members);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("manager.jsp");
		
		requestDispatcher.forward(request, response);
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
