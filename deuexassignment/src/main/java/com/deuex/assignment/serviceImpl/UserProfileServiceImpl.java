package com.deuex.assignment.serviceImpl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.deuex.assignment.dao.UserProfileDao;
import com.deuex.assignment.model.DocumentModel;
import com.deuex.assignment.model.UserProfileModel;
import com.deuex.assignment.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	
	Logger logger= LoggerFactory.getLogger(UserProfileServiceImpl.class);

	@Autowired
	UserProfileDao userProfileDao;
	
	/**
	 *
	 */
	@Override
	public HashMap<String, Object> saveUserProfile(UserProfileModel userProfileModel) {
		
		logger.info(":::: UserProfileServiceImpl :::: || :::: saveUserProfile :::: "+userProfileModel);
		
		UserProfileModel userProfile = new UserProfileModel();
		DocumentModel docModel = null;
		try {
			System.out.println(" userProfileModel.getUserProfileId() :::::: "+userProfileModel.getUserProfileId());
			if(userProfileModel.getUserProfileId() != null) {
				userProfile.setUserProfileId(userProfileModel.getUserProfileId());
			}
			userProfile.setFullName(userProfileModel.getFullName());
			userProfile.setEmail(userProfileModel.getEmail());
			userProfile.setGender(userProfileModel.getGender());
			userProfile.setMobileNo(userProfileModel.getMobileNo());
			userProfile.setLocation(userProfileModel.getLocation());
			userProfile.setAddress(userProfileModel.getAddress());
			System.out.println("user profile :: "+userProfile.toString());
			DocumentModel document = userProfileModel.getDocuments();
			if(!ObjectUtils.isEmpty(document)) {
				docModel = new DocumentModel();
				if(document.getDocumentId()!=null) {
					docModel.setDocumentId(document.getDocumentId());
				}
				docModel.setDocumentType(document.getDocumentType());
				docModel.setDocuemntUrl(document.getDocumentType());
				docModel.setUserProfileModel(userProfile);
				userProfile.setDocuments(docModel);
			}
			UserProfileModel resultUserProfile =userProfileDao.save(userProfile);
			
			if(!ObjectUtils.isEmpty(resultUserProfile)) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("userProfileId", resultUserProfile.getUserProfileId());
				return map;
			}else {
				return new HashMap<>();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserProfileModel fetchUserProfile(Long userProfileId, String fullName) {
		
		logger.info(":::: UserProfileServiceImpl :::: || :::: fetchUserProfile :::: "+userProfileId + " :::: Full Name ::::"+ fullName);
		
		try {
			UserProfileModel userProfileModel = userProfileDao.findByUserProfileIdAndFullName(userProfileId , fullName);
			if(!ObjectUtils.isEmpty(userProfileModel)) {
				return userProfileModel;
			}else {
				return userProfileModel;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUserProfile(Long userProfileId) {
		logger.info(":::: UserProfileServiceImpl :::: || :::: fetchUserProfile :::: "+userProfileId );
		
		try {
			Integer isDeleted = userProfileDao.deleteByUserProfileId(userProfileId);
			System.out.println(isDeleted);
		if(isDeleted == 1) {
			return true;
		}else if(isDeleted == 0){
			return false;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	
}
