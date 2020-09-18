package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.bytebuddy.matcher.FilterableList;
import net.guides.springboot2.springboot2jpacrudexample.model.*;
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

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.OrderItem;

import net.guides.springboot2.springboot2jpacrudexample.model.Item1;

import net.guides.springboot2.springboot2jpacrudexample.model.Order1;

import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.OrderRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.Order1Repository;

import net.guides.springboot2.springboot2jpacrudexample.repository.Item1Repository;


@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private Order1Repository order1Repository;
	@Autowired
	private Item1Repository item1Repository;



	@GetMapping("/order/{id}")
	public ResponseEntity<FullOrder> getOrderById(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Order1 order = order1Repository.findById(orderId)

				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		List<Long> l = new ArrayList<Long>() ;

		FullOrder fullOrder = new FullOrder();
		fullOrder.orderCustomerId = order.getOrderCustomerId();
		fullOrder.orderStatus = order.getOrderStatus();
		List<Item1> items = item1Repository.find(orderId);
		System.out.print("Reached" + items.size());
		List<Item> newItems = new ArrayList<Item>();
		for(Item1 item : items)
		{
			Item i = new Item(item.getOrder_item_name(), item.getOrder_item_qty());
			//fullOrder.items.add(i);
			newItems.add(i);
		}
		//fullOrder.items.append
		fullOrder.items = newItems;
		return ResponseEntity.ok().body(fullOrder);


	}

	@PostMapping("/order")
	public Order1 createOrder(@Valid @RequestBody FullOrder fullOrder) {

		Order1 o1 = new Order1(fullOrder.orderStatus, fullOrder.orderCustomerId);
		order1Repository.save(o1);
		for(Item i :fullOrder.items)
		{
			//Item1 it = new Item1(i.order_item_name, i.order_item_qty, o1);
			Item1 it = new Item1(i.order_item_name, i.order_item_qty);
			System.out.print(o1.getOrderId());

			it.setOrderId1(o1.getOrderId());
			//it.order = o1;
			item1Repository.save(it);
		}

		return o1;
	}

	@DeleteMapping("/order/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {



		List<Item1> items = item1Repository.find(orderId);

		for(Item1 item : items)
		{
			item1Repository.delete(item);
		}

		Order1 order = order1Repository.findById(orderId)

				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		order1Repository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;


	}

	@PutMapping("/order/{id}")
	public ResponseEntity<Order1> updateOrder(@PathVariable(value = "id") Long orderId,
												   @Valid @RequestBody FullOrder fullOrder) throws ResourceNotFoundException {
		System.out.print("F");
		Order1 order = order1Repository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

		order.setOrderStatus(fullOrder.orderStatus);
		order.setOrderCustomerId(fullOrder.orderCustomerId);

		Order1 updatedOrder = order1Repository.save(order);
		return ResponseEntity.ok(updatedOrder);


	}

}
