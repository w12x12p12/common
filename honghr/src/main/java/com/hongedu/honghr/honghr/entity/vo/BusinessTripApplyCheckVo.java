package com.hongedu.honghr.honghr.entity.vo;

import com.hongedu.honghr.honghr.entity.BusinessTripApplyCheck;

public class BusinessTripApplyCheckVo extends BusinessTripApplyCheck{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String checkEmployeeName;
	
	private String applyIsAllowedShow;

	public String getCheckEmployeeName() {
		return checkEmployeeName;
	}

	public void setCheckEmployeeName(String checkEmployeeName) {
		this.checkEmployeeName = checkEmployeeName;
	}

	public String getApplyIsAllowedShow() {
		return applyIsAllowedShow;
	}

	public void setApplyIsAllowedShow(String applyIsAllowedShow) {
		this.applyIsAllowedShow = applyIsAllowedShow;
	}
}
