package com.analytics.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.statistics.dto.StatisticsDTO;
import com.analytics.statistics.service.StatisticsService;

@RestController
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;
	
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ResponseEntity<StatisticsDTO> statistics() {
    	StatisticsDTO statisticsDTO = statisticsService.getStatistics();
    	return new ResponseEntity<StatisticsDTO>(statisticsDTO, HttpStatus.OK);
    }
    
}