package entities;

import entities.interfaces.IOrderItem;

public class OrderItem implements IOrderItem{
	private Integer quantity;
	private Double price;
	
	private Product item;
	
	public OrderItem() {}
	public OrderItem(Integer quantity, Double price, Product item) {
		this.quantity = quantity;
		this.price = price;
		this.item = item;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = item.getPrice();
	}
	
	public Product getItem() {
		return item;
	}
	
	public void setItem(Product item) {
		this.item = item;
	}
	
	public Double subTotal() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(item.toString() + ", ");
		stringBuilder.append("Quantity: " + getQuantity() + ", ");
		stringBuilder.append("Subtotal: " + subTotal());
		
		return stringBuilder.toString();
	}
}
























