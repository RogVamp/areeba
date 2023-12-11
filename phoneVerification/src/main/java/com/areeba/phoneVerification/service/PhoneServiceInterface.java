package com.areeba.phoneVerification.service;


import com.areeba.phoneVerification.classes.PhoneNumberRespPayload;

public interface PhoneServiceInterface {
	public PhoneNumberRespPayload getPhoneNumberInfo(String phoneNumber);
}
