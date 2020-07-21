package org.messageboard.entity;

public class CommentPlus {
	private String uID;
	private String userName;
	private int mID;
	private String content;
	private String cTime;
	
	
	public CommentPlus() {
		super();
	}

	public CommentPlus(String uID, String userName, int mID, String content, String cTime) {
		super();
		this.uID = uID;
		this.userName = userName;
		this.mID = mID;
		this.content = content;
		this.cTime = cTime;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cTime == null) ? 0 : cTime.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + mID;
		result = prime * result + ((uID == null) ? 0 : uID.hashCode());
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
		CommentPlus other = (CommentPlus) obj;
		if (cTime == null) {
			if (other.cTime != null)
				return false;
		} else if (!cTime.equals(other.cTime))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (mID != other.mID)
			return false;
		if (uID == null) {
			if (other.uID != null)
				return false;
		} else if (!uID.equals(other.uID))
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
		return "CommentPlus [uID=" + uID + ", userName=" + userName + ", mID=" + mID + ", content=" + content
				+ ", cTime=" + cTime + "]";
	}
	
}
