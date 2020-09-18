package net.guides.springboot2.springboot2jpacrudexample.model;

public class Item {
    //TODO: Change to private and add getter methods
    public String order_item_name;
    public long order_item_qty;
    public Item(String order_item_name, long order_item_qty)
    {
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
    }

}
