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

@WebServlet("/userModifyServlet")
public class userModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		User user = null;
		
		String phoneNum = request.getParameter("phone_number");
		String strAge = request.getParameter("age");
		String Email = request.getParameter("Email");
		String ID = request.getParameter("ID");
		String userStatus = request.getParameter("userStatus");
		
		String phoneNumber = phoneNum.substring(5);
		int age = Integer.parseInt(strAge.substring(3));
		String email = Email.substring(3);
		String iD = ID.substring(5);
		userStatus = userStatus.substring(5);
		
		user = new User(phoneNumber, age, email, iD, userStatus);
		
		String res = messageBoardService.UpdateUser(user);
		
		System.out.println("update user: "+res);
		
		if(res.equals("success...")) {
			request.setAttribute("Note", "修改成功！");
			request.setAttribute("phoneNumber", user.getPhoneNumber());
			
			request.getRequestDispatcher("userDetailsServlet").forward(request, response);
			
		}else {
			//该种情况一般不会出现，除非输入没有按照格式来输入
			request.setAttribute("Note", "修改失败，详情请咨询管理人员！");
			request.setAttribute("phoneNumber", user.getPhoneNumber());
			
			request.getRequestDispatcher("userDetailsServlet").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
