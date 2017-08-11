abstract class MenuItem {
	protected String name;
	protected double price;

	public double getPrice() {
		return price;
	}

	public abstract String getReceiptString();
}