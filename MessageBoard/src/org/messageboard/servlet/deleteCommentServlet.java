package org.messageboard.servlet;

import java.io.IOException;
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

@WebServlet("/deleteCommentServlet")
public class deleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		
		String uID = request.getParameter("uID");
		String str = request.getParameter("mID");
		int mID = Integer.parseInt(str);
		String cTime = request.getParameter("cTime");
		String uName = request.getParameter("uName");
		
		Comment comment = new Comment(uID, mID, cTime);
		
		if(obj != null) {
			
			User user = (User)obj;
			
			if(user.getPhoneNumber().equals(uID)) {
				String res = messageBoardService.DeleteComment(comment);
				System.out.println(user.getPhoneNumber()+" "+user.getUserName() + " delete comment : " + res);
				
				if(res.equals("success...")) {
					request.setAttribute("mID", mID);
					request.setAttribute("uName", uName);
					request.setAttribute("manage", "false");
					request.setAttribute("Note", "删除成功！");
					request.getRequestDispatcher("messageDetailsServlet").forward(request, response);
				}else {
					request.setAttribute("mID", mID);
					request.setAttribute("uName", uName);
					request.setAttribute("manage", "false");
					request.setAttribute("Note", "删除失败，详情请咨询管理人员！");
					request.getRequestDispatcher("messageDetailsServlet").forward(request, response);
				}
			}else {
				System.out.println(user.getPhoneNumber() + " can not delete others comment...");
				request.setAttribute("mID", mID);
				request.setAttribute("uName", uName);
				request.setAttribute("manage", "false");
				request.setAttribute("Note", "删除失败，不可删除他人评论！");
				request.getRequestDispatcher("messageDetailsServlet").forward(request, response);
			}
			
		}else {
			System.out.println("user has not login...");
			session.setAttribute("NoteLogin", "notLogin...");
			response.sendRedirect("Demo18/index.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
