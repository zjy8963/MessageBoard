package org.messageboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.entity.CommentPlus;
import org.messageboard.entity.Message;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;
import org.sql.EntityUtil;

@WebServlet("/messageDetailsServlet")
public class messageDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String note = null;
		Object obj = request.getAttribute("Note");
		
		String userName = request.getParameter("uName");
		String messageID = request.getParameter("mID");
		String manage = request.getParameter("manage");
		
		if(userName == null) {
			userName = (String) request.getAttribute("uName");
		}
		if(messageID == null) {
			messageID = (String) request.getAttribute("mID");
		}
		if(manage == null) {
			manage = (String) request.getAttribute("manage");
		}
		
		int id = Integer.parseInt(messageID);
		
		IMessageBoardService messageService = new MessageBoardServiceImpl();
		Message message = messageService.QueryMessage(id);
		
		List<CommentPlus> comments = messageService.QueryComments(id);
		String commentList = EntityUtil.getCommentList(comments);
		
		if(message == null) {
			System.out.println("Query message :" + "fail or exception...");
		}else {
			
			System.out.println("Query message :" + "success...");
			if(obj != null) {
				note = (String)obj;
				request.setAttribute("Note", note);
			}
			
			request.setAttribute("manage", manage);
			
			request.setAttribute("comments", commentList);
			
			request.setAttribute("messageID", id);
			request.setAttribute("message", message);
			request.setAttribute("uName", userName);
			if(manage.equals("true")) {
				request.getRequestDispatcher("manageMessageDetails.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("messageDetails.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
