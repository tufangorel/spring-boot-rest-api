package com.analytics.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.statistics.dto.TransactionDTO;
import com.analytics.statistics.service.TransactionService;

@RestController
public class TransactionsController {

	@Autowired
	private TransactionService transactionService;
	
    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public ResponseEntity<TransactionDTO> transactions( @RequestBody TransactionDTO transactionDTO ) {
    	try {
    		boolean succes = transactionService.addTransaction( TransactionDTO.convertToTransaction(transactionDTO) );
    		if( succes )
    			return new ResponseEntity<TransactionDTO>(HttpStatus.CREATED);
    		else
    			return new ResponseEntity<TransactionDTO>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<TransactionDTO>(HttpStatus.NO_CONTENT);
		}
    }
    
}