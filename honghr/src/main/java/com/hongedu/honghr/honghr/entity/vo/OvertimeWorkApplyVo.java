package com.hongedu.honghr.honghr.entity.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.hongedu.honghr.honghr.entity.OvertimeWorkApply;
import com.hongedu.honghr.honghr.entity.OvertimeWorkApplyCheck;

public class OvertimeWorkApplyVo extends OvertimeWorkApply {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer applyEmployeeId;

	private String applyEmployeeName;

	private String applyDepartmentName;

	private String applyTypeShow;

	private String applyCheckStatusShow;

	private String createEmployeeName;

	private Integer applyIsAllowed;

	private String applyCheckSuggest;

	private Integer checkEmployeeId;

	private String checkEmployeeName;

	private Date applyCheckTime;

	private String applyCheckIsAllowed;

	private String applyCheckIsAllowedShow;

	private List<OvertimeWorkApplyCheck> overtimeWorkApplyChecks;

	private List<OvertimeWorkApplyCheckVo> overtimeWorkApplyCheckVos;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;

	public Integer getApplyEmployeeId() {
		return applyEmployeeId;
	}

	public void setApplyEmployeeId(Integer applyEmployeeId) {
		this.applyEmployeeId = applyEmployeeId;
	}

	public String getApplyEmployeeName() {
		return applyEmployeeName;
	}

	public void setApplyEmployeeName(String applyEmployeeName) {
		this.applyEmployeeName = applyEmployeeName;
	}

	public String getApplyDepartmentName() {
		return applyDepartmentName;
	}

	public void setApplyDepartmentName(String applyDepartmentName) {
		this.applyDepartmentName = applyDepartmentName;
	}

	public String getApplyTypeShow() {
		return applyTypeShow;
	}

	public void setApplyTypeShow(String applyTypeShow) {
		this.applyTypeShow = applyTypeShow;
	}

	public String getApplyCheckStatusShow() {
		return applyCheckStatusShow;
	}

	public void setApplyCheckStatusShow(String applyCheckStatusShow) {
		this.applyCheckStatusShow = applyCheckStatusShow;
	}

	public String getCreateEmployeeName() {
		return createEmployeeName;
	}

	public void setCreateEmployeeName(String createEmployeeName) {
		this.createEmployeeName = createEmployeeName;
	}

	public Integer getApplyIsAllowed() {
		return applyIsAllowed;
	}

	public void setApplyIsAllowed(Integer applyIsAllowed) {
		this.applyIsAllowed = applyIsAllowed;
	}

	public String getApplyCheckSuggest() {
		return applyCheckSuggest;
	}

	public void setApplyCheckSuggest(String applyCheckSuggest) {
		this.applyCheckSuggest = applyCheckSuggest;
	}

	public Integer getCheckEmployeeId() {
		return checkEmployeeId;
	}

	public void setCheckEmployeeId(Integer checkEmployeeId) {
		this.checkEmployeeId = checkEmployeeId;
	}

	public String getCheckEmployeeName() {
		return checkEmployeeName;
	}

	public void setCheckEmployeeName(String checkEmployeeName) {
		this.checkEmployeeName = checkEmployeeName;
	}

	public Date getApplyCheckTime() {
		return applyCheckTime;
	}

	public void setApplyCheckTime(Date applyCheckTime) {
		this.applyCheckTime = applyCheckTime;
	}

	public String getApplyCheckIsAllowed() {
		return applyCheckIsAllowed;
	}

	public void setApplyCheckIsAllowed(String applyCheckIsAllowed) {
		this.applyCheckIsAllowed = applyCheckIsAllowed;
	}

	public String getApplyCheckIsAllowedShow() {
		return applyCheckIsAllowedShow;
	}

	public void setApplyCheckIsAllowedShow(String applyCheckIsAllowedShow) {
		this.applyCheckIsAllowedShow = applyCheckIsAllowedShow;
	}

	public List<OvertimeWorkApplyCheck> getOvertimeWorkApplyChecks() {
		return overtimeWorkApplyChecks;
	}

	public void setOvertimeWorkApplyChecks(List<OvertimeWorkApplyCheck> overtimeWorkApplyChecks) {
		this.overtimeWorkApplyChecks = overtimeWorkApplyChecks;
	}

	public List<OvertimeWorkApplyCheckVo> getOvertimeWorkApplyCheckVos() {
		return overtimeWorkApplyCheckVos;
	}

	public void setOvertimeWorkApplyCheckVos(List<OvertimeWorkApplyCheckVo> overtimeWorkApplyCheckVos) {
		this.overtimeWorkApplyCheckVos = overtimeWorkApplyCheckVos;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}