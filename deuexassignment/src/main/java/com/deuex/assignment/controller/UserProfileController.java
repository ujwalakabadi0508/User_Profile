package com.deuex.assignment.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deuex.assignment.common.MessageConstants;
import com.deuex.assignment.common.ResponseModel;
import com.deuex.assignment.model.UserProfileModel;
import com.deuex.assignment.service.UserProfileService;

@RestController
@RequestMapping(value="/userProfile")
public class UserProfileController {
	
	Logger logger =LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired
	UserProfileService userProfileService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<ResponseModel> saveUserProfile(@RequestBody UserProfileModel userProfileModel) {
		logger.info(":::: UserProfileController :::: || ::::: saveUserProfile :::: "+ userProfileModel);
		
		System.out.println("hello ");
		ResponseModel responseModel = new ResponseModel();
		HashMap<String , Object> map = userProfileService.saveUserProfile(userProfileModel);
		if(map.size()>0) {
			responseModel.setStatusCode(MessageConstants.SUCCESS_CODE);
			responseModel.setStatusDesc(MessageConstants.SUCCESS_DESC);
			responseModel.setData(map);
			
		}else {
			responseModel.setStatusCode(MessageConstants.FAIL_CODE);
			responseModel.setStatusDesc(MessageConstants.FAIL_DESC);
			responseModel.setData(map);
		}
		return new ResponseEntity<ResponseModel>(responseModel , HttpStatus.OK);
	}


	@RequestMapping(value = "/fetchUserProfile", method = RequestMethod.POST)
	public ResponseEntity<ResponseModel> fetchUserProfile(@RequestBody UserProfileModel userProfileModel) {
		
		HashMap<String, Object> map = new HashMap<>();
		ResponseModel responseModel = new ResponseModel();
		
		UserProfileModel userProModel = userProfileService.fetchUserProfile(userProfileModel.getUserProfileId() , userProfileModel.getFullName());
		if(!ObjectUtils.isEmpty(userProModel)) {
			responseModel.setStatusCode(MessageConstants.SUCCESS_CODE);
			responseModel.setStatusDesc(MessageConstants.SUCCESS_DESC);
			map.put("userProfile", userProModel);
			responseModel.setData(map);
		}else {
			responseModel.setStatusCode(MessageConstants.FAIL_CODE);
			responseModel.setStatusDesc(MessageConstants.FAIL_DESC);
			map.put("userProfile", userProModel);
			responseModel.setData(map);
		}
		return new ResponseEntity<ResponseModel>(responseModel , HttpStatus.OK);
	}

	
	@RequestMapping(value = "/delete/{userProfileId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseModel> deleteUserProfile(@PathVariable Long userProfileId) {
		
		ResponseModel responseModel = new ResponseModel();
		boolean isDeleted = userProfileService.deleteUserProfile(userProfileId);
		if(isDeleted) {
			responseModel.setStatusCode(MessageConstants.SUCCESS_CODE);
			responseModel.setStatusDesc(MessageConstants.SUCCESSFULLY_DELETED);
		}else {
			responseModel.setStatusCode(MessageConstants.FAIL_CODE);
			responseModel.setStatusDesc(MessageConstants.NOT_DELETED);
		}
		
		return new ResponseEntity<ResponseModel>(responseModel , HttpStatus.OK);
	}

	
}
