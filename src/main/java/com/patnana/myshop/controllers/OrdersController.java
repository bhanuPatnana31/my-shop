package com.patnana.myshop.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patnana.myshop.Entities.Order;
import com.patnana.myshop.services.OrderService;

@RestController
@RequestMapping("orders")
public class OrdersController {

	private final OrderService orderService;
	
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		return this.orderService.saveOrder(order);
	}
	
	@GetMapping("/saveAll")
	public String saveOrders() throws InterruptedException, ExecutionException {
	//	return this.orderService.saveOrders();
		return this.orderService.updateOrderValues();
	}
	
	@GetMapping
	public List<Order> getOrders() {
		return this.orderService.getOrders();
	}
}
