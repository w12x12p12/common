package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;

import com.hongedu.honghr.base.entity.BaseEntity;
import com.hongedu.honghr.base.dao.annotation.Table;
/**
 * @author  
 * el_sys_role 表对应实体
 * 2017/12/07 04:00:58
 */
@Table(name="sys_role", pk="roleId")
public class Role extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/***/
	private Integer roleId;
	/***/
	private String roleName;
	/***/
	private String deleted;
	
	public void setRoleId(Integer value) {
		this.roleId = value;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleName(String value) {
		this.roleName = value;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setDeleted(String value) {
		this.deleted = value;
	}
	
	public String getDeleted() {
		return deleted;
	}
}


