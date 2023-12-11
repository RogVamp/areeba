package com.areeba.phoneVerification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areeba.phoneVerification.classes.PhoneNumberReqPayload;
import com.areeba.phoneVerification.classes.PhoneNumberRespPayload;
import com.areeba.phoneVerification.service.PhoneService;


@RestController
@RequestMapping("/phoneNumber")
@CrossOrigin({"http://localhost:8080/"})
public class verificationController {

	@Autowired
	private PhoneService phoneService;
	
	
	
	
	
	@PostMapping
	public PhoneNumberRespPayload phoneNumber(@RequestBody PhoneNumberReqPayload req) {
		return phoneService.getPhoneNumberInfo(req.getPhoneNumber());
	}
	
	
	
}
