package com.ktb.one2one;

public class Department {

	private Integer deptId;
	private String deptName;
	
	private Manager mgr;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public Department() {
	}

	@Override
	public String toString() {
		return "Department{" +
				"deptId=" + deptId +
				", deptName='" + deptName + '\'' +
				'}';
	}
}
