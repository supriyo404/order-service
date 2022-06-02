package com.api.order.common;



public class Payment {
	
	private int paymentId;
	private String paymentStatus;
	private String transactionId;
	private int orderId;
	private double amount;

	public Payment(int paymentId, String paymentStatus, String transactionId, int orderId, double amount) {
		super();
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.amount = amount;
	}
 
	public Payment() {
		super();
	}

	public int getPaymentId() {
		return paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	

}
