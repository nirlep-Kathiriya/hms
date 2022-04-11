package com.hms.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ApplicationForm")
public class ApplicationFormVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Column(name="emergencyNo")
	private String emergencyNo;
	
	@Column(name="birthDate")
	private Date birthDate;
	
	@Column(name="address")
	private String address;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pinCode")
	private String pinCode;
	
	@Column(name="applicationNo")
	private String applicationNo;
	
	@Column(name="currentYear")
	private int currentYear=Calendar.getInstance().get(Calendar.YEAR);
	
	@Column(name="completionYear")
	private int completionYear=Calendar.getInstance().get(Calendar.YEAR)+4; 	
	

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getCompletionYear() {
		return completionYear;
	}

	public void setCompletionYear(int completionYear) {
		this.completionYear = completionYear;
	}

	@Column(name="rejectStatus")
	private boolean rejectStatus=false;
	
	public boolean isRejectStatus() {
		return rejectStatus;
	}

	public void setRejectStatus(boolean rejectStatus) {
		this.rejectStatus = rejectStatus;
	}

	public boolean isAcceptStatus() {
		return acceptStatus;
	}

	public void setAcceptStatus(boolean acceptStatus) {
		this.acceptStatus = acceptStatus;
	}

	@Column(name="acceptStatus")
	private boolean acceptStatus=false;

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmergencyNo() {
		return emergencyNo;
	}

	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
