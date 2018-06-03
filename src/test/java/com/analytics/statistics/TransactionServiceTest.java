package com.analytics.statistics;

import static org.mockito.Mockito.when;

import java.time.Instant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.analytics.statistics.model.Transaction;
import com.analytics.statistics.service.TransactionService;
import com.analytics.statistics.util.StatisticsManager;
import com.analytics.statistics.validator.TransactionValidator;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionServiceTest {

	@InjectMocks
	private TransactionService transactionService;
	
	@Mock
	private TransactionValidator transactionValidator;
	
	@Mock
	private StatisticsManager statisticsManager;
	
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void testAddTransaction() {
		
		Transaction transaction1 = new Transaction();
		double amount1 = 12.2;
		long time1 = Instant.now().toEpochMilli();
		transaction1.setAmount(amount1);
		transaction1.setTime(time1);
    	when(transactionValidator.isValidTransaction(transaction1)).thenReturn(true);
    	when(statisticsManager.addTransaction(transaction1)).thenReturn(true);
    	
		Transaction transaction2 = new Transaction();
		double amount2 = 12.2;
		long time2 = Instant.now().minusSeconds(61).toEpochMilli();
		transaction2.setAmount(amount2);
		transaction2.setTime(time2);
		when(transactionValidator.isValidTransaction(transaction2)).thenReturn(false);
		when(statisticsManager.addTransaction(transaction2)).thenReturn(false);
		
		boolean addedTransaction1 = transactionService.addTransaction(transaction1);
		boolean addedTransaction2 = transactionService.addTransaction(transaction2);

		Assert.assertTrue(addedTransaction1);
		Assert.assertFalse(addedTransaction2);
	}
    
}
