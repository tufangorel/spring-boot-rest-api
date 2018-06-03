package com.analytics.statistics.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.analytics.statistics.dto.StatisticsDTO;
import com.analytics.statistics.model.Statistics;
import com.analytics.statistics.model.Transaction;
import com.analytics.statistics.validator.TransactionValidator;

@Component
public class StatisticsManager {

	@Autowired
	private TransactionValidator transactionValidator;

	private List<Transaction> transactions = new LinkedList<Transaction>();

	public synchronized StatisticsDTO getStatistics() {

		Statistics statistics = new Statistics(0, 0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0);

		if (!transactions.isEmpty()) {

			for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
				Transaction transaction = iterator.next();
				if (transactionValidator.isValidTransaction(transaction)) {

					double currentTransactionAmount = transaction.getAmount();
					long totalTransactionCount = statistics.getCount() + 1;
					double resultAverage = (statistics.getAvg() * statistics.getCount() + currentTransactionAmount)
							/ totalTransactionCount;
					double resultSum = statistics.getSum() + currentTransactionAmount;
					double resultMax = Math.max(statistics.getMax(), currentTransactionAmount);
					double resultMin = Math.min(statistics.getMin(), currentTransactionAmount);

					statistics = new Statistics(resultSum, resultAverage, resultMax, resultMin, totalTransactionCount);
				} else {
					iterator.remove();
				}
			}
		}

		return StatisticsDTO.convertToStatisticsDTO(statistics);
	}

	public synchronized boolean addTransaction(Transaction transaction) {
		return transactions.add(transaction);
	}
}