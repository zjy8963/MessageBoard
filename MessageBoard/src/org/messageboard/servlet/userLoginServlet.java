package org.messageboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String phoneNumber = request.getParameter("phoneNumber");
		String pwd = request.getParameter("pwd");
		User user = new User(phoneNumber, pwd);
		
		HttpSession session = request.getSession();
		IMessageBoardService messageBoardServeice = new MessageBoardServiceImpl();
		
		String str = messageBoardServeice.checkUser(user);
		
		System.out.println("Check user: "+str);
		
		if(str.equals("have not register...")) {
			session.setAttribute("Note", "该手机号未注册，请先注册！");
			response.sendRedirect("Demo18/index.jsp");
		}else if(str.equals("check in...")) {
			
			User quser = messageBoardServeice.QueryUser(user.getPhoneNumber());
			session.setAttribute("user", quser);
			session.setAttribute("NoteRegister", "userLogin...");
			
			response.sendRedirect("Demo18/userPage.jsp");
			//request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			session.setAttribute("Note", "密码错误，请重新登录！");
			response.sendRedirect("Demo18/index.jsp");
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
