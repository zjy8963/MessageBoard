package org.messageboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.messageboard.entity.Admin;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String key = "lovemagic";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String keyWord = request.getParameter("keyWord");
		
		if(keyWord.equals(key)) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
			
			Admin check = messageBoardService.QueryAdmin(id);
			
			
			if(check == null) {
				System.out.println("Check admin: " + "have not register...");
				request.setAttribute("Note", "该ID未注册，请联系管理员注册！");
				request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
			}else {
				if(check.getPwd().equals(pwd)) {
					System.out.println("Check admin: " + "check in...");
					HttpSession session = request.getSession();
					session.setAttribute("admin", check);
					session.setAttribute("NoteRegister", "adminLogin...");
					
					response.sendRedirect("Demo18/adminPage.jsp");
					//request.getRequestDispatcher("adminPage.jsp").forward(request, response);
				}else {
					System.out.println("Check admin: " + "can not check in...");
					request.setAttribute("Note", "登陆失败，请检查密码！");
					request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
				}
			}
			
			
		}else {
			System.out.println("Check admin: " + "dynamic key word is wrong...");
			request.setAttribute("Note", "动态密钥错误，请检查或联系管理人员！");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
