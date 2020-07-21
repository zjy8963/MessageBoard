package org.messageboard.entity;

public class User {
	private String phoneNumber;
	private String userName;
	private int age;
	private String gender;
	private String Email;
	private String ID;
	private String userStatus;
	private String pwd;
	private String cTime;
	

	public User(String phoneNumber, int age, String email, String iD, String userStatus) {
		super();
		this.phoneNumber = phoneNumber;
		this.age = age;
		Email = email;
		ID = iD;
		this.userStatus = userStatus;
	}


	public String getcTime() {
		return cTime;
	}


	public void setcTime(String cTime) {
		this.cTime = cTime;
	}


	public User() {
		super();
	}

	//验证用户
	public User(String phoneNumber, String pwd) {
		super();
		this.phoneNumber = phoneNumber;
		this.pwd = pwd;
	}

	


	public User(String phoneNumber, String userName, int age, String gender, String email, String iD, String userStatus,
			String pwd, String cTime) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		Email = email;
		ID = iD;
		this.userStatus = userStatus;
		this.pwd = pwd;
		this.cTime = cTime;
	}


	public User(String phoneNumber, String userName, int age, String gender, String email, String iD, String pwd,
			String cTime) {
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		Email = email;
		ID = iD;
		this.pwd = pwd;
		this.cTime = cTime;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + age;
		result = prime * result + ((cTime == null) ? 0 : cTime.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
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
		User other = (User) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (age != other.age)
			return false;
		if (cTime == null) {
			if (other.cTime != null)
				return false;
		} else if (!cTime.equals(other.cTime))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", userName=" + userName + ", age=" + age + ", gender=" + gender
				+ ", Email=" + Email + ", ID=" + ID + ", userStatus=" + userStatus + ", pwd=" + pwd + ", cTime=" + cTime
				+ "]";
	}
	

	
	
	
	
}
