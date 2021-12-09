package vendingmachine.model;

public class Item {
	private final String name;
	private final int price;
	private int quantity;

	private Item(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public static Item of(String name, int price, int quantity) {
		return new Item(name, price, quantity);
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			", quantity=" + quantity +
			'}';
	}
}