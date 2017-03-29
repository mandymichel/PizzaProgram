import java.util.ArrayList;
import java.util.List;

public class PizzaOptions {

	private String size;
	private String crust;
	private int numTops;
	private List<String> toppings = new ArrayList<>();
	private int pizzaCount;

	public PizzaOptions(String size, String crust, int numTops, List<String> toppings, int pizzaCount) {
		this.size = size;
		this.crust = crust;
		this.numTops = numTops;
		this.toppings = toppings;
		this.pizzaCount = pizzaCount;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public int getNumTops() {
		return numTops;
	}

	public void setNumTops(int numTops) {
		this.numTops = numTops;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	public int getPizzaCount() {
		return pizzaCount;
	}

	public void setPizzaCount(int pizzaCount) {
		this.pizzaCount = pizzaCount;
	}

	@Override
	public String toString() {
		return "Pizza size: " + size + ", crust: " + crust + ", number of toppings: " + numTops + ", toppings: "
				+ toppings + ", order number: " + pizzaCount;// make to String
																// that
																// separates the
																// array
	}

}
