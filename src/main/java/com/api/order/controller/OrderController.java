package com.api.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.order.common.TransactionRequest;
import com.api.order.common.TransactionResponse;
import com.api.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	private String test = "2220";
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/saveorder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionreq) {
		
		logger.info("transaction started for conreoller saveoreder {}",test);
		return orderservice.saveOrder(transactionreq);
		
	}

}
