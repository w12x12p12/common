package com.hongedu.honghr.honghr.entity.vo;

import java.util.Date;
import java.util.List;

import com.hongedu.honghr.honghr.entity.Department;

public class AbsenceApplyTimeVo {

	private Integer employeeId;// 员工id

	private String employeeName;// 姓名

	private String departmentName;// 部门名称

	private String duration;// 时长

	private String applyType;// 类型

	private Date workBeginTime; // 参加工作时间

	private Date entryTime; // 入职时间

	private String overTimeWorkHourMonth;// 本月加班时长

	private String overTimeWorkHourToTal;// 累计加班时长

	private String leaveHourMonth;// 本月调休时长

	private String leaveHourTotal;// 累计调休时长

	private String remainingLeaveHour;// 剩余可调休时长

	private String annualHourThisYear;// 今年累计年假时长

	private String annualHourTotal;// 累计年假时长

	private String annualHour;// 今年已休年假时长

	private String remainingAnnualHourThisYear;// 今年剩余年假时长

	private String remainingAnnualHourLastYear;// 去年剩余年假时长

	private String remainingHourClear;// 去年剩余年假清空时剩余时长

	private String decRemainingHourLastYear;// 抵扣去年年假时长

	private String remainingAnnualHour;// 剩余年假时长

	private String otherAbsenceApplyHourMonth;// 本月其余休假时长(除调休和年假)

	private String sickLeaveHourMonth;// 本月休病假时长

	private String casualLeaveHourMonth;// 本月休事假时长

	private String publicLeaveHourMonth;// 本月休公假时长

	private String marriageLeaveHourMonth;// 本月休婚假时长

	private String bereavementLeaveHourMonth;// 本月休丧假时长

	private String maternityLeaveHourMonth;// 本月休产检假时长

	private String paternityLeaveHourMonth;// 本月陪产假时长

	private List<Department> departments;// 部门

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public Date getWorkBeginTime() {
		return workBeginTime;
	}

	public void setWorkBeginTime(Date workBeginTime) {
		this.workBeginTime = workBeginTime;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getOverTimeWorkHourMonth() {
		return overTimeWorkHourMonth;
	}

	public void setOverTimeWorkHourMonth(String overTimeWorkHourMonth) {
		this.overTimeWorkHourMonth = overTimeWorkHourMonth;
	}

	public String getOverTimeWorkHourToTal() {
		return overTimeWorkHourToTal;
	}

	public void setOverTimeWorkHourToTal(String overTimeWorkHourToTal) {
		this.overTimeWorkHourToTal = overTimeWorkHourToTal;
	}

	public String getLeaveHourMonth() {
		return leaveHourMonth;
	}

	public void setLeaveHourMonth(String leaveHourMonth) {
		this.leaveHourMonth = leaveHourMonth;
	}

	public String getLeaveHourTotal() {
		return leaveHourTotal;
	}

	public void setLeaveHourTotal(String leaveHourTotal) {
		this.leaveHourTotal = leaveHourTotal;
	}

	public String getRemainingLeaveHour() {
		return remainingLeaveHour;
	}

	public void setRemainingLeaveHour(String remainingLeaveHour) {
		this.remainingLeaveHour = remainingLeaveHour;
	}

	public String getAnnualHourThisYear() {
		return annualHourThisYear;
	}

	public void setAnnualHourThisYear(String annualHourThisYear) {
		this.annualHourThisYear = annualHourThisYear;
	}

	public String getAnnualHourTotal() {
		return annualHourTotal;
	}

	public void setAnnualHourTotal(String annualHourTotal) {
		this.annualHourTotal = annualHourTotal;
	}

	public String getAnnualHour() {
		return annualHour;
	}

	public void setAnnualHour(String annualHour) {
		this.annualHour = annualHour;
	}

	public String getRemainingAnnualHour() {
		return remainingAnnualHour;
	}

	public void setRemainingAnnualHour(String remainingAnnualHour) {
		this.remainingAnnualHour = remainingAnnualHour;
	}

	public String getRemainingAnnualHourLastYear() {
		return remainingAnnualHourLastYear;
	}

	public void setRemainingAnnualHourLastYear(String remainingAnnualHourLastYear) {
		this.remainingAnnualHourLastYear = remainingAnnualHourLastYear;
	}

	public String getRemainingHourClear() {
		return remainingHourClear;
	}

	public void setRemainingHourClear(String remainingHourClear) {
		this.remainingHourClear = remainingHourClear;
	}

	public String getOtherAbsenceApplyHourMonth() {
		return otherAbsenceApplyHourMonth;
	}

	public void setOtherAbsenceApplyHourMonth(String otherAbsenceApplyHourMonth) {
		this.otherAbsenceApplyHourMonth = otherAbsenceApplyHourMonth;
	}

	public String getSickLeaveHourMonth() {
		return sickLeaveHourMonth;
	}

	public void setSickLeaveHourMonth(String sickLeaveHourMonth) {
		this.sickLeaveHourMonth = sickLeaveHourMonth;
	}

	public String getCasualLeaveHourMonth() {
		return casualLeaveHourMonth;
	}

	public void setCasualLeaveHourMonth(String casualLeaveHourMonth) {
		this.casualLeaveHourMonth = casualLeaveHourMonth;
	}

	public String getPublicLeaveHourMonth() {
		return publicLeaveHourMonth;
	}

	public void setPublicLeaveHourMonth(String publicLeaveHourMonth) {
		this.publicLeaveHourMonth = publicLeaveHourMonth;
	}

	public String getMarriageLeaveHourMonth() {
		return marriageLeaveHourMonth;
	}

	public void setMarriageLeaveHourMonth(String marriageLeaveHourMonth) {
		this.marriageLeaveHourMonth = marriageLeaveHourMonth;
	}

	public String getBereavementLeaveHourMonth() {
		return bereavementLeaveHourMonth;
	}

	public void setBereavementLeaveHourMonth(String bereavementLeaveHourMonth) {
		this.bereavementLeaveHourMonth = bereavementLeaveHourMonth;
	}

	public String getMaternityLeaveHourMonth() {
		return maternityLeaveHourMonth;
	}

	public void setMaternityLeaveHourMonth(String maternityLeaveHourMonth) {
		this.maternityLeaveHourMonth = maternityLeaveHourMonth;
	}

	public String getPaternityLeaveHourMonth() {
		return paternityLeaveHourMonth;
	}

	public void setPaternityLeaveHourMonth(String paternityLeaveHourMonth) {
		this.paternityLeaveHourMonth = paternityLeaveHourMonth;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public String getRemainingAnnualHourThisYear() {
		return remainingAnnualHourThisYear;
	}

	public void setRemainingAnnualHourThisYear(String remainingAnnualHourThisYear) {
		this.remainingAnnualHourThisYear = remainingAnnualHourThisYear;
	}

	public String getDecRemainingHourLastYear() {
		return decRemainingHourLastYear;
	}

	public void setDecRemainingHourLastYear(String decRemainingHourLastYear) {
		this.decRemainingHourLastYear = decRemainingHourLastYear;
	}
}