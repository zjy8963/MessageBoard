package org.messageboard.entity;

public class Message {
	//	private int id;//自增不用写
	private String title;
	private String content;
	private String userKey;
	private String mTime;
	
	
	public Message() {
		super();
	}


	public Message(String title, String content, String mTime) {
		super();
		this.title = title;
		this.content = content;
		this.mTime = mTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((mTime == null) ? 0 : mTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userKey == null) ? 0 : userKey.hashCode());
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
		Message other = (Message) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
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
		return true;
	}


	public Message(String title, String content, String userKey, String mTime) {
		super();
		this.title = title;
		this.content = content;
		this.userKey = userKey;
		this.mTime = mTime;
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
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}


	@Override
	public String toString() {
		return "Message [title=" + title + ", content=" + content + ", userKey=" + userKey + ", mTime=" + mTime + "]";
	}
	
	
	
	
	
	
	
}
