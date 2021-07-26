package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	//getting all orders
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	//create order rest api
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	//get order by id using rest api
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderByID(@PathVariable int id){
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exists with id: "+id));
		return ResponseEntity.ok(order);
	}
	
	//update order by id using rest api
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable int id , @RequestBody Order orderDetails){
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exists with id: "+id));

		order.setOrderBuyer(orderDetails.getOrderBuyer());
		order.setOrderCode(orderDetails.getOrderCode());
		order.setOrderDescription(orderDetails.getOrderDescription());
		order.setOrderQuantity(orderDetails.getOrderQuantity());
		order.setOrderStyle(orderDetails.getOrderStyle());
		Order updatedOrder = orderRepository.save(order);
		return ResponseEntity.ok(updatedOrder);
	}
	
	//delete order rest api
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable int id){
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not exists with id: "+id));
		orderRepository.delete(order);
		Map<String , Boolean > response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}