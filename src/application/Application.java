package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Application {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter client data: \n");
		
		System.out.println("Name: ");
		String clientName = scanner.nextLine();
		
		System.out.println("Email: ");
		String clientEmail = scanner.next();
		
		System.out.println("Birth date: ");
		Date clientBirthDate = dateFormat.parse(scanner.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		Order order = new Order(new Date(), OrderStatus.PROCESSING, client);
		
		System.out.println("How many items to this order? ");
		
		int numberOfItems = scanner.nextInt();
		String nameItem;
		Double priceItem;
		Integer quantityItem;
		
		for(int i = 1; i <= numberOfItems; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.println("Name: ");
			nameItem = scanner.next();
			
			System.out.println("Price: ");
			priceItem = scanner.nextDouble();
			
			System.out.println("Quantity: ");
			quantityItem = scanner.nextInt();
			
			order.addItem(new OrderItem(quantityItem, priceItem, new Product(nameItem, priceItem)));
		}
		
		System.out.println(order.toString());
		
		scanner.close();
	}

}
