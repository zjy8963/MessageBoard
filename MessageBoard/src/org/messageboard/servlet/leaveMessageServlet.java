package org.messageboard.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.messageboard.entity.Message;
import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/leaveMessageServlet")
public class leaveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		User user = (User) session.getAttribute("user");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userKey = user.getPhoneNumber();
		String mTime = ft.format(dNow);
		
		Message message = new Message(title, content, userKey, mTime);
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		String res = messageBoardService.AddMessage(message);
		
		System.out.println("Add message: "+res);
		
		if(res.equals("success...")) {
			request.setAttribute("Note", "success...");
			request.getRequestDispatcher("messageListServlet").forward(request, response);
		}else {
			//被禁言
			request.setAttribute("Note", "fail...");
			request.getRequestDispatcher("messageListServlet").forward(request, response);
		}
		
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
