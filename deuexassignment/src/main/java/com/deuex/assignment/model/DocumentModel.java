package com.deuex.assignment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "documents")
public class DocumentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id")
	private Long documentId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_profile_id")
	private UserProfileModel userProfileModel;
	
	@Column(name= "document_type")
	private String documentType;
	
	@Column(name = "document_url")
	private String docuemntUrl;
	
	@Column(name="created_date")
	private Date createdDate;
	
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public UserProfileModel getUserProfileModel() {
		return userProfileModel;
	}
	public void setUserProfileModel(UserProfileModel userProfileModel) {
		this.userProfileModel = userProfileModel;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocuemntUrl() {
		return docuemntUrl;
	}
	public void setDocuemntUrl(String docuemntUrl) {
		this.docuemntUrl = docuemntUrl;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "DocumentModel [documentId=" + documentId + ", userProfileModel=" + userProfileModel + ", documentType="
				+ documentType + ", docuemntUrl=" + docuemntUrl + ", createdDate=" + createdDate + "]";
	}

}
