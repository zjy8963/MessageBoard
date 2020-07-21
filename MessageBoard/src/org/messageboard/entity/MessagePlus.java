package org.messageboard.entity;

public class MessagePlus {
	private int id;
	private String userKey;
	private String userName;
	private String title;
	private String content;
	private String mTime;
	
	
	public MessagePlus() {
		super();
	}
	
	
	
	public MessagePlus(int id, String userKey, String title, String content, String mTime) {
		super();
		this.id = id;
		this.userKey = userKey;
		this.title = title;
		this.content = content;
		this.mTime = mTime;
	}

	public MessagePlus(int id, String userKey, String userName, String title, String content, String mTime) {
		super();
		this.id = id;
		this.userKey = userKey;
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.mTime = mTime;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((mTime == null) ? 0 : mTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userKey == null) ? 0 : userKey.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessagePlus other = (MessagePlus) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (mTime == null) {
			if (other.mTime != null)
				return false;
		} else if (!mTime.equals(other.mTime))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userKey == null) {
			if (other.userKey != null)
				return false;
		} else if (!userKey.equals(other.userKey))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MessagePlus [id=" + id + ", userKey=" + userKey + ", userName=" + userName + ", title=" + title
				+ ", content=" + content + ", mTime=" + mTime + "]";
	}
	
	
	
	

	
}
