package com.api.order.common;

import com.api.order.entity.Order;

public class TransactionResponse {

	private Order order;
	private double amount;
	private String transactionId;
	private String paymentState;

	public TransactionResponse() {
		super();
	}

	public TransactionResponse(Order order, double amount, String transactionId, String paymentState) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.paymentState = paymentState;
	}
	
	

	public String getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
