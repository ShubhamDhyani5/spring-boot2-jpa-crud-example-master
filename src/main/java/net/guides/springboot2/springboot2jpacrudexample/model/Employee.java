package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "")
public class Employee {

	private long orderId;
	private String orderItemName;
	private long orderItemQuantity;

	public Employee() {

	}

	public Employee(String orderItemName, long orderItemQuantity) {
		this.orderItemName = orderItemName;
		this.orderItemQuantity = orderItemQuantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long id) {
		this.orderId = id;
	}

	@Column(name = "order_Item_Name", nullable = false)
	public String getOrderItemName() {
		return orderItemName;
	}
	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}

	@Column(name = "order_Item_Quantity", nullable = false)
	public long getOrderItemQuantity() {
		return orderItemQuantity;
	}
	public void setOrderItemQuantity(long orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}


	@Override
	public String toString() {
		return "Employee [orderId=" + orderId + ", orderItemName=" + orderItemName + ", orderItemQuantity=" + orderItemQuantity+" ]";
	}

}
