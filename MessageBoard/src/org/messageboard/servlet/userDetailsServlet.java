package org.messageboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/userDetailsServlet")
public class userDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		boolean flag = false;
		String note = null;
		String phoneNumber = request.getParameter("phoneNumber");
		
		if(phoneNumber == null) {
			phoneNumber = (String) request.getAttribute("phoneNumber");
			note = (String) request.getAttribute("Note");
			flag = true;
		}
		
		IMessageBoardService messageService = new MessageBoardServiceImpl();
		
		User user = messageService.QueryUser(phoneNumber);
		
		if(user == null) {
			System.out.println("Query user :" + "fail or exception...");
		}else {
			
			if(flag) {
				request.setAttribute("Note", note);
			}
			System.out.println("Query user :" + "success...");
			request.setAttribute("user", user);
			request.getRequestDispatcher("userDetails.jsp").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
