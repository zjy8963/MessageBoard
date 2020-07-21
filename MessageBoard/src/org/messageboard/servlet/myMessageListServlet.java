package org.messageboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.messageboard.entity.MessagePlus;
import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;
import org.sql.EntityUtil;

@WebServlet("/myMessageListServlet")
public class myMessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Object obj_note = request.getAttribute("NoteDelte");
		
		HttpSession session = request.getSession();
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		
		Object obj = session.getAttribute("user");
		if(obj == null) {
			//跳转登录，其余页面可模仿，相当于非正常进入。
			session.setAttribute("NoteLogin", "haveNoteLogin...");
			
			response.sendRedirect("Demo18/index.jsp");
		}else {
			User user = (User)obj;
			List<MessagePlus> res = messageBoardService.QueryUserMessages(user.getPhoneNumber());
			if(res != null) {
				//提示
				if(obj_note != null) {
					String Note = (String) obj_note;
					request.setAttribute("NoteDelete", Note);
				}
				//做表时数据项为空，要做空表。
				System.out.println("query user messages :" + "success...");
				String userMessages = EntityUtil.getUserMessagesTable(res);
				request.setAttribute("Messages", userMessages);
				
				request.getRequestDispatcher("userMessages.jsp").forward(request, response);
			}else {	
				//为null是异常
				System.out.println("query user messages :" + "exception...");
				session.setAttribute("NoteFailed", "haveNoteLogin...");
				
				response.sendRedirect("Demo18/index.jsp");
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
