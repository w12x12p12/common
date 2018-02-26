package com.hongedu.honghr.honghr.entity.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.hongedu.honghr.honghr.entity.AbsenceApply;
import com.hongedu.honghr.honghr.entity.AbsenceApplyCheck;
import com.hongedu.honghr.honghr.entity.Attachment;

public class AbsenceApplyVo extends AbsenceApply {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String applyEmployeeName;

	private Date applyEmployeeWorkBeginTime;

	private Date applyEmployeeEntryTime;

	private String applyDepartmentName;

	private String applyTypeShow;

	private String applyCheckStatusShow;

	private Integer applyIsAllowed;

	private String createEmployeeName;

	private Integer checkEmployeeId;

	private String checkEmployeeName;

	private Date applyCheckTime;

	private String applyCheckIsAllowed;

	private String applyCheckIsAllowedShow;

	private String applyCheckSuggest;

	private String imageAttachment;

	private Attachment attachment;

	private List<AbsenceApplyCheck> absenceApplyChecks;

	private List<AbsenceApplyCheckVo> absenceApplyCheckVos;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;

	public String getApplyEmployeeName() {
		return applyEmployeeName;
	}

	public void setApplyEmployeeName(String applyEmployeeName) {
		this.applyEmployeeName = applyEmployeeName;
	}

	public Date getApplyEmployeeWorkBeginTime() {
		return applyEmployeeWorkBeginTime;
	}

	public void setApplyEmployeeWorkBeginTime(Date applyEmployeeWorkBeginTime) {
		this.applyEmployeeWorkBeginTime = applyEmployeeWorkBeginTime;
	}

	public Date getApplyEmployeeEntryTime() {
		return applyEmployeeEntryTime;
	}

	public void setApplyEmployeeEntryTime(Date applyEmployeeEntryTime) {
		this.applyEmployeeEntryTime = applyEmployeeEntryTime;
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

	public String getImageAttachment() {
		return imageAttachment;
	}

	public void setImageAttachment(String imageAttachment) {
		this.imageAttachment = imageAttachment;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public List<AbsenceApplyCheck> getAbsenceApplyChecks() {
		return absenceApplyChecks;
	}

	public void setAbsenceApplyChecks(List<AbsenceApplyCheck> absenceApplyChecks) {
		this.absenceApplyChecks = absenceApplyChecks;
	}

	public List<AbsenceApplyCheckVo> getAbsenceApplyCheckVos() {
		return absenceApplyCheckVos;
	}

	public void setAbsenceApplyCheckVos(List<AbsenceApplyCheckVo> absenceApplyCheckVos) {
		this.absenceApplyCheckVos = absenceApplyCheckVos;
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

	public String getApplyCheckSuggest() {
		return applyCheckSuggest;
	}

	public void setApplyCheckSuggest(String applyCheckSuggest) {
		this.applyCheckSuggest = applyCheckSuggest;
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