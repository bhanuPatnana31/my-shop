package com.patnana.myshop.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.patnana.myshop.Entities.Order;
import com.patnana.myshop.Repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order saveOrder(Order order) {
		return this.orderRepository.save(order);
	}
	
	public String saveOrders() throws InterruptedException, ExecutionException {
		List<Order> ordersList = new ArrayList<Order>();
		Random randomRange0to1000 = new Random();
		CompletableFuture<Order> orderFuture = null;
		for(int i=0; i<1000; i++) {
			LocalDateTime dateTime = LocalDateTime.now();
			
			Order order = new Order();
			order.setOrderDesc("item name "+i);
			order.setOrderTime(dateTime);
			//order.setOrderValue((float) randomRange0to1000.nextInt(10000));
			
			System.out.println("Order "+order.toString());
			
			orderFuture = this.updateOrders(order);
						
			//ordersList.add(order);
			//this.orderRepository.save(order);
		}
		//this.orderRepository.saveAll(ordersList);
		System.out.println(orderFuture.get().getOrderDesc()+" Updated successfully");
		return "Orders successfully saved";
	}
	public List<Order> getOrders() {
		
		return this.orderRepository.findAll();
	}
	
	public String updateOrderValues() throws InterruptedException, ExecutionException {
		
		List<Order> ordersList = this.orderRepository.findAll();
		System.out.println("Orders List "+ordersList.toString());
		CompletableFuture<Order> orderFuture = null;
		for(int i=0; i<ordersList.size(); i++) {
			
			orderFuture = this.updateValueAsync(ordersList, i);

		}
		System.out.println(orderFuture.get().getOrderId()+" Updated successfully");
		return null;
		
	}
	
	
	@Async("taskExecutor")
	public CompletableFuture<Order> updateOrders(Order order) {
		System.out.println("Updating order: "+order.getOrderDesc());
		this.orderRepository.save(order);
		return CompletableFuture.completedFuture(order);
	}
	
	@Async("taskExecutor")
	public CompletableFuture<Order> updateValueAsync(List<Order> ordersList, Integer i) {
	
		Optional<Order> order = this.orderRepository.findById(ordersList.get(i).getOrderId());
		System.out.println("Updating Order "+order.get().toString());
		Random randomRange0to1000 = new Random();
		order.get().setOrderValue((float) randomRange0to1000.nextInt(10000));
		Order ord = this.orderRepository.save(order.get());
	//	int ord = this.orderRepository.updateOrderValueById((float) randomRange0to1000.nextInt(10000), order.get().getOrderId());
		return CompletableFuture.completedFuture(ord);
		
	}
}
	