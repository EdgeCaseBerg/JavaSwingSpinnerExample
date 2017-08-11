import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class OrderingGUI extends JFrame {
	
	OrderingSystem orderingSystem;

	/* Maximum of burgers is 10. No fatty's */
	JSpinner numberOfBurgersSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
	JCheckBox hasCheeseBox = new JCheckBox("Cheese?");

	JSpinner friesSpinner = new JSpinner(new SpinnerNumberModel(0,0, 10, 1));

	String[] sizes = {"small", "medium", "large"};

	JSpinner frieSizeSpinner = new JSpinner(new SpinnerListModel(sizes));
	JSpinner numberOfFriesSpinner = new JSpinner(new SpinnerNumberModel(0,0, 10, 1));

	JSpinner numberOfDrinksSpinner = new JSpinner(new SpinnerNumberModel(0,0, 10, 1));
	JSpinner drinkSizeSpinner = new JSpinner(new SpinnerListModel(sizes));

	JButton computeTotalBtn = new JButton("Compute Total");
	JButton clearOrderBtn = new JButton("Clear Order");

	JTextArea receiptLabel = new JTextArea("");

	class ComputeTotalButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* Retrieve data from the GUI */
			boolean burgerHasCheese = hasCheeseBox.isSelected();
			SpinnerNumberModel burgerModel = (SpinnerNumberModel) numberOfBurgersSpinner.getModel();
			int numOfBurgers = burgerModel.getNumber().intValue();

			SpinnerListModel frieSizeModel = (SpinnerListModel) frieSizeSpinner.getModel();
			String frieSize = (String) frieSizeModel.getValue();

			SpinnerNumberModel numFriesModel = (SpinnerNumberModel) numberOfFriesSpinner.getModel();
			int numberOfFries = numFriesModel.getNumber().intValue();

			SpinnerListModel drinkSizeModel = (SpinnerListModel) drinkSizeSpinner.getModel();
			String drinkSize = (String) drinkSizeModel.getValue();

			SpinnerNumberModel numDrinksModel = (SpinnerNumberModel) numberOfDrinksSpinner.getModel();
			int numberOfDrinks = numDrinksModel.getNumber().intValue();

			/* Convert GUI into ordering system menu items */
			for (int i = 0; i < numOfBurgers; i++) {
				orderingSystem.addMenuItem(
					new Burger(burgerHasCheese)
				);
			}
			for (int i = 0; i < numberOfFries; i++) {
				orderingSystem.addMenuItem(
					new Fries(frieSize)
				);
			}
			for (int i = 0; i < numberOfDrinks; i++) {
				orderingSystem.addMenuItem(
					new Drink(drinkSize)
				);
			}

			/* Calculate and display the receipt */
			String receiptLabelText = orderingSystem.getReceipt();
			receiptLabel.setText(receiptLabelText);
		}
	}

	class ResetOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* Reset the order inside */
			orderingSystem.clearOrder();
			/* Set the GUI back to relative normalness */
			receiptLabel.setText("");

			frieSizeSpinner.setValue(sizes[0]);
			numberOfFriesSpinner.setValue(0);

			drinkSizeSpinner.setValue(sizes[0]);
			numberOfDrinksSpinner.setValue(0);
			
			numberOfBurgersSpinner.setValue(0);
			hasCheeseBox.setSelected(false);
		}
	}

	public OrderingGUI(OrderingSystem orderingSystem) {
		super();
		this.setLayout(new FlowLayout());

		this.orderingSystem = orderingSystem;

		JLabel titleLabel = new JLabel("McOrdering 2.0");
		JLabel burgersLabel = new JLabel("Burgers:");
		JLabel friesLabel = new JLabel("Fries:");
		JLabel drinksLabel = new JLabel("Drinks:");

		add(titleLabel);
		
		add(burgersLabel);
		add(numberOfBurgersSpinner);
		add(hasCheeseBox);

		add(friesLabel);
		add(frieSizeSpinner);
		add(numberOfFriesSpinner);

		add(drinksLabel);
		add(drinkSizeSpinner);
		add(numberOfDrinksSpinner);

		add(receiptLabel);

		computeTotalBtn.addActionListener(new ComputeTotalButtonListener());
		clearOrderBtn.addActionListener(new ResetOrderListener());

		add(computeTotalBtn);
		add(clearOrderBtn);

		this.setVisible(true);
		this.setSize(150, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}