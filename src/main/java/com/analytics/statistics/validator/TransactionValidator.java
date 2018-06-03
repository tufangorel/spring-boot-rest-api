package com.analytics.statistics.validator;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.analytics.statistics.model.Transaction;

@Component
public class TransactionValidator {

	public boolean isValidTransaction( Transaction transaction ) {
		
		long now = System.currentTimeMillis();
		long transactionTime = transaction.getTime();
		long currentSeconds = TimeUnit.MILLISECONDS.toSeconds(now);
		long transactionSeconds = TimeUnit.MILLISECONDS.toSeconds(transactionTime);
		
		if( currentSeconds-transactionSeconds<60 ) {  // if it is not older than 60 seconds than store it.
	    	return true;
	    }
		return false;
	}
}
