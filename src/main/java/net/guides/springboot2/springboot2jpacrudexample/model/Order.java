package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.*;


@Entity
@Table(name = "order_details1")
public class Order {

	private long orderId;
	private String orderStatus;
	private long orderCustomerId;

	public Order() {

	}

	public Order(String orderStatus, long orderCustomerId) {
		this.orderStatus = orderStatus;
		this.orderCustomerId = orderCustomerId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long id) {
		this.orderId = id;
	}

	@Column(name = "order_status", nullable = false)
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "order_customer_id", nullable = false)
	public long getOrderCustomerId() {
		return orderCustomerId;
	}
	public void setOrderCustomerId(long orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}


	@Override
	public String toString() {
		return "Employee [orderId=" + orderId + ", orderItemName=" + orderStatus + ", orderCustomerId=" + orderCustomerId+" ]";
	}

}
