package org.messageboard.entity;

public class Admin {
	private String id;
	private String pwd;
	private String adminType;
	private String cTime;
	
	public Admin(String id, String pwd, String adminType, String cTime) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.adminType = adminType;
		this.cTime = cTime;
	}

	public Admin(String id, String pwd, String cTime) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.cTime = cTime;
	}

	public Admin() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
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
		result = prime * result + ((adminType == null) ? 0 : adminType.hashCode());
		result = prime * result + ((cTime == null) ? 0 : cTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		Admin other = (Admin) obj;
		if (adminType == null) {
			if (other.adminType != null)
				return false;
		} else if (!adminType.equals(other.adminType))
			return false;
		if (cTime == null) {
			if (other.cTime != null)
				return false;
		} else if (!cTime.equals(other.cTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", pwd=" + pwd + ", adminType=" + adminType + ", cTime=" + cTime + "]";
	}
	
}
