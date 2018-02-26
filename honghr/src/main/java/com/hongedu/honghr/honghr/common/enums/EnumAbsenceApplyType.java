package com.hongedu.honghr.honghr.common.enums;

public enum EnumAbsenceApplyType {
	LEAVE("101105","调休","setLeaveHourMonth"), ANNUAL_LEAVE("101101","年假","setAnnualHourTotal"),SICK_LEAVE("101107","病假","setSickLeaveHourMonth"),
	CASUAL_LEAVE("101108","事假","setCasualLeaveHourMonth"),PUBLIC_LEAVE("101109","公假","setPublicLeaveHourMonth"),MARRIAGE_LEAVE("101102","婚假","setMarriageLeaveHourMonth"),
	BEREAVEMENT_LEAVE("101103","丧假","setBereavementLeaveHourMonth"), MATERNITY_LEAVE("101104","产检假","setMaternityLeaveHourMonth"), PATERNITY_LEAVE("101106","陪产假","setPaternityLeaveHourMonth");
	
	private String code;
	
	private String value;
	
	private String setMonthMethodName;
	
	private EnumAbsenceApplyType(String code, String value, String setMonthMethodName) {
		this.code = code;
		this.value = value;
		this.setMonthMethodName = setMonthMethodName;
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

	public String getSetMonthMethodName() {
		return setMonthMethodName;
	}

	public void setSetMonthMethodName(String setMonthMethodName) {
		this.setMonthMethodName = setMonthMethodName;
	}
}