package com.deuex.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deuex.assignment.model.UserProfileModel;

@Repository
public interface UserProfileDao extends JpaRepository<UserProfileModel, Long> {

	UserProfileModel findByUserProfileIdAndFullName(Long userProfileId, String fullName);

	Integer deleteByUserProfileId(Long userProfileId);

}
