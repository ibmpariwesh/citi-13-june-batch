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
	RestTemplate template;
	@Autowired
	OrderRepositroy orderRepositroy;
	public void saveOrder(OrderVO order) {
		orderRepositroy.save(order);
		ResponseEntity<String> response = template.getForEntity("http://EMAIL-SERVICE/email",
				String.class);
		System.out.println(response.getBody());
		System.out.println("in service");
	}
	public List<OrderVO> getOrders() {
		return orderRepositroy.findAll();
	}
}
