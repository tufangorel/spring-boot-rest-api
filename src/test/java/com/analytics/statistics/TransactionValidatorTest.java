package com.analytics.statistics;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.analytics.statistics.model.Transaction;
import com.analytics.statistics.validator.TransactionValidator;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionValidatorTest {

	@InjectMocks
	private TransactionValidator transactionValidator;
	
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void testIsValidTransaction() {
		
		Transaction transaction1 = new Transaction();
		double amount1 = 12.2;
		long time1 = Instant.now().toEpochMilli();
		transaction1.setAmount(amount1);
		transaction1.setTime(time1);
		
		Transaction transaction2 = new Transaction();
		double amount2 = 12.2;
		long time2 = Instant.now().minusSeconds(61).toEpochMilli();
		transaction2.setAmount(amount2);
		transaction2.setTime(time2);
		
		boolean result1 = transactionValidator.isValidTransaction(transaction1);
		boolean result2 = transactionValidator.isValidTransaction(transaction2);
		
		Assert.assertTrue(result1);
		Assert.assertFalse(result2);
	}
	
}