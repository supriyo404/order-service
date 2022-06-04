package com.api.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class OrderServiceApplicationTests {

	Logger logger = LoggerFactory.getLogger(OrderServiceApplicationTests.class);
	@Test
	public void contextLoads() {
		logger.info("Testing started..");
		assertEquals(true, true);
	}

}
