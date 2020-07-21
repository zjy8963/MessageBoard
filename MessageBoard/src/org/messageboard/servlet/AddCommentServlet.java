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

import org.messageboard.entity.Comment;
import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		
		
		
		if(obj != null) {
			
			Comment comment = null;
			IMessageBoardService messageService = new MessageBoardServiceImpl();
			
			request.setAttribute("message", request.getParameter("message"));
			request.setAttribute("uName", request.getParameter("uName"));
			request.setAttribute("mID", request.getParameter("mID"));
			request.setAttribute("manage", request.getParameter("manage"));
			
			User user = (User)obj;
			String uID = user.getPhoneNumber();
			int mID = Integer.parseInt(request.getParameter("mID"));
			String content = request.getParameter("comment");
			String cTime = ft.format(dNow);
			
			comment = new Comment(uID, mID, content, cTime);
			
			String res = messageService.AddComment(comment);
			
			System.out.println("add comment: " + res);
			
			if(res.equals("success...")) {
				request.setAttribute("Note", "评论成功！");
				request.getRequestDispatcher("messageDetailsServlet").forward(request, response);
				
				
			}else {
				request.setAttribute("Note", "评论失败！");
				request.getRequestDispatcher("messageDetailsServlet").forward(request, response);
			}
			
		}else {
			System.out.println("user has not login...");
			response.sendRedirect("Demo18/index.jsp");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
