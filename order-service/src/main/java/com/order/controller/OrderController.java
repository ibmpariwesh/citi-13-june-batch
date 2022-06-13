package com.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.OrderVO;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService service;   //depdendency injection
	
	@PostMapping
	public void createOrder(@Valid @RequestBody OrderVO order) {
		service.saveOrder(order);
		System.out.println(order.getItem());
	}
	@GetMapping
	public List<OrderVO> getOrders() {
		return service.getOrders();
	}
}
