package com.analytics.statistics.dto;

import com.analytics.statistics.model.Transaction;

public class TransactionDTO {

	private double amount;
	private long timestamp;
	
	public TransactionDTO() {
	}

	public static Transaction convertToTransaction( TransactionDTO transactionDTO ) {
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setTime(transactionDTO.getTimestamp());
		return transaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public TransactionDTO(double amount) {
		super();
		this.amount = amount;
	}
	
}