package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;

import com.hongedu.honghr.base.entity.BaseEntity;
import com.hongedu.honghr.base.dao.annotation.Instant;
import com.hongedu.honghr.base.dao.annotation.Table;

/**
 * @author el_bp_position 表对应实体 2017/12/07 04:00:58
 */
@Table(name = "position", pk = "positionId")
public class Position extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer positionId;
	private String positionNum;
	
	private String positionName;
	
	private Integer departmentId;
	
	private String positionRank;
	
	private String positionCode;
	
	private String referred;
	
	private String deleted;
	
	private Integer positionParentId;
	
	@Instant
	private String depName;

	@Instant
	private String leaderPosition;


	public Integer getPositionParentId() {
		return positionParentId;
	}

	public void setPositionParentId(Integer positionParentId) {
		this.positionParentId = positionParentId;
	}

	public String getLeaderPosition() {
		return leaderPosition;
	}

	public void setLeaderPosition(String leaderPosition) {
		this.leaderPosition = leaderPosition;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public void setPositionId(Integer value) {
		this.positionId = value;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionNum(String value) {
		this.positionNum = value;
	}

	public String getPositionNum() {
		return positionNum;
	}

	public void setPositionName(String value) {
		this.positionName = value;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setDepartmentId(Integer value) {
		this.departmentId = value;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setPositionRank(String value) {
		this.positionRank = value;
	}

	public String getPositionRank() {
		return positionRank;
	}

	public void setPositionCode(String value) {
		this.positionCode = value;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setReferred(String value) {
		this.referred = value;
	}

	public String getReferred() {
		return referred;
	}

	public void setDeleted(String value) {
		this.deleted = value;
	}

	public String getDeleted() {
		return deleted;
	}
}
