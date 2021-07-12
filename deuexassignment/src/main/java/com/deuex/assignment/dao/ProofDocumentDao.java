package com.deuex.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deuex.assignment.model.ProofDocumentModel;

@Repository
public interface ProofDocumentDao extends JpaRepository<ProofDocumentModel, Long> {

}
