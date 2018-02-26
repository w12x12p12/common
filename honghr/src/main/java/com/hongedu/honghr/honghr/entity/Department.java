package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;

import com.hongedu.honghr.base.entity.BaseEntity;
import com.hongedu.honghr.base.dao.annotation.Instant;
import com.hongedu.honghr.base.dao.annotation.Table;

/**
 * @author el_bp_department 表对应实体 2017/12/07 04:00:57
 */
@Table(name = "department", pk = "departmentId")
public class Department extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer departmentId;
	
	private String departmentNum;
	
	private String departmentName;
	
	private String departmentIntroduction;

	private String departmentRank;

	private Integer departmentParentId;
	
	private String referred;
	
	private String deleted;
	
	@Instant
	private String parentDepName;

	public String getParentDepName() {
		return parentDepName;
	}

	public void setParentDepName(String parentDepName) {
		this.parentDepName = parentDepName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentIntroduction() {
		return departmentIntroduction;
	}

	public void setDepartmentIntroduction(String departmentIntroduction) {
		this.departmentIntroduction = departmentIntroduction;
	}

	public String getDepartmentRank() {
		return departmentRank;
	}

	public void setDepartmentRank(String departmentRank) {
		this.departmentRank = departmentRank;
	}

	public Integer getDepartmentParentId() {
		return departmentParentId;
	}

	public void setDepartmentParentId(Integer departmentParentId) {
		this.departmentParentId = departmentParentId;
	}

	public String getReferred() {
		return referred;
	}

	public void setReferred(String referred) {
		this.referred = referred;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
}
