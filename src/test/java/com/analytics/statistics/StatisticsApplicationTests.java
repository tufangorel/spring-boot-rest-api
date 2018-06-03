package com.analytics.statistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TransactionValidatorTest.class,
	TransactionServiceTest.class,
	StatisticsServiceTest.class
})
public class StatisticsApplicationTests {

	@Test
	public void contextLoads() {
	}

}