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
import com.ansh.model.Members;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/userDetails")
public class UserDetails extends HttpServlet {
	private MembersDAO membersDAO;
	public void init() {
		membersDAO = new MembersDAO();
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		fetchMemberDetails(request, response);
	}
	
	private void fetchMemberDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Members> member = new ArrayList<Members>(); 
		member = membersDAO.selectAllMembers();
		request.setAttribute("memberList", member);
		RequestDispatcher rd = request.getRequestDispatcher("memberDetails.jsp");
		rd.forward(request, response);
		
	}

}
