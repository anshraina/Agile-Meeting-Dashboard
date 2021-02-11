package com.ansh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ansh.email.EmailIMAP;

@WebServlet("/EmailReaderServlet")
public class EmailReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*EmailReader mailRead = new EmailReader();
		mailRead.check("pop.gmail.com", "pop3", "rainaansh13@gmail.com", "livelifelikeaqueen123");*/
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmailIMAP mailImap = new EmailIMAP();
		try {
			mailImap.GmailFetch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("managerController?");
	}
	

}
