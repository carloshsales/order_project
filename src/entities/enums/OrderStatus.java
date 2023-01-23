package entities.enums;

public enum OrderStatus {
	PENDING_PAYMENT (0),
	PROCESSING (1),
	SHIPPED (2),
	DELIVERED (3);
	
	public int statusValue;
	OrderStatus(int value){
		this.statusValue = value;
	}
}
