package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;
import entities.interfaces.IOrder;


public class Order implements IOrder{
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order() {}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public void addItem(OrderItem item) {
		items.add(item);
	}

	@Override
	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	@Override
	public Double total() {
		Double total = 0.0;
		
		for(OrderItem item : items) {
			total += item.subTotal();
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("ORDER SUMARY:\n");
		stringBuilder.append("Order moment: " + dateFormat.format(moment) + "\n");
		stringBuilder.append("Order status: " + status + "\n");
		stringBuilder.append("Client: " + this.getClient().toString());
		
		stringBuilder.append("\n Order items: \n");
		
		for(OrderItem item : items) {
			stringBuilder.append(item.toString()+ "\n");
		}
		
		stringBuilder.append("\nTotal price: $" + total());
		
		return stringBuilder.toString();
	}
	
}
