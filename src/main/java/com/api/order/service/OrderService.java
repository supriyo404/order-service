package com.api.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.api.order.common.Payment;
import com.api.order.common.TransactionRequest;
import com.api.order.common.TransactionResponse;
import com.api.order.entity.Order;
import com.api.order.exception.PaymentFailedException;
import com.api.order.repository.OrderRepository;

@Service
public class OrderService {
	
	private String paymentState;
	@Autowired
	private OrderRepository orderrepo;
	@Autowired
	private RestTemplate template;
	
	Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	@Transactional
	public TransactionResponse saveOrder(TransactionRequest txrequest) {
		//add order id and order amount from transaction to payment object
		Order order = orderrepo.save(txrequest.getOrder());
		Payment payment = txrequest.getPayment();
		
		
		payment.setAmount(order.getPrice());
		payment.setOrderId(order.getId());
		
		
		//rest call to payment
		//Set timeouts to avoid delay
		
	
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/api/payment/doPay", payment,Payment.class);
		
		paymentState = paymentResponse.getPaymentStatus().equals("Success")?"Payment processed successfully":"Payment Processing Failed";
		
		logger.debug("API is being called and the Payment state is : {}",paymentState);
		
		if(paymentResponse.getPaymentStatus().equals("Failed")) {
			throw new PaymentFailedException(paymentState);
		}
		
		
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),paymentState) ;
	}
	

}
