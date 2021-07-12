package com.deuex.assignment.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deuex.assignment.dao.ProofDocumentDao;
import com.deuex.assignment.model.ProofDocumentModel;
import com.deuex.assignment.service.ProofDocumentService;


@Service
public class ProofDocumentServiceImpl implements ProofDocumentService{

	Logger logger = LoggerFactory.getLogger(ProofDocumentServiceImpl.class);
	
	@Autowired
	ProofDocumentDao proofDocumentDao;
	
	@Override
	public HashMap<String, Object> fetchProofDocumentList() {
		logger.info(":::: ProofDocumentServiceImpl ::::: || ::::: fetchProofDocumentList ::::: ");
		
		HashMap<String, Object> map = new HashMap<>();
		try {
		List<ProofDocumentModel> proofDocumentList = proofDocumentDao.findAll();	
		map.put("proofDocumentList", proofDocumentList);
		return map;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
