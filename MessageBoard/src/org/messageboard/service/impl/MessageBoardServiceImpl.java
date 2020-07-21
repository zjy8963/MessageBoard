package org.messageboard.service.impl;

import java.util.List;

import org.messageboard.dao.IMessageBoardDao;
import org.messageboard.dao.impl.MessageBoardDaoImpl;
import org.messageboard.entity.Admin;
import org.messageboard.entity.Comment;
import org.messageboard.entity.CommentPlus;
import org.messageboard.entity.Message;
import org.messageboard.entity.MessagePlus;
import org.messageboard.entity.User;
import org.messageboard.service.IMessageBoardService;

public class MessageBoardServiceImpl implements IMessageBoardService{
	
	IMessageBoardDao messageBoardDao = new MessageBoardDaoImpl();
	
	@Override
	public String AddUser(User user) {
		if(messageBoardDao.IsExist(user.getPhoneNumber())) {
			return "Duplicate tuples...";
		}
		
		int res = messageBoardDao.AddUser(user);
		if(res > 0) {
			return "success..."; 
		}else if(res == 0){
			return "fail...";
		}else {
			return "exception...";
		}
		
	}

	@Override
	public List<User> QueryAllUsers() {
		List<User> res = messageBoardDao.QueryAllUsers();
		return res;
	}

	@Override
	public String checkUser(User user) {
		User check = messageBoardDao.QueryUser(user.getPhoneNumber());
		if(check==null) {
			return "have not register...";
		}
		
		if(user.getPwd().equals(check.getPwd())) {
			return "check in...";
		}else {
			return "can not check in...";
		}
	}

	@Override
	public User QueryUser(String phoneNumber) {
		return messageBoardDao.QueryUser(phoneNumber);
	}
	
	@Override
	public String UpdateUser(User user) {
		int res = messageBoardDao.UpdateUser(user);
		if(res > 0) {
			return "success...";
		}else {
			return "fail_or_exception...";
		}
	}
	
	@Override
	public String DeleteUser(String phoneNumber) {
		List<MessagePlus> userMessages = messageBoardDao.QueryUserMessages(phoneNumber);
		for(MessagePlus message : userMessages) {
			messageBoardDao.DeleteMessageComments(message.getId());
		}
		messageBoardDao.DeleteAllMessages(phoneNumber);
		messageBoardDao.DeleteComments(phoneNumber);
//		messageBoardDao.ExchangeMessagesOrder();
		int res = messageBoardDao.DeleteUser(phoneNumber);
		if(res > 0) {
			return "success...";
		}else {
			return "fail_or_exception...";
		}
	}

	
	
	
	
	@Override
	public String AddMessage(Message message) {
		//留言可以直接增加， 不用先查后加。
		int res = messageBoardDao.AddMessage(message);
		if(res > 0) {
			return "success...";
		}else if(res == 0) {
			return "fail...";
		}else {
			return "exception...";
		}
	}

	@Override
	public List<MessagePlus> QueryAllMessages() {
		return messageBoardDao.QueryAllMessages();
	}

	@Override
	public Message QueryMessage(int id) {
		return messageBoardDao.QueryMessage(id);
	}
	
	@Override
	public String UpdateMessage(int id, Message message) {
		int res = messageBoardDao.UpdateMessage(id, message);
		if(res > 0) {
			return "success...";
		}else {
			return "fail or exception...";
		}
	}
	
	@Override
	public List<MessagePlus> QueryUserMessages(String phoneNumber) {
		return messageBoardDao.QueryUserMessages(phoneNumber);
	}
	
	
	@Override
	public String AddAdmin(Admin admin) {
		if(messageBoardDao.IsExistAdmin(admin.getId())) {
			return "Duplicate tuples...";
		}
		
		int res = messageBoardDao.AddAdmin(admin);
		
		if(res > 0) {
			return "success...";
		}else if(res == 0){
			return "fail...";
		}else {
			return "exception...";
		}
		
	}

	
	
	@Override
	public Admin QueryAdmin(String id) {
		return messageBoardDao.QueryAdmin(id);
	}

	@Override
	public String DeleteMessage(int  id) {
		messageBoardDao.DeleteMessageComments(id);
		int resDelete = messageBoardDao.DeleteMessage(id);
		if(resDelete == 1) {
//			boolean resExchange = messageBoardDao.ExchangeMessagesOrder();
//			if(resExchange == true) {
			return "success...";
//			}else {
//				return "delete success exchange fail...";
//			}
		}else if(resDelete == 0) {
			return "delete fail...";
		}else {
			return "exception...";
		}
		
	}
	
	
	
	
	@Override
	public String AddComment(Comment comment) {
		int res = messageBoardDao.AddComment(comment);
		if(res > 0) {
			return "success...";
		}else {
			return "fail...";
		}
	}

	@Override
	public List<CommentPlus> QueryComments(int mID) {
		return messageBoardDao.QueryComments(mID);
	}
	
	@Override
	public String DeleteComment(Comment comment) {
		int res = messageBoardDao.DeleteComment(comment);
		if(res == 1) {
			return "success...";
		}else {
			return "failed or exception...";
		}
	}
	
}
