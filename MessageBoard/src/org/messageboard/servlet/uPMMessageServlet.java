package org.messageboard.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.messageboard.entity.Message;
import org.messageboard.service.IMessageBoardService;
import org.messageboard.service.impl.MessageBoardServiceImpl;

@WebServlet("/uPMMessageServlet")
public class uPMMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		IMessageBoardService messageBoardService = new MessageBoardServiceImpl();
		Message message = null;
		
		String uName = request.getParameter("uName");
		String str = request.getParameter("mID");
		int mID = Integer.parseInt(str);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String mTime = ft.format(dNow);
		
		message = new Message(title, content, mTime);
		
		String res = messageBoardService.UpdateMessage(mID, message);
		
		System.out.println("update message :" + res);
		
		if(res.equals("success...")) {
			request.setAttribute("Note", "修改成功！");
			request.getRequestDispatcher("userModifyMessageServlet?mID="+mID+"&uName="+uName+"").forward(request, response);
		}else {
			request.setAttribute("Note", "修改失败，详情请咨询管理人员！");
			request.getRequestDispatcher("userModifyMessageServlet?mID="+mID+"&uName="+uName+"").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
