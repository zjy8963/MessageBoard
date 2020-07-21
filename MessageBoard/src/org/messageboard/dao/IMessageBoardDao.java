package org.messageboard.dao;

import java.util.List;

import org.messageboard.entity.Admin;
import org.messageboard.entity.Comment;
import org.messageboard.entity.CommentPlus;
import org.messageboard.entity.Message;
import org.messageboard.entity.MessagePlus;
import org.messageboard.entity.User;

public interface IMessageBoardDao {
	public List<User> QueryAllUsers();
	
	public User QueryUser(String phoneNumber);
	
	public int AddUser(User user);
	
	public int DeleteUser(String phoneNumber);
	
	public boolean IsExist(String phoneNumber); //for user
	
	public int UpdateUser(User user);
	
	
	public List<MessagePlus> QueryUserMessages(String phoneNumber);
	
	public List<MessagePlus> QueryAllMessages();
	
	public Message QueryMessage(int id);
	
	public int AddMessage(Message message);
	
	public int DeleteMessage(int id);
	
	public boolean IsExistMessage(int id);
	
	public boolean ExchangeMessagesOrder();
	
	public int UpdateMessage(int id, Message message);
	
	public int DeleteAllMessages(String phoneNumber);
	
	
	public int AddAdmin(Admin admin);
	
	public Admin QueryAdmin(String id);
	
	public boolean IsExistAdmin(String id);
	
	
	public int AddComment(Comment comment);
	
	public List<CommentPlus> QueryComments(int mID);
	
	public int DeleteMessageComments(int mID);
	
	public int DeleteComments(String uID);
	
	public int DeleteComment(Comment comment);
}
