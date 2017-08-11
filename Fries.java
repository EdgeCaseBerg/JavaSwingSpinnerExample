class Fries extends MenuItem {

	protected String size;

	public Fries(String size) {
		this.size = size;
		this.name = "Fries";
		this.price = 1.25;
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