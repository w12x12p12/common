package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;

import com.hongedu.honghr.base.dao.annotation.Table;
import com.hongedu.honghr.base.entity.BaseEntity;

@Table(name="employee_annual_leave", pk="employeeAnnualLeaveId")
public class EmployeeAnnualLeave extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer employeeAnnualLeaveId;
	
	private Integer employeeId;
	
	private String yearName;
	
	private String isClear;
	
	private String remainingHour;
	
	private Integer count;

	public Integer getEmployeeAnnualLeaveId() {
		return employeeAnnualLeaveId;
	}

	public void setEmployeeAnnualLeaveId(Integer employeeAnnualLeaveId) {
		this.employeeAnnualLeaveId = employeeAnnualLeaveId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}

	public String getIsClear() {
		return isClear;
	}

	public void setIsClear(String isClear) {
		this.isClear = isClear;
	}

	public String getRemainingHour() {
		return remainingHour;
	}

	public void setRemainingHour(String remainingHour) {
		this.remainingHour = remainingHour;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}