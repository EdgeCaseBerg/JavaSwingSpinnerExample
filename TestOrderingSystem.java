class TestOrderingSystem {
	public static void main(String[] args) {
		OrderingSystem orderingSystem = new OrderingSystem(0.10);
		Fries fries = new Fries("small");
		Drink drink = new Drink("large");
		Burger cheeseBurger = new Burger(true);
		Burger burger = new Burger(false);
		orderingSystem.addMenuItem(fries);
		orderingSystem.addMenuItem(drink);
		orderingSystem.addMenuItem(cheeseBurger);
		orderingSystem.addMenuItem(burger);
		System.out.println(orderingSystem.getReceipt());
	}
}