package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hongedu.honghr.base.dao.annotation.Table;
import com.hongedu.honghr.base.entity.BaseEntity;

/**
 * @author el_bp_business_trip_apply 表对应实体 2017/12/07 04:00:56
 */
@Table(name = "business_trip_apply", pk = "businessTripApplyId")
public class BusinessTripApply extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private Integer businessTripApplyId;
	/***/
	private String businessTripApplyNum;
	/***/
	private String applyDepartmentNum;
	/***/
	private Integer employeeId;

	private String applyType;
	/***/
	private String applyReason;
	/***/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date applyBeginTime;
	/***/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date applyEndTime;
	/***/
	private String applyDuration;
	/***/
	private String applyBeginAddress;

	private String applyEndAddress;
	/***/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date applyDateTime;
	/***/
	private String applyCheckStatus;
	/***/
	private String applyCheckProgress;
	/***/
	private Integer createEmployeeId;
	/***/
	private Date createDateTime;
	/***/
	private String businessTripReportUrl;
	/***/
	private String deleted;

	public void setBusinessTripApplyId(Integer value) {
		this.businessTripApplyId = value;
	}

	public Integer getBusinessTripApplyId() {
		return businessTripApplyId;
	}

	public void setBusinessTripApplyNum(String value) {
		this.businessTripApplyNum = value;
	}

	public String getBusinessTripApplyNum() {
		return businessTripApplyNum;
	}

	public String getApplyDepartmentNum() {
		return applyDepartmentNum;
	}

	public void setApplyDepartmentNum(String applyDepartmentNum) {
		this.applyDepartmentNum = applyDepartmentNum;
	}

	public void setEmployeeId(Integer value) {
		this.employeeId = value;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public void setApplyReason(String value) {
		this.applyReason = value;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyBeginTime(Date value) {
		this.applyBeginTime = value;
	}

	public Date getApplyBeginTime() {
		return applyBeginTime;
	}

	public void setApplyEndTime(Date value) {
		this.applyEndTime = value;
	}

	public Date getApplyEndTime() {
		return applyEndTime;
	}

	public void setApplyDuration(String value) {
		this.applyDuration = value;
	}

	public String getApplyDuration() {
		return applyDuration;
	}

	public String getApplyBeginAddress() {
		return applyBeginAddress;
	}

	public void setApplyBeginAddress(String applyBeginAddress) {
		this.applyBeginAddress = applyBeginAddress;
	}

	public String getApplyEndAddress() {
		return applyEndAddress;
	}

	public void setApplyEndAddress(String applyEndAddress) {
		this.applyEndAddress = applyEndAddress;
	}

	public void setApplyDateTime(Date value) {
		this.applyDateTime = value;
	}

	public Date getApplyDateTime() {
		return applyDateTime;
	}

	public void setApplyCheckStatus(String value) {
		this.applyCheckStatus = value;
	}

	public String getApplyCheckStatus() {
		return applyCheckStatus;
	}

	public void setApplyCheckProgress(String value) {
		this.applyCheckProgress = value;
	}

	public String getApplyCheckProgress() {
		return applyCheckProgress;
	}

	public void setCreateEmployeeId(Integer value) {
		this.createEmployeeId = value;
	}

	public Integer getCreateEmployeeId() {
		return createEmployeeId;
	}

	public void setCreateDateTime(Date value) {
		this.createDateTime = value;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public String getBusinessTripReportUrl() {
		return businessTripReportUrl;
	}

	public void setBusinessTripReportUrl(String businessTripReportUrl) {
		this.businessTripReportUrl = businessTripReportUrl;
	}

	public void setDeleted(String value) {
		this.deleted = value;
	}

	public String getDeleted() {
		return deleted;
	}
}
