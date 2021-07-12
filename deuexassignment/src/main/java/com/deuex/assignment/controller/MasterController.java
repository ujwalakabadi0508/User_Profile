package com.deuex.assignment.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deuex.assignment.common.MessageConstants;
import com.deuex.assignment.common.ResponseModel;
import com.deuex.assignment.service.ProofDocumentService;

@RestController
public class MasterController {
	
	Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	@Autowired
	ProofDocumentService proofDocumentsService;
	
	@RequestMapping(value = "/proofDocumentList", method = RequestMethod.GET)
	public ResponseEntity<ResponseModel> fetchProofDocument() {
		
		logger.info(":::: MasterController :::: || :::: fetchProofDocument :::: ");
		
		ResponseModel responseModel = new ResponseModel();
		HashMap<String,Object> map = proofDocumentsService.fetchProofDocumentList();
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


}
