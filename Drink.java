class Drink extends MenuItem {

	protected String size;

	public Drink(String size) {
		this.size = size;
		this.name = "Soft Drink";
		if (size.equalsIgnoreCase("small")) {
			this.price = 1.25;
		} else if (size.equalsIgnoreCase("medium")) {
			this.price = 1.50;
		} else {
			this.price = 1.75;
		}
	}

	@Override
	public String getReceiptString() {
		String receiptString = "";
		receiptString += name;
		receiptString += "\n\t" + size;
		receiptString += "\n\t\t" + price;
		return receiptString;
	}
}