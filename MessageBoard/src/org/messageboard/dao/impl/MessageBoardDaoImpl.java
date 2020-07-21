package org.messageboard.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.messageboard.dao.IMessageBoardDao;
import org.messageboard.entity.Admin;
import org.messageboard.entity.Comment;
import org.messageboard.entity.CommentPlus;
import org.messageboard.entity.Message;
import org.messageboard.entity.MessagePlus;
import org.messageboard.entity.User;
import org.sql.DBUtil;

public class MessageBoardDaoImpl implements IMessageBoardDao{

	public List<User> QueryAllUsers() {
		List<User> users = new ArrayList<User>();
		SimpleDateFormat ft = new SimpleDateFormat();
		User user = null;
		ResultSet rs = null;
		String sql = "select * from user";
		try {
			rs = DBUtil.executeQuery(sql, null);
			while(rs.next()) {
				String phoneNumber = rs.getString("phone_number");
				String userName = rs.getString("userName");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String Email = rs.getString("Email");
				String ID = rs.getString("ID");
				String userStatus = rs.getString("userstatus");
				String pwd = rs.getString("pwd");
				Timestamp dt = rs.getTimestamp("ctime");
				String cTime = ft.format(dt);
				
				user = new User(phoneNumber, userName, age, gender, Email, ID, userStatus, pwd, cTime);
				users.add(user);
			}
			return users;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
		
	}

	
	
	public User QueryUser(String phoneNumber) {
		User user = null;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		String sql = "select * from user where phone_number=?";
		Object[] params = {phoneNumber};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			
			if(rs.next()) {
				String userName = rs.getString("userName");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String Email = rs.getString("Email");
				String ID = rs.getString("ID");
				String userStatus = rs.getString("userstatus");
				String pwd = rs.getString("pwd");
				Timestamp dt = rs.getTimestamp("ctime");
				String cTime = ft.format(dt);
				
				user = new User(phoneNumber, userName, age, gender, Email, ID, userStatus, pwd, cTime);
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
	}
	
	
	
	
	public boolean IsExist(String phoneNumber) {
		return QueryUser(phoneNumber) == null ? false : true;
	}
	
	@Override
	public int AddUser(User user) {
		String sql = "insert into user values(?, ?, ?, ?, ?, ?, 'normal', ?, ?)";
		Object[] params = {user.getPhoneNumber(), 
				user.getUserName(), user.getAge(),
				user.getGender(), user.getEmail(), user.getID(), user.getPwd(), user.getcTime()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public int DeleteUser(String phoneNumber) {
		String sql = "delete from user where phone_number=?";
		Object[] params = {phoneNumber};
 		return DBUtil.executeUpdate(sql, params);
	}


	@Override
	public int UpdateUser(User user) {
		String sql = "update user set age=?, Email=?, ID=?, userstatus=? where phone_number=?";
		Object[] params= {user.getAge(), user.getEmail(), user.getID(), user.getUserStatus(), user.getPhoneNumber()};
		
		return DBUtil.executeUpdate(sql, params);
		
	}

	@Override
	public List<MessagePlus> QueryAllMessages() {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		List<MessagePlus> messages = new ArrayList<MessagePlus>();
		MessagePlus messagePlus = null;
		
		String sql = "select usermessages.id, userkey, userName, title, content, mtime from usermessages join user on(usermessages.userkey = user.phone_number) order by usermessages.id";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("usermessages.id");
				String userKey = rs.getString("userkey");
				String userName = rs.getString("userName");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp dt = rs.getTimestamp("mtime");
				String mTime = ft.format(dt);
				
				messagePlus = new MessagePlus(id, userKey, userName, title, content, mTime);
				messages.add(messagePlus);
			}
			return messages;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
		
	}


	@Override
	public int DeleteAllMessages(String phoneNumber) {
		String sql = "delete from usermessages where userkey=?";
		Object[] params = {phoneNumber};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public Message QueryMessage(int id) {
		Message message = null;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss"); 
		String sql = "select * from usermessages where id=?";
		Object[] params = {id};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String userKey = rs.getString("userkey");
				Timestamp dt = rs.getTimestamp("mtime");
				String mTime = ft.format(dt);
				
				message = new Message(title, content, userKey, mTime);
			}
			
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
		
	}

	@Override
	public int AddMessage(Message message) {
		
		String sql = "insert into usermessages(title, content, userkey, mtime) "
				   + "values(?, ?, ?, ?);";
		Object[] params = {message.getTitle(), message.getContent(), message.getUserKey(), message.getmTime()};
		return DBUtil.executeUpdate(sql, params);
		
	}

	@Override
	public int DeleteMessage(int id) {
		String sql = "delete from usermessages where id=?";
		Object[] params = {id};
		int res = DBUtil.executeUpdate(sql, params);
		
		if(res > 0) {
			return 1;
		}else if(res == 0) {
			return 0;
		}else {
			return -1;
		}
		
	}
	
	@Override
	public List<MessagePlus> QueryUserMessages(String phoneNumber) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		List<MessagePlus> messages = new ArrayList<MessagePlus>();
		MessagePlus messagePlus = null;
		
		String sql = "select usermessages.id, userkey, userName, title, content, mtime from usermessages join user on(usermessages.userkey = user.phone_number) where usermessages.userkey=? order by usermessages.mTime";
		Object[] params = {phoneNumber};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("usermessages.id");
				String userKey = rs.getString("userkey");
				String userName = rs.getString("userName");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp dt = rs.getTimestamp("mtime");
				String mTime = ft.format(dt);
				
				messagePlus = new MessagePlus(id, userKey, userName, title, content, mTime);
				messages.add(messagePlus);
			}
			return messages;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
	}
	
	
	//调整id顺序
	//alter table usermessages drop column id;
	//alter table usermessages add id int not null primary key auto_increment first;
	@Override
	public boolean ExchangeMessagesOrder() {
		String sql1 = "alter table usermessages drop column id";
		String sql2 = "alter table usermessages add id int not null primary key auto_increment first";
		Object[] params = null;
		int res1 = DBUtil.executeUpdate(sql1, params);
		
		if(res1 > 0) {
			int res2 = DBUtil.executeUpdate(sql2, params);	//结果是零行受影响！
			if(res2 == 0) {
				return true;
			}
		}
		
		return false;
	}


	@Override
	public boolean IsExistMessage(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int UpdateMessage(int id, Message message) {
		String sql = "update usermessages set title=?, content=?, mtime=? where id=?";
		Object[] params= {message.getTitle(), message.getContent(), message.getmTime(), id};
		
		return DBUtil.executeUpdate(sql, params);
	}


	@Override
	public int AddAdmin(Admin admin) {
		String sql = "insert into admins(id, pwd, cTime) values(?, ?, ?)";
		Object[] params = {admin.getId(), admin.getPwd(), admin.getcTime()};
		
		return DBUtil.executeUpdate(sql, params);
	}



	@Override
	public Admin QueryAdmin(String aID) {
		Admin admin = null;
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		String sql = "select * from admins where id = ?";
		Object[] params = {aID};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		try {
			if(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String adminType = rs.getString("admintype");
				Timestamp dt = rs.getTimestamp("ctime");
				String cTime = ft.format(dt);
				
				admin = new Admin(id, pwd, adminType, cTime);
			}
			
			return admin;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
		
	}

	@Override
	public boolean IsExistAdmin(String id) {
		return QueryAdmin(id) == null ? false : true;
	}



	
	@Override
	public int AddComment(Comment comment) {
		String sql = "insert into comment values(?, ?, ?, ?)";
		Object[] params = {comment.getuID(), comment.getmID(), comment.getContent(), comment.getcTime()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public List<CommentPlus> QueryComments(int mID) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		List<CommentPlus> comments = new ArrayList<CommentPlus>();
		CommentPlus commentPlus = null;
		
		String sql = "select user.userName, comment.u_ID, comment.m_ID, comment.content, comment.cTime from comment join user on(comment.u_ID=user.phone_number) where comment.m_ID=? order by comment.cTime desc";
		Object[] params = {mID};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		try {
			while(rs.next()) {
				String uID = rs.getString("comment.u_ID");
				String userName = rs.getString("user.userName");
				String content = rs.getString("comment.content");
				Timestamp dt = rs.getTimestamp("comment.cTime");
				String cTime = ft.format(dt);
				
				commentPlus = new CommentPlus(uID, userName, mID, content, cTime);
				comments.add(commentPlus);
			}
			
			return comments;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs);
		}
		
	}

	@Override
	public int DeleteComments(String uID) {
		String sql = "delete from comment where u_ID=?";
		Object[] params = {uID};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public int DeleteMessageComments(int mID) {
		String sql = "delete from comment where m_ID=?";
		Object[] params = {mID};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public int DeleteComment(Comment comment) {
		String sql = "delete from comment where u_ID=? and m_ID=? and cTime=?";
		Object[] params = {comment.getuID(), comment.getmID(), comment.getcTime()};
		return DBUtil.executeUpdate(sql, params);
	}



}
