package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class Item1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long orderId;
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long id) {
        this.orderId = id;
    }
    private String order_item_name;
    private long order_item_qty;
    private long orderId1;


    public Item1() {

    }

    /*public Item1(String order_item_name, long order_item_qty, Order1 order) {
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
        this.order = order;
    }*/

    public Item1(String order_item_name, long order_item_qty) {
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
        //this.order = order;
    }



    @Column(name = "order_item_name", nullable = false)
    public String getOrder_item_name() {
        return order_item_name;
    }
    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    @Column(name = "order_id1", nullable = false)
    public long getOrderId1() {
        return orderId1;
    }
    public void setOrderId1(long orderId) {
        this.orderId1 = orderId;
    }


    @Column(name = "order_item_qty", nullable = false)
    public long getOrder_item_qty() {
        return order_item_qty;
    }
    public void setOrder_item_qty(long order_item_qty) {
        this.order_item_qty = order_item_qty;
    }

    /*public Order1 getOrder1() {
        return order;
    }

    public void setOrder1(Order1 order) {
        this.order = order;
    }*/

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "order_id")
    //@JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    //public Order1 order;
    @Override
    public String toString() {
        return "Employee [orderId=" + orderId + ", orderItemName=" + order_item_name + ", orderItemQuantity=" + order_item_qty+" ]";
    }

}



