package org.messageboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/userDeleteServlet")
public class userDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		String phoneNumber = request.getParameter("phoneNumber");
		
		String res = messageBoardService.DeleteUser(phoneNumber);
		System.out.println("delete user :"+res);
		
		if(res.equals("success...")) {
			request.setAttribute("Note", "success...");
			request.getRequestDispatcher("userManagementServlet").forward(request, response);
		}else {
			request.setAttribute("Note", "fail");
			request.getRequestDispatcher("userManagementServlet").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
