package com.analytics.statistics.model;

public class Transaction implements Comparable<Transaction> {

	private double amount;
	private long time;

	public Transaction() {
	}

	public Transaction(double amount, long time) {
		this.amount = amount;
		this.time = time;
	}

	@Override
	public int compareTo(Transaction transaction) {
		if (time > transaction.getTime()) {
			return 1;
		} else if (time < transaction.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}