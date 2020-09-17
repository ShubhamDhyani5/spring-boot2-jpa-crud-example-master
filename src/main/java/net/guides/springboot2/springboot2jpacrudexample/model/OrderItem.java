package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.*;

@Entity
@Table(name = "order_items1")
public class OrderItem {

    private long orderId;
    private String order_item_name;
    private long order_item_qty;

    public OrderItem() {

    }

    public OrderItem(String order_item_name, long order_item_qty) {
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long id) {
        this.orderId = id;
    }

    @Column(name = "order_item_name", nullable = false)
    public String getOrder_item_name() {
        return order_item_name;
    }
    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    @Column(name = "order_item_qty", nullable = false)
    public long getOrder_item_qty() {
        return order_item_qty;
    }
    public void setOrder_item_qty(long order_item_qty) {
        this.order_item_qty = order_item_qty;
    }


    @Override
    public String toString() {
        return "Employee [orderId=" + orderId + ", orderItemName=" + order_item_name + ", orderItemQuantity=" + order_item_qty+" ]";
    }

}



