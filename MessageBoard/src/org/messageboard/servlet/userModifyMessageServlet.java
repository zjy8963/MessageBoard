package org.messageboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.entity.Message;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/userModifyMessageServlet")
public class userModifyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		
		Object obj = request.getAttribute("Note");
		String str = request.getParameter("mID");
		String uName = request.getParameter("uName");
		int mID = Integer.parseInt(str);
		
		Message message = messageBoardService.QueryMessage(mID);
		
		if(message != null) {
			if(obj != null) {
				String Note = (String)obj;
				request.setAttribute("Note", Note);
			}
			request.setAttribute("mID", mID);
			request.setAttribute("uName", uName);
			request.setAttribute("message", message);
			request.getRequestDispatcher("userModifyMessage.jsp").forward(request, response);
		}else {
			//查询不到，跳回 我的留言 页面
			response.sendRedirect("myMessageListServlet");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
