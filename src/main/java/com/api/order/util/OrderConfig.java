package com.api.order.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		//use timeouts
		HttpComponentsClientHttpRequestFactory httpcomp = new HttpComponentsClientHttpRequestFactory();
		httpcomp.setConnectTimeout(3000);
		return new RestTemplate(httpcomp);
	}

}
