package com.analytics.statistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analytics.statistics.model.Transaction;
import com.analytics.statistics.util.StatisticsManager;
import com.analytics.statistics.validator.TransactionValidator;

@Service
public class TransactionService {

	@Autowired
	private TransactionValidator transactionValidator; 
	@Autowired
	private StatisticsManager statisticsManager; 
	
	public synchronized boolean addTransaction( Transaction transaction ) {
		
		if( transactionValidator.isValidTransaction(transaction) ) {
			return statisticsManager.addTransaction(transaction);
		}
	    
	    return false;
	}
}