package com.api.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PaymentFailedException.class)
	public ResponseEntity<?> handelPaymentFailedException(PaymentFailedException paymentfailedexp, WebRequest request) {

		return new ResponseEntity(paymentfailedexp.getMessage(), HttpStatus.OK);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handelException(Exception exp, WebRequest request) {

		return new ResponseEntity(exp.getMessage(), HttpStatus.BAD_REQUEST);

	}

}
