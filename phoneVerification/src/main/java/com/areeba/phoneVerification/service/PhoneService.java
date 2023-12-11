package com.areeba.phoneVerification.service;

import java.util.Locale;
import org.springframework.stereotype.Service;

import com.areeba.phoneVerification.classes.PhoneNumberRespPayload;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;



@Service
public class PhoneService implements PhoneServiceInterface {

	public PhoneNumberRespPayload getPhoneNumberInfo(String phoneNumber){
		
		PhoneNumberRespPayload payload = new PhoneNumberRespPayload();
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber parsedPhoneNumber = phoneNumberUtil.parse(phoneNumber, "");

            int countryCode = parsedPhoneNumber.getCountryCode();
            String countryName = new Locale("", phoneNumberUtil.getRegionCodeForNumber(parsedPhoneNumber)).getDisplayCountry();
            String operatorName = parsedPhoneNumber.getPreferredDomesticCarrierCode();
            		
            payload = new PhoneNumberRespPayload(countryCode, countryName, operatorName);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return payload;
	}

}
