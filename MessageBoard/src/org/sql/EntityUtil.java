package org.sql;

import java.util.List;

import org.messageboard.entity.CommentPlus;
import org.messageboard.entity.MessagePlus;
import org.messageboard.entity.User;

public class EntityUtil {
	
	
	public static String getListTable(List<MessagePlus> list) {
		if(list.isEmpty()) {
			return "empty...";
		}
		
		StringBuilder listTable = new StringBuilder();
		listTable.append("<table id='rounded-corner' class='table'>");
		listTable.append(""
				+ "<thead>"
				+ "<tr>\r\n" + 
				"			<th scope='col' class='rounded-company'>序号</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>作者ID</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>作者</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>标题</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>内容</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>时间</th>\r\n" +
				"			<th scope='col' class='rounded-q4' colspan='3'>选择操作</th>\r\n" +
				"		  </tr>"
				+ "</thead>");
		
		listTable.append("<tfoot>\r\n" + 
				"			<tr>\r\n" + 
				"				<td colspan='6' class='rounded-foot-left'><em>Hello world!分页还未实现</em></td>\r\n" + 
				"				<td class='rounded-foot-right'></td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tfoot>");
		
		int count = 0;
		for(MessagePlus messagePlus : list) {
			listTable.append(""
					+ "<tbody>"
					+ "<tr>");
			listTable.append("<td>"+(++count)+"</td>");
			listTable.append("<td>"+messagePlus.getUserKey()+"</td>");
			listTable.append("<td>"+messagePlus.getUserName()+"</td>");
			listTable.append("<td>"+messagePlus.getTitle()+"</td>");
			listTable.append("<td>"+messagePlus.getContent()+"</td>");
			listTable.append("<td>"+messagePlus.getmTime()+"</td>");
			listTable.append("<td colspan='3'>"+""
					+ "<a href='messageDetailsServlet?mID="+messagePlus.getId()+"&uName="+messagePlus.getUserName()+"&manage=false'>查看</a> "
					+ "<a href='#'>评论</a> "
					+ "<a href='#'>举报</a> "
					+ "</td>");
			/*
			 * 麻烦做法
			 * + "<form method='post' action='oprationServlet' >"
					+ "<input type='hidden' name='mID' value='"+messagePlus.getId()+"'>"
					+ "<input type='submit' name='operation' value='查看'><br/>"
					+ "<input type='submit' name='operation' value='评论'><br/>"
					+ "<input type='submit' name='operation' value='举报'><br/>"
					+ "</form>"+""
			 * 
			 * 
			 * */
			listTable.append("</tr>"
					+ "</tbody>");
		}
		listTable.append("</table>");
		
		return listTable.toString();
	}
	
	
	
	
	public static String manageListTable(List<MessagePlus> list) {
		if(list.isEmpty()) {
			return "empty...";
		}
		
		StringBuilder listTable = new StringBuilder();
		listTable.append("<table id='rounded-corner' class='table'>");
		listTable.append(""
				+ "<thead>"
				+ "<tr>\r\n" + 
				"			<th scope='col' class='rounded-company'>序号</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>作者ID</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>作者</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>标题</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>内容</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>时间</th>\r\n" +
				"			<th scope='col' class='rounded-q4' colspan='2'>选择操作</th>\r\n" +
				"		  </tr>"
				+ "</thead>");
		
		listTable.append("<tfoot>\r\n" + 
				"			<tr>\r\n" + 
				"				<td colspan='6' class='rounded-foot-left'><em>Hello world!分页还未实现</em></td>\r\n" + 
				"				<td class='rounded-foot-right'></td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tfoot>");
		
		int count = 0;
		for(MessagePlus messagePlus : list) {
			listTable.append(""
					+ "<tbody>"
					+ "<tr>");
			listTable.append("<td>"+(++count)+"</td>");
			listTable.append("<td>"+messagePlus.getUserKey()+"</td>");
			listTable.append("<td>"+messagePlus.getUserName()+"</td>");
			listTable.append("<td>"+messagePlus.getTitle()+"</td>");
			listTable.append("<td>"+messagePlus.getContent()+"</td>");
			listTable.append("<td>"+messagePlus.getmTime()+"</td>");
			listTable.append("<td colspan='2'>"+""
					+ "<a href='messageDetailsServlet?mID="+messagePlus.getId()+"&uName="+messagePlus.getUserName()+"&manage=true'>查看</a> "
					+ "<a href='messageDeleteServlet?mID="+messagePlus.getId()+"'>删除</a> "
					+ "</td>");
			listTable.append("</tr>"
					+ "</tbody>");
		}
		listTable.append("</table>");
		
		return listTable.toString();
	}
	
	
	public static String manageUserTable(List<User> users) {
		//此处可以考虑修改：即做空表而不是仅返回一个空值。
		if(users.isEmpty()) {
			return "empty...";
		}
		
		StringBuilder userTable = new StringBuilder();
		userTable.append("<table id='rounded-corner' class='table'>");
		userTable.append(""
				+ "<thead>"
				+ "<tr>\r\n" + 
				"			<th scope='col' class='rounded-company'>用户ID</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>姓名</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>年龄</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>性别</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>邮箱</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>身份ID</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>用户状态</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>密码</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>创建时间</th>\r\n" +
				"			<th scope='col' class='rounded-q4' colspan='2'>选择操作</th>\r\n" +
				"		  </tr>"
				+ "</thead>");
		
		userTable.append("<tfoot>\r\n" + 
				"			<tr>\r\n" + 
				"				<td colspan='9' class='rounded-foot-left'><em>Hello world!分页还未实现</em></td>\r\n" + 
				"				<td class='rounded-foot-right'></td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tfoot>");
		
		
		for(User user : users) {
			userTable.append(""
					+ "<tbody>"
					+ "<tr>");
			userTable.append("<td>"+user.getPhoneNumber()+"</td>");
			userTable.append("<td>"+user.getUserName()+"</td>");
			userTable.append("<td>"+user.getAge()+"</td>");
			userTable.append("<td>"+user.getGender()+"</td>");
			userTable.append("<td>"+user.getEmail()+"</td>");
			userTable.append("<td>"+user.getID()+"</td>");
			userTable.append("<td>"+user.getUserStatus()+"</td>");
			userTable.append("<td>"+user.getPwd()+"</td>");
			userTable.append("<td>"+user.getcTime()+"</td>");
			userTable.append("<td colspan='2'>"+""
					+ "<a href='userDetailsServlet?phoneNumber="+user.getPhoneNumber()+"'>修改信息</a> "
					+ "<a href='userDeleteServlet?phoneNumber="+user.getPhoneNumber()+"'>删除</a> "
					+ "</td>");
			userTable.append("</tr>"
					+ "</tbody>");
		}
		userTable.append("</table>");
		
		return userTable.toString();
	}
	
	
	public static String getUserMessagesTable(List<MessagePlus> list) {
		StringBuilder listTable = new StringBuilder();
		listTable.append("<table id='rounded-corner' class='table'>");
		listTable.append(""
				+ "<thead>"
				+ "<tr>\r\n" + 
				"			<th scope='col' class='rounded-company'>序号</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>标题</th>\r\n" + 
				"			<th scope='col' class='rounded-q1'>内容</th>\r\n" +
				"			<th scope='col' class='rounded-q1'>发表时间</th>\r\n" +
				"			<th scope='col' class='rounded-q4' colspan='3'>选择操作</th>\r\n" +
				"		  </tr>"
				+ "</thead>");
		
		if(list.isEmpty()) {
			listTable.append("<tfoot>\r\n" + 
					"			<tr>\r\n" + 
					"				<td colspan='4' class='rounded-foot-left'><em>列表为空！</em></td>\r\n" + 
					"				<td class='rounded-foot-right'></td>\r\n" + 
					"			</tr>\r\n" + 
					"		</tfoot>");
			listTable.append("</table>");
			return listTable.toString();
		}else {
			listTable.append("<tfoot>\r\n" + 
					"			<tr>\r\n" + 
					"				<td colspan='4' class='rounded-foot-left'><em>Hello world!分页还未实现</em></td>\r\n" + 
					"				<td class='rounded-foot-right'></td>\r\n" + 
					"			</tr>\r\n" + 
					"		</tfoot>");
		}
		
		int count = 0;
		for(MessagePlus messagePlus : list) {
			listTable.append(""
					+ "<tbody>"
					+ "<tr>");
			listTable.append("<td>"+(++count)+"</td>");
			listTable.append("<td>"+messagePlus.getTitle()+"</td>");
			listTable.append("<td>"+messagePlus.getContent()+"</td>");
			listTable.append("<td>"+messagePlus.getmTime()+"</td>");
			listTable.append("<td colspan='3'>"+""
					+ "<a href='messageDetailsServlet?mID="+messagePlus.getId()+"&uName="+messagePlus.getUserName()+"&manage=false'>查看</a> "
					+ "<a href='userDeleteMessageServlet?mID="+messagePlus.getId()+"'>删除</a> "//messageDeleteServlet?mID="+messagePlus.getId()+"
					+ "<a href='userModifyMessageServlet?mID="+messagePlus.getId()+"&uName="+messagePlus.getUserName()+"'>修改</a> "
					+ "</td>");
			
			listTable.append("</tr>"
					+ "</tbody>");
		}
		listTable.append("</table>");
		
		return listTable.toString();
	}
	
	
	public static String getCommentList(List<CommentPlus> list) {
		//判断为空否，为null否,为null时是异常情况
		if(list == null) {
			return "exception...";
		}else if(list.isEmpty()){
			return ""
					+ "<form role=\"form\" action=\"AddCommentServlet\" method=\"post\" class=\"registration-form\"\r\n" + 
					"					name=\"my_form\" >"+
					"			<div class='form-group' style='margin: 60px; opacity:1; border:3px solid'>\r\n" + 
					"				<div class='form-group'>\r\n" + 
					"					<textarea name='content' class='form-about-yourself form-control' \r\n" + 
					"					 placeholder=\"暂无评论~\" readonly></textarea>\r\n" + 
					"				</div>\r\n" + 
					"			</div>"
					+ "</form>";
		}else {
			StringBuilder listTable = new StringBuilder();
			for(CommentPlus comment : list) {
				listTable.append(""
						+ "<form role=\"form\" action=\"AddCommentServlet\" method=\"post\" class=\"registration-form\"\r\n" + 
						"					name=\"my_form\" >" + 
						"			<div class='form-group' style='margin: 60px; opacity:1; border:3px solid'>\r\n" + 
						"				<p style='text-align:left;'>\r\n" + 
						"					<font color='black'>评论人: "+comment.getUserName()+"</font>\r\n" +
						"<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>"+
						"					<font color='black'>ID: "+comment.getuID()+"</font>\r\n<br/>" + 
						"					<font color='black'>评论日期: "+comment.getcTime()+"</font>\r\n" +
						"<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>"+
						"					<a href='deleteCommentServlet?uID="+comment.getuID()+"&mID="+comment.getmID()+"&cTime="+comment.getcTime()+"&uName="+comment.getUserName()+"'>删除</a>\r\n" + 
						"				</p>\r\n" + 
						"				<div class='form-group'>\r\n" + 
						"					<textarea name='content' class='form-about-yourself form-control' readonly>"+comment.getContent()+"</textarea>\r\n" + 
						"				</div>\r\n" + 
						"			</div>\r\n" + 
						"			\r\n" + 
						"		"
						+ "</form>"
						+ "");
			}
			return listTable.toString();
		}
		
	}
	
	
}
