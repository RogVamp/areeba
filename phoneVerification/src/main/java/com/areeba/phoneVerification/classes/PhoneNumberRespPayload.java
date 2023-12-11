package com.areeba.phoneVerification.classes;

public class PhoneNumberRespPayload {
	
	private int countryCode;
	private String countryName;
	private String operatorName;
	
	
	
	public PhoneNumberRespPayload() {
	}
	
	public PhoneNumberRespPayload(int countryCode, String countryName, String operatorName) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.operatorName = operatorName;
	}
	
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	
	
}
