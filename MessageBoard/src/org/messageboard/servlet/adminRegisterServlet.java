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

import org.messageboard.entity.Admin;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/adminRegisterServlet")
public class adminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String key = "freedom";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		
		//后台单独做检验,默认为：'freedom'
		String keyWord = request.getParameter("keyWord");
		
		
		if(keyWord.equals(key)) {

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String cTime = ft.format(dNow);
			
			Admin admin = new Admin(id, pwd, cTime);
			
			IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
			
			String res = messageBoardService.AddAdmin(admin);
			
			System.out.println("add admin :" + res);
			
			if(res.equals("success...")) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				session.setAttribute("NoteRegister", "adminRegisterSuccess...");
				
				response.sendRedirect("Demo18/adminPage.jsp");
				//转发不能正常显示!
				//request.getRequestDispatcher("Demo18/adminPage.jsp").forward(request, response);
				
			}else if(res.equals("Duplicate tuples...")) {
				request.setAttribute("Note", "该ID已注册，请不要重复注册！");
				request.getRequestDispatcher("adminRegister.jsp").forward(request, response);
			}else  {
				request.setAttribute("Note", "注册失败，详情请咨询管理人员！");
				request.getRequestDispatcher("adminRegister.jsp").forward(request, response);
			}
		}else {
			System.out.println("Key word is not right...");
			request.setAttribute("Note", "密钥错误，请重新输入！");
			request.getRequestDispatcher("adminRegister.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
