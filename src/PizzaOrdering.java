
//Bugs: how do I wipe the toppings array after a pizza? change menu appears twice if there are 2 pizzas, error handling
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaOrdering {
	PizzaOptions currentPizza = new PizzaOptions(null, null, 0, null, 0);
	List<PizzaOptions> pizzas = new ArrayList<>();
	List<String> toppings = new ArrayList<>();
	static int SMALL = 8;
	static int MEDIUM = 10;
	static int LARGE = 12;
	static int SMALLTOP = 1;
	static int MEDIUMTOP = 2;
	static int LARGETOP = 3;
	Scanner keyboard = new Scanner(System.in);

	public void printMenu() {
		out.println("Menu");
		out.println("1. Start a new order.");
		out.println("2. Add to an existing order.");
		out.println("3. Pay for the order.");
		out.println("0. Quit");
	}

	public float howPay(int totalCost) {
		float cash = 0f;
		out.println("What will you pay in cash?");
		cash = keyboard.nextFloat();
		float tc = (float) totalCost;
		float change = cash - tc;
		return change;
	}

	public void costOrder() {
		int pizzaCost = 0;
		int totalCost = 0;

		for (PizzaOptions p : pizzas) {
			pizzaCost = 0;
			switch (p.getSize()) {
			case "small":
				pizzaCost = pizzaCost + SMALL;
				pizzaCost = pizzaCost + (p.getNumTops() * SMALLTOP);
				break;
			case "medium":
				pizzaCost = pizzaCost + MEDIUM;
				pizzaCost = pizzaCost + (p.getNumTops() * MEDIUMTOP);
				break;
			case "large":
				pizzaCost = pizzaCost + LARGE;
				pizzaCost = pizzaCost + (p.getNumTops() * LARGETOP);
				break;
			}
			out.println("Pizza " + p.getPizzaCount() + " will cost " + "$" + pizzaCost + ".00");
			totalCost = pizzaCost + totalCost;
		}
		out.println("Your total cost will be: " + "$" + totalCost + ".00");
		float change = 0f;
		change = howPay(totalCost);
		out.println("You will receive back $" + change + "0");
	}

	public void changeMenu() {
		out.println("What would you like to change?");
		out.println("1. Size.");
		out.println("2. Crust.");
		out.println("3. Number of toppings.");
		out.println("4. Toppings.");
		out.println("0. Nothing else.");
	}

	public void addToOrder() {
		for (PizzaOptions p : pizzas) {
			out.println(p);
		}
		out.println("Enter the pizza count number of the pizza you would like to change.");
		int num = keyboard.nextInt();
		for (PizzaOptions p : pizzas) {
			if (p.getPizzaCount() == num) {
				out.println(p);
				currentPizza = p;
			}
			int changeChoice = 0;
			do {
				changeMenu();// try changing string list to string builder for
								// toppings problem
				changeChoice = keyboard.nextInt();
				switch (changeChoice) {
				case 1:
					out.println("What new size?");
					String s = keyboard.next();
					currentPizza.setSize(s);
					break;
				case 2:
					out.println("What new crust?");
					String c = keyboard.next();
					currentPizza.setCrust(c);
					break;
				case 3:
					out.println("How many toppings?");
					int n = keyboard.nextInt();
					currentPizza.setNumTops(n);
				case 4:
					for (int i = 0; i < currentPizza.getNumTops(); i++) {
						out.println("Which new toppings?");
						String t = keyboard.next();
						toppings.add(t);
					}
					currentPizza.setToppings(toppings);
					break;
				}
			} while (changeChoice != 0);
		}
	}

	public void pizzaMenu() {
		out.println("Pizza Menu: ");
		out.println("Thin or thick crust");
		out.println("S			$8");
		out.println("M			$10");
		out.println("L			$12");
		out.println("Toppings: Pepperoni, Sausage, Peppers, Mushroom, Ham, Pineapple, Olives, Onions");
		out.println("Each topping: ");
		out.println("S			$1");
		out.println("M			$2");
		out.print("L			$3");
	}

	public void startNewOrder() {
		pizzaMenu();
		out.println("\n");
		PizzaOptions pizza = null;
		String size = null;
		String crust = null;
		int numTops = 0;
		int pizzaCount = 0;
		int numPizzas = 0;
		out.println("How many pizzas would you like to order?");
		numPizzas = keyboard.nextInt();
		for (int i = 0; i < numPizzas; i++) {
			out.println("Do you want small, medium, or large?");
			size = keyboard.nextLine();
			out.println("Do you want thin or thick crust?");
			crust = keyboard.nextLine();
			out.println("How many toppings do you want?");
			numTops = keyboard.nextInt();
			for (int j = 0; j < numTops; j++) {
				out.println("Which topping do you want?");
				String top = keyboard.nextLine();
				toppings.add(top);
			}
			pizza = new PizzaOptions(size, crust, numTops, toppings, pizzaCount);
			currentPizza = pizza;
			pizzas.add(pizza);
			pizza.setPizzaCount(pizzas.size());
			out.println("Your pizza number is: " + pizza.getPizzaCount());
		}
	}

	public void run() {
		int choice = 0;
		do {
			printMenu();
			choice = keyboard.nextInt();
			switch (choice) {
			case 1:
				startNewOrder();
				break;
			case 2:
				if (pizzas.isEmpty()) {
					continue;
				}
				addToOrder();
				break;
			case 3:
				if (pizzas.isEmpty()) {
					continue;
				}
				costOrder();
				break;
			}
		} while (0 != choice);
	}

	public static void main(String[] args) {
		PizzaOrdering po = new PizzaOrdering();
		po.run();
	}

}
