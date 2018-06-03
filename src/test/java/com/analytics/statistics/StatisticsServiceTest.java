package com.analytics.statistics;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.analytics.statistics.dto.StatisticsDTO;
import com.analytics.statistics.model.Transaction;
import com.analytics.statistics.service.StatisticsService;
import com.analytics.statistics.service.TransactionService;
import com.analytics.statistics.util.StatisticsManager;
import com.analytics.statistics.validator.TransactionValidator;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsServiceTest {

	@InjectMocks
	private StatisticsService statisticsService;
	
	@Mock
	private TransactionService transactionService;
	@Mock
	private TransactionValidator transactionValidator;
	@Mock
	private StatisticsManager statisticsManager;
	
	@Test
	public void testGetStatistics() {
		
		Transaction transaction1 = new Transaction();
		double amount1 = 12.2;
		long time1 = Instant.now().toEpochMilli();
		transaction1.setAmount(amount1);
		transaction1.setTime(time1);
		
		StatisticsDTO statisticsDTO = new StatisticsDTO();
		statisticsDTO.setAvg(amount1);
		statisticsDTO.setCount(1);
		statisticsDTO.setMax(amount1);
		statisticsDTO.setMin(amount1);
		statisticsDTO.setSum(amount1);
		
		when(statisticsManager.getStatistics()).thenReturn(statisticsDTO);
		
		StatisticsDTO statisticsDTOResult = statisticsService.getStatistics();
		assertThat(statisticsDTO.getAvg(), is(statisticsDTOResult.getAvg()));
		assertThat(statisticsDTO.getCount(), is(statisticsDTOResult.getCount()));
		assertThat(statisticsDTO.getMax(), is(statisticsDTOResult.getMax()));
		assertThat(statisticsDTO.getMin(), is(statisticsDTOResult.getMin()));
		assertThat(statisticsDTO.getSum(), is(statisticsDTOResult.getSum()));
		
	}
	
}
