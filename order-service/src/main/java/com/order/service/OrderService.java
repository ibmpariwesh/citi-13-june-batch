package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.OrderRepositroy;
import com.order.OrderVO;

@Service       //Bean
public class OrderService {
	@Autowired
	OrderRepositroy orderRepositroy;
	@Autowired
	RestTemplate template;
	public void saveOrder(OrderVO order) {
		ResponseEntity<String> response = template.getForEntity("http://EMAIL/email", String.class);
		System.out.println(response.getBody());
		orderRepositroy.save(order);
		System.out.println("in service");
	}
	public List<OrderVO> getOrders() {//will not work with json
		
		return orderRepositroy.findAll();
	}
}
