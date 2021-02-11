package com.ansh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.dto.MembersDAO;
import com.ansh.dto.TasksDAO;
import com.ansh.email.EmailSend;
import com.ansh.model.Tasks;

/**
 * Servlet implementation class AssignController
 */
@WebServlet("/assignTask")

public class AssignController extends HttpServlet {

	private TasksDAO taskDAO;
	private MembersDAO memDAO;
	private EmailSend emailSend;
	public void init() {
		taskDAO = new TasksDAO();
		memDAO = new MembersDAO();
		emailSend = new EmailSend();
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		updateAssigneeId(request, response);
		response.sendRedirect("managerController?");
	}

	private void updateAssigneeId(HttpServletRequest request, HttpServletResponse response) {
		int member_id = Integer.parseInt(request.getParameter("members"));
		int task_id = Integer.parseInt(request.getParameter("taskId"));
		Tasks task = new Tasks(task_id,member_id);
		taskDAO.updateTask(task);
		System.out.println(member_id);
		System.out.println(task_id);
		
		//Send the email;
		
		String toMailId = memDAO.getEmail(member_id);
		System.out.println(toMailId);
		String fromMail = "rainaansh13@gmail.com";
		Tasks taskEntity = taskDAO.selectUserById(member_id);
		String name = taskEntity.getName();
		String issuedDate = taskEntity.getIssuedDate().toString();
		String lastDate = taskEntity.getLastDate().toString();
		String description = taskEntity.getDescription();
		emailSend.sendEmail(toMailId, fromMail, name, issuedDate, lastDate, description);
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
