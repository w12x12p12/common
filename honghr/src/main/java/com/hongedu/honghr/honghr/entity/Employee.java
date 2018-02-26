package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hongedu.honghr.base.dao.annotation.Instant;
import com.hongedu.honghr.base.dao.annotation.Table;
import com.hongedu.honghr.base.entity.BaseEntity;
/**
 * @author  
 * el_bp_employee 表对应实体
 * 2017/12/07 04:00:57
 */
@Table(name="employee", pk="employeeId")
public class Employee extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer employeeId;
	
	private String username;
	
	private String password;
	
	private String employeeName;
	
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	private String nativePlace;
	
	private String nation;
	
	private String address;
	
	private String phoneNumber;
	
	private String email;
	
	private String idcard;
	
	private String education;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date workBeginTime; //参加工作时间
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryTime; //入职时间
	/***/
	private String forbided;
	/***/
	private String referred;
	/***/
	private String deleted;
	@Instant
	private String DEPname;
	@Instant
	private String workYear;
	@Instant
	private String age;
	@Instant
	private String entryLength;
	
	public String getEntryLength() {
		return entryLength;
	}

	public void setEntryLength(String entryLength) {
		this.entryLength = entryLength;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDEPname() {
		return DEPname;
	}

	public void setDEPname(String dEPname) {
		DEPname = dEPname;
	}

	public void setEmployeeId(Integer value) {
		this.employeeId = value;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	public void setEmployeeName(String value) {
		this.employeeName = value;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setGender(String value) {
		this.gender = value;
	}
	
	public String getGender() {
		return gender;
	}
	public void setBirthday(Date value) {
		this.birthday = value;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setNativePlace(String value) {
		this.nativePlace = value;
	}
	
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNation(String value) {
		this.nation = value;
	}
	
	public String getNation() {
		return nation;
	}
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	public void setIdcard(String value) {
		this.idcard = value;
	}
	
	public String getIdcard() {
		return idcard;
	}
	public void setEducation(String value) {
		this.education = value;
	}
	
	public String getEducation() {
		return education;
	}
	
	public Date getWorkBeginTime() {
		return workBeginTime;
	}

	public void setWorkBeginTime(Date workBeginTime) {
		this.workBeginTime = workBeginTime;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public void setForbided(String value) {
		this.forbided = value;
	}
	
	public String getForbided() {
		return forbided;
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