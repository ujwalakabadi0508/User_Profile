package com.deuex.assignment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "proof_document_master")
public class ProofDocumentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proof_document_id")
	private Long ProofDocumentId;
	
	@Column(name="proof_document_name")
	private String proofDocumentName;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdTime;

	public Long getProofDocumentId() {
		return ProofDocumentId;
	}

	public void setProofDocumentId(Long proofDocumentId) {
		ProofDocumentId = proofDocumentId;
	}

	public String getProofDocumentName() {
		return proofDocumentName;
	}

	public void setProofDocumentName(String proofDocumentName) {
		this.proofDocumentName = proofDocumentName;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	
}
