package com.areeba.phoneVerification.classes;

public class PhoneNumberReqPayload {
	
	private String phoneNumber;
	
	
	
	public PhoneNumberReqPayload() {
	}
	
	public PhoneNumberReqPayload(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	
}
