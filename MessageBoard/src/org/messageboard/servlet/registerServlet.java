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

import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		
		String phoneNumber = request.getParameter("phone_number");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));	//前端验证
		String gender = request.getParameter("gender");
		String Email = request.getParameter("Email");
		String ID = request.getParameter("ID");
		String pwd = request.getParameter("pwd");
		String cTime = ft.format(dNow);
		
		
		User user = new User(phoneNumber, userName, age, gender, Email, ID, pwd, cTime);
		
		IMessageBoardService messageBoardServeice = new MessageBoardServiceImpl();
		
		String str = messageBoardServeice.AddUser(user);
		
		System.out.println("Add user: "+str);
		
		if(str.equals("success...")) {
			user.setUserStatus("normal");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);	//后期需要用到userStatus
			session.setAttribute("NoteRegister", "userRegisterSuccess...");
			
			response.sendRedirect("Demo18/userPage.jsp");
			//request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("Note", "手机号已注册，请使用其他手机号！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
