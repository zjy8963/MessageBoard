package org.messageboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.entity.MessagePlus;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;
import org.sql.EntityUtil;

@WebServlet("/messageListServlet")
public class messageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		
		List<MessagePlus> messages = messageBoardService.QueryAllMessages();
		
		String listTable = EntityUtil.getListTable(messages);
		
		if(listTable.equals("empty...")) {
			System.out.println("Query all messages: " + listTable);
		}else {
			System.out.println("Query all messages: success...");
			request.setAttribute("listTable", listTable);
			request.getRequestDispatcher("messageList.jsp").forward(request, response);
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
