package com.ktb.one2oneforeign;

public class Manager {

	private Integer mgrId;
	private String mgrName;
	
	private Department dept;

	public Integer getMgrId() {
		return mgrId;
	}

	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}


	public Manager(String mgrName) {
		this.mgrName = mgrName;
	}

	public Manager() {
	}

	@Override
	public String toString() {
		return "Manager{" +
				"mgrId=" + mgrId +
				", mgrName='" + mgrName + '\'' +
				'}';
	}
	
	
}
