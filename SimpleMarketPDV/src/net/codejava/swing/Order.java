package net.codejava.swing;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItems;
	private double subTotal;
	public double paymentValue;
	private double change;
	public OrderItem orderItemCandidate;
	
	public Order() {
		this.orderItems = new ArrayList<OrderItem>();
		this.subTotal = 0;
		this.paymentValue = 0;
		this.change = 0;		
	}
	
	public void setOrderItemCandidate(Product product) {
		this.orderItemCandidate = new OrderItem(product);
	}
	
	public void addOrderItem(OrderItem itemToAdd) throws Exception {
		if(itemToAdd.product.qtdStock > 0) {
			ResponseData response = GetOrderItemById(itemToAdd.product.id);
			
			if(response.isValid) {
				OrderItem item = ((OrderItem) response.obj);				
				item.changeQtd();
			}else {
				this.orderItems.add(itemToAdd);
			}
			
			this.setSubtotal();
		}else {
			throw new Exception();
		}			
	}
	
	public ArrayList<OrderItem> getOrderItems() {
		return this.orderItems;
	}
	
	public ResponseData GetOrderItemById(int id) {
		
		ResponseData response = new ResponseData(null, false);
		
		for (int i = 0; i < this.orderItems.size(); i++) {
			OrderItem orderItem = this.orderItems.get(i);
			
			if(orderItem.product.id == id) {
				response.obj = orderItem;
				response.isValid = true;				
			}
		}
		
		return response;
	}
	
	private void setSubtotal() {		
		Double total = 0.0;
		for (OrderItem orderItem : orderItems) {
			total += orderItem.total;
		}
		
		this.subTotal = total;
	}
	
	public double getSubtotal() {		
		return this.subTotal;
	}
	
	public void setChange() throws Exception {	
		if(this.paymentValue < this.subTotal) {
			throw new Exception();
		}else {
			this.change = this.paymentValue - this.subTotal;
		}		
	}
	
	public double getChange() {		
		return this.change;
	}
}
