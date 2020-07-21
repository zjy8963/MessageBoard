package org.messageboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;
import org.sql.EntityUtil;

@WebServlet("/userManagementServlet")
public class userManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		
		String note = (String) request.getAttribute("Note"); //删除用户时,用于提示
		
		List<User> users = messageBoardService.QueryAllUsers();
		
		String userTable = EntityUtil.manageUserTable(users);
		
		if(userTable.equals("empty...")) {
			System.out.println("Query all users: " + userTable);
		}else {
			System.out.println("Query all users: success...");
			request.setAttribute("userTable", userTable);
			request.setAttribute("Note", note);
			request.getRequestDispatcher("manageUserList.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
