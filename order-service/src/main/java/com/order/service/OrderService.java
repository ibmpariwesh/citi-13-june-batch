package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.OrderRepositroy;
import com.order.OrderVO;

@Service       //Bean
public class OrderService {
	@Autowired
	OrderRepositroy orderRepositroy;
	public void saveOrder(OrderVO order) {
		orderRepositroy.save(order);
		System.out.println("in service");
	}
	public List<OrderVO> getOrders() {
		return orderRepositroy.findAll();
	}
}
