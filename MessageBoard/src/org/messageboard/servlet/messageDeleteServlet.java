package org.messageboard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/messageDeleteServlet")
public class messageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String str = request.getParameter("mID");
		int id = Integer.parseInt(str);
		
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		
		String resDelete = messageBoardService.DeleteMessage(id);
		
		System.out.println("delete message :" + resDelete);
		
		if(resDelete.equals("success...")) {
			request.setAttribute("Note", "success...");	//这样的需要getAttribute才能拿到
			request.getRequestDispatcher("messageManagementServlet").forward(request, response);
		}else if(resDelete.equals("delete fail...")) {
			request.setAttribute("Note", resDelete);
			request.getRequestDispatcher("messageManagementServlet").forward(request, response);
		}else {
			request.setAttribute("Note", resDelete);
			request.getRequestDispatcher("messageManagementServlet").forward(request, response);
		}
		/*
		 * 不再调整顺序
		 * else if(resDelete.equals("delete success exchange fail...")) {
			//该种错误很少会出，换表头时，第二条语句查询结果为0
			request.setAttribute("Note", resDelete);
			request.getRequestDispatcher("messageManagementServlet").forward(request, response);
		}
		 */
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
