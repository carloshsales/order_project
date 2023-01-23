package entities.interfaces;

import entities.OrderItem;

public interface IOrder {
	public void addItem(OrderItem item);
	public void removeItem(OrderItem item);
	public Double total();
}
