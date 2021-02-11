package com.ansh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ansh.dto.MembersDAO;
import com.ansh.dto.TasksDAO;
import com.ansh.model.Tasks;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/memberLogin")
public class MemberLogin extends HttpServlet {
	
	private MembersDAO membersDAO;
	private TasksDAO tasksDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		membersDAO = new MembersDAO();
		tasksDAO = new TasksDAO();
	}
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		checkCredentials(request, response);
		HttpSession session = request.getSession();
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private void checkCredentials(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		int id = membersDAO.checkCredentials(username, password);
		if(id == -1) {
			request.setAttribute("UserId", id);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("memberLogin.jsp");
			requestDispatcher.forward(request, response);
			//response.sendRedirect("/memberLogin.jsp");
			
		}else {
			List<Tasks> task = tasksDAO.selectMemberTasks(id);
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("listTasks", task);
			response.sendRedirect("member.jsp");
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
