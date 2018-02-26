package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;
import java.util.Date;

import com.hongedu.honghr.base.dao.annotation.Table;
import com.hongedu.honghr.base.entity.BaseEntity;

/**
 * @author el_bp_absence_apply_check 表对应实体 2017/12/07 04:00:56
 */
@Table(name = "absence_apply_check", pk = "absenceApplyCheckId")
public class AbsenceApplyCheck extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private Integer absenceApplyCheckId;
	/***/
	private Integer absenceApplyId;
	/***/
	private Integer checkEmployeeId;
	/***/
	private Date applyCheckTime;
	/***/
	private String applyIsAllowed;
	/***/
	private String applyCheckSuggest;
	
	private Integer applyCheckSequence;
	/***/
	private String deleted;

	public void setAbsenceApplyCheckId(Integer value) {
		this.absenceApplyCheckId = value;
	}

	public Integer getAbsenceApplyCheckId() {
		return absenceApplyCheckId;
	}

	public void setAbsenceApplyId(Integer value) {
		this.absenceApplyId = value;
	}

	public Integer getAbsenceApplyId() {
		return absenceApplyId;
	}

	public void setCheckEmployeeId(Integer value) {
		this.checkEmployeeId = value;
	}

	public Integer getCheckEmployeeId() {
		return checkEmployeeId;
	}

	public void setApplyCheckTime(Date value) {
		this.applyCheckTime = value;
	}

	public Date getApplyCheckTime() {
		return applyCheckTime;
	}

	public void setApplyIsAllowed(String value) {
		this.applyIsAllowed = value;
	}

	public String getApplyIsAllowed() {
		return applyIsAllowed;
	}

	public void setApplyCheckSuggest(String value) {
		this.applyCheckSuggest = value;
	}

	public String getApplyCheckSuggest() {
		return applyCheckSuggest;
	}

	public Integer getApplyCheckSequence() {
		return applyCheckSequence;
	}

	public void setApplyCheckSequence(Integer applyCheckSequence) {
		this.applyCheckSequence = applyCheckSequence;
	}

	public void setDeleted(String value) {
		this.deleted = value;
	}

	public String getDeleted() {
		return deleted;
	}
}
