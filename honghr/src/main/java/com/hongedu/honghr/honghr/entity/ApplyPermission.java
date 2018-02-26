package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;

import com.hongedu.honghr.base.entity.BaseEntity;
import com.hongedu.honghr.base.dao.annotation.Table;

/**
 * @author el_bp_apply_permission 表对应实体 2017/12/07 04:00:56
 */
@Table(name = "apply_permission", pk = "applyPermissionId")
public class ApplyPermission extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private Integer applyPermissionId;
	/***/
	private Integer employeeId;
	/***/
	private Integer departmentId;
	/***/
	private String checkPermission;
	/***/
	private String checkLevel;
	/***/
	private String deleted;

	public void setApplyPermissionId(Integer value) {
		this.applyPermissionId = value;
	}

	public Integer getApplyPermissionId() {
		return applyPermissionId;
	}

	public void setEmployeeId(Integer value) {
		this.employeeId = value;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setDepartmentId(Integer value) {
		this.departmentId = value;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setCheckPermission(String value) {
		this.checkPermission = value;
	}

	public String getCheckPermission() {
		return checkPermission;
	}

	public void setCheckLevel(String value) {
		this.checkLevel = value;
	}

	public String getCheckLevel() {
		return checkLevel;
	}

	public void setDeleted(String value) {
		this.deleted = value;
	}

	public String getDeleted() {
		return deleted;
	}
}
