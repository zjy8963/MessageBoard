package org.messageboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/userDeleteMessageServlet")
public class userDeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		String str = request.getParameter("mID");
		int mID = Integer.parseInt(str);
		
		String res = messageBoardService.DeleteMessage(mID);
		
		System.out.println("user delete message :" + res);
		
		if(res.equals("success...")) {
			request.setAttribute("NoteDelete", "success...");
			request.getRequestDispatcher("myMessageListServlet").forward(request, response);
		}else {
			request.setAttribute("NoteDelete", "failed...");
			request.getRequestDispatcher("myMessageListServlet").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
