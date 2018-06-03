package com.analytics.statistics.dto;

import com.analytics.statistics.model.Statistics;

public class StatisticsDTO {

    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;
	
    public StatisticsDTO() {
	}
    
    public static StatisticsDTO convertToStatisticsDTO(Statistics statistics) {
    	StatisticsDTO statisticsDTO = new StatisticsDTO();
    	statisticsDTO.setAvg(statistics.getAvg());
    	statisticsDTO.setCount(statistics.getCount());
    	statisticsDTO.setMax(statistics.getMax());
    	statisticsDTO.setMin(statistics.getMin());
    	statisticsDTO.setSum(statistics.getSum());
    	return statisticsDTO;
    }

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
    
}