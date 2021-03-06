package com.hongedu.honghr.honghr.common.enums;

public enum EnumApplyCheckStatus {
	
	UN_CHECK("-1","未审批"), DISAGREE("0","不同意"), AGREE("1","同意");
	
	private String code;

	private String value;

	private EnumApplyCheckStatus(String code, String value) {
		this.code = code;
		this.value = value;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}