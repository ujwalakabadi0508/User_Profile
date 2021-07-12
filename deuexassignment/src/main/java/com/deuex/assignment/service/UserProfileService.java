package com.deuex.assignment.service;


import java.util.*;

import com.deuex.assignment.model.UserProfileModel;

public interface UserProfileService {

	HashMap<String , Object> saveUserProfile(UserProfileModel userProfileModel);

	UserProfileModel fetchUserProfile(Long userProfileId, String fullName);

	boolean deleteUserProfile(Long userProfileId);
	

}
