package com.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	@PostMapping("/new")
	public List<OrderVO> getOrders(@RequestBody String str) {
		System.out.println(str);
		return service.getOrders();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exception) {
		Map<String, String> messages = new HashMap<>();
		exception.getAllErrors().forEach(error ->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = ((FieldError)error).getDefaultMessage();
			messages.put(fieldName, errorMessage);
		});
		return messages;

	}
}
