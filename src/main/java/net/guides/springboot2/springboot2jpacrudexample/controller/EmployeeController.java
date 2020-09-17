package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
public class EmployeeController {
	//@Autowired
	//private EmployeeRepository employeeRepository;
	//@Autowired
	//private OrderRepository orderItemRepository;
	@Autowired
	private Order1Repository order1Repository;
	@Autowired
	private Item1Repository item1Repository;
	/*@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}*/
	/*@GetMapping("/employees")
	public List<Order> getAllEmployees() {
		return employeeRepository.findAll();
	}*/


	/*@GetMapping("/employees/{id}")
	public ResponseEntity<FullOrder> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Order order = employeeRepository.findById(employeeId)

				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		List<Long> l = new ArrayList<Long>() ;

		l.add(25L);
		List<OrderItem> orderItem = orderItemRepository.findAllById(l);
		System.out.println(orderItem);
		FullOrder fullOrder = new FullOrder();
		fullOrder.orderCustomerId = order.getOrderCustomerId();
		fullOrder.orderStatus = order.getOrderStatus();
		//fullOrder.items.append
		return ResponseEntity.ok().body(fullOrder);
	}*/
	/*@GetMapping("/employees/{id}")
	public ResponseEntity<Order> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Order employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}*/

	/*@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		//return employeeRepository.save(employee);
		Order o = new Order("11", 23);
		return employeeRepository.save(o);
		//return employeeRepository.save(employee);
	}*/
	/*@PostMapping("/employees")
	public Order createEmployee(@Valid @RequestBody Order order) {
		//return employeeRepository.save(employee);
		System.out.print("Reached");
		//Order o = new Order("11", 23);
		OrderItem o = new OrderItem("i1", 23);
		orderItemRepository.save(o);
		return employeeRepository.save(order);
	}*/

	/*@PostMapping("/employees")
	public Order createEmployee(@Valid @RequestBody FullOrder fullOrder) {
		//return employeeRepository.save(employee);
		System.out.print("Reached");
		System.out.print(fullOrder);
		Order o1 = new Order(fullOrder.orderStatus, fullOrder.orderCustomerId);
		//Order o1 = new Order("11", 23);
		employeeRepository.save(o1);
		//OrderItem o = new OrderItem("11", 23);
		for(Item i :fullOrder.items)
		{
			OrderItem o2 = new OrderItem(i.order_item_name, i.order_item_qty);
			//orderItemRepository.save(o);
			orderItemRepository.save(o2);
		}
		//OrderItem o2 = new OrderItem("i1", 23);
		//orderItemRepository.save(o);
		//orderItemRepository.save(o2);
		System.out.print("End");
		return null;
	}*/
	@PostMapping("/employees")
	public Order createEmployee(@Valid @RequestBody FullOrder fullOrder) {
		//return employeeRepository.save(employee);
		System.out.print("Reached");
		/*System.out.print(fullOrder);
		Order o1 = new Order(fullOrder.orderStatus, fullOrder.orderCustomerId);
		//Order o1 = new Order("11", 23);
		employeeRepository.save(o1);
		//OrderItem o = new OrderItem("11", 23);
		for(Item i :fullOrder.items)
		{
			OrderItem o2 = new OrderItem(i.order_item_name, i.order_item_qty);
			//orderItemRepository.save(o);
			orderItemRepository.save(o2);
		}
		//OrderItem o2 = new OrderItem("i1", 23);
		//orderItemRepository.save(o);
		//orderItemRepository.save(o2);
		System.out.print("End");*/
		/*Order1 o = new Order1();
		//o.setOrderId(2);
		//o.setOrderId(123);
		//o.orderId = 21;
		o.setOrderCustomerId(123);
		o.setOrderStatus("1");

		//o.items.add(new Item1("vegetables", 23));
		//o.items.add(new Item1("fruits", 30));
		Item1 i1 = new Item1("fruits", 30);
		Item1 i2 = new Item1("vegies", 20);

		//i.setOrder1(o);
		i1.order = o;
		i2.order = o;
		order1Repository.save(o);
		item1Repository.save(i1);
		item1Repository.save(i2);*/

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



		return null;
	}
	/*public OrderItem createEmployee(@Valid @RequestBody OrderItem order) {
		//return employeeRepository.save(employee);
		System.out.print("Reached");
		//Order o = new Order("11", 23);
		//return employeeRepository.save(o);
		return employeeRepository.save(order);
	}*/



	/*@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
													   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setOrderItemName(employeeDetails.getOrderItemName());
		employee.setOrderItemQuantity(employeeDetails.getOrderItemQuantity());
		//employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}*/
	/*@PutMapping("/employees/{id}")
	public ResponseEntity<Order> updateEmployee(@PathVariable(value = "id") Long employeeId,
												   @Valid @RequestBody Order employeeDetails) throws ResourceNotFoundException {
		Order employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setOrderStatus(employeeDetails.getOrderStatus());
		employee.setOrderCustomerId(employeeDetails.getOrderCustomerId());
		//employee.setFirstName(employeeDetails.getFirstName());
		final Order updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}*/


	/*@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
	/*@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Order employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}*/
}
