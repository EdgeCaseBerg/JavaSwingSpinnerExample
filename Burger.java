class Burger extends MenuItem {

	protected boolean hasCheese;

	public Burger(boolean hasCheese) {
		if (hasCheese) {
			this.price = 2.50;
		} else {
			this.price = 2.00;
		}
		this.hasCheese = hasCheese;
		this.name = "Burger";
	}

	@Override
	public String getReceiptString() {
		String receiptString = "";
		receiptString += name;
		if (hasCheese) {
			receiptString += "\n\twith Cheese";
		}
		receiptString += "\n\t\t" + price;
		return receiptString;
	}
}