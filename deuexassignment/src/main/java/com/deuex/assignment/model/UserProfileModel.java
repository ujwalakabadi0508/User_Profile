package com.deuex.assignment.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user_profile")
public class UserProfileModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_profile_id")
	private Long userProfileId;
	
	@NotNull
	@Column(name ="full_name")
	private String fullName;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Column(name = "mobile_no" )
	private String mobileNo;
	
	@Column(name= "address")
	private String address;
	
	@OneToOne(mappedBy = "userProfileModel", cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	private DocumentModel documents;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdTime;

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public DocumentModel getDocuments() {
		return documents;
	}

	public void setDocuments(DocumentModel documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "UserProfileModel [userProfileId=" + userProfileId + ", fullName=" + fullName + ", email=" + email
				+ ", gender=" + gender + ", location=" + location + ", mobileNo=" + mobileNo + ", address=" + address
				+ ", createdTime=" + createdTime + "]";
	}
	
}
