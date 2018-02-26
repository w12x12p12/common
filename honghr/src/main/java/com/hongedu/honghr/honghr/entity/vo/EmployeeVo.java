package com.hongedu.honghr.honghr.entity.vo;

import java.util.List;

import com.hongedu.honghr.honghr.entity.Department;
import com.hongedu.honghr.honghr.entity.Employee;

public class EmployeeVo extends Employee {

	private static final long serialVersionUID = 1L;

	private String departmentName;// 部门名称

	private String departmentNum;// 部门编号

	private String annualLeaveHourTotalLastYear;// 去年累计年假时长

	private String annualLeaveHourTotalThisYear;// 今年累计年假时长

	private String remainingAnnualHourLastYear;// 去年剩余年假时长

	private String remainingAnnualHourThisYear;// 今年剩余年假时长

	private String remainingAnnualHour;// 剩余年假总时长

	private String remainingHourClear;// 去年剩余年假清空时剩余时长

	private List<Department> departments;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	public String getAnnualLeaveHourTotalLastYear() {
		return annualLeaveHourTotalLastYear;
	}

	public void setAnnualLeaveHourTotalLastYear(String annualLeaveHourTotalLastYear) {
		this.annualLeaveHourTotalLastYear = annualLeaveHourTotalLastYear;
	}

	public String getRemainingAnnualHourLastYear() {
		return remainingAnnualHourLastYear;
	}

	public void setRemainingAnnualHourLastYear(String remainingAnnualHourLastYear) {
		this.remainingAnnualHourLastYear = remainingAnnualHourLastYear;
	}

	public String getRemainingAnnualHourThisYear() {
		return remainingAnnualHourThisYear;
	}

	public void setRemainingAnnualHourThisYear(String remainingAnnualHourThisYear) {
		this.remainingAnnualHourThisYear = remainingAnnualHourThisYear;
	}

	public String getAnnualLeaveHourTotalThisYear() {
		return annualLeaveHourTotalThisYear;
	}

	public void setAnnualLeaveHourTotalThisYear(String annualLeaveHourTotalThisYear) {
		this.annualLeaveHourTotalThisYear = annualLeaveHourTotalThisYear;
	}

	public String getRemainingAnnualHour() {
		return remainingAnnualHour;
	}

	public void setRemainingAnnualHour(String remainingAnnualHour) {
		this.remainingAnnualHour = remainingAnnualHour;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public String getRemainingHourClear() {
		return remainingHourClear;
	}

	public void setRemainingHourClear(String remainingHourClear) {
		this.remainingHourClear = remainingHourClear;
	}
}