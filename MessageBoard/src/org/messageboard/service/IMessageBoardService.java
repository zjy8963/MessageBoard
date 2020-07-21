package org.messageboard.service;

import java.util.List;

import org.messageboard.entity.Admin;
import org.messageboard.entity.Comment;
import org.messageboard.entity.CommentPlus;
import org.messageboard.entity.Message;
import org.messageboard.entity.MessagePlus;
import org.messageboard.entity.User;

public interface IMessageBoardService {
	
	public String AddUser(User user);
	
	public List<User> QueryAllUsers();
	
	public String checkUser(User user);
	
	public User QueryUser(String phoneNumber);
	
	public String UpdateUser(User user);
	
	public String DeleteUser(String phoneNumber);
	
	
	public String AddMessage(Message message);
	
	public List<MessagePlus> QueryAllMessages();
	
	public Message QueryMessage(int id);
	
	public String DeleteMessage(int id);
	
	public String UpdateMessage(int id, Message message);
	
	public List<MessagePlus> QueryUserMessages(String phoneNumber);
	
	
	public String AddAdmin(Admin admin);
	
	public Admin QueryAdmin(String id);
	
	
	public String AddComment(Comment comment);
	
	public List<CommentPlus> QueryComments(int mID);
	
	public String DeleteComment(Comment comment);
	
}
