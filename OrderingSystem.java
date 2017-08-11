import java.util.ArrayList;

class OrderingSystem {
	
	private double taxRate;

	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	public OrderingSystem(double taxRate) {
		this.taxRate = taxRate;
	}

	public void addMenuItem(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	public double computeTotal() {
		double total = 0.0;
		for (int i =0; i < menuItems.size(); i++) {
			total += menuItems.get(i).getPrice();
		}
		return total + (total * taxRate);
	}

	public void clearOrder() {
		menuItems.clear();
	}

	public String getReceipt() {
		String receipt = "Your Order\n";
		double total = computeTotal();
		MenuItem item = null;

		for (int i = 0; i < menuItems.size(); i++) {
			item = menuItems.get(i);
			receipt += item.getReceiptString() + "\n";
		}
		receipt += "\nTotal\t\t" + total;
		return receipt;
	}
}