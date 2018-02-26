package com.hongedu.honghr.honghr.common.enums;

public enum EnumApplyStatus {

	DRAFT("-1", "草稿"), WAIT_CHECK("0", "待审批"), CHECK("1", "审批中"), CHECK_ALLOW("2", "已通过"), CHECK_LIMIT("3", "未通过");

	private String code;

	private String value;

	private EnumApplyStatus(String code, String value) {
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