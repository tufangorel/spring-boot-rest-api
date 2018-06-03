package com.analytics.statistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analytics.statistics.dto.StatisticsDTO;
import com.analytics.statistics.util.StatisticsManager;

@Service
public class StatisticsService {

	@Autowired
	private StatisticsManager statisticsManager;
	
	public StatisticsDTO getStatistics() {
		return statisticsManager.getStatistics();
	}
	
}