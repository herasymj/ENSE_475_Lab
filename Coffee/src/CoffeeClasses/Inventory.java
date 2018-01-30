/**
 * 
 */
package CoffeeClasses;

/**
 * @author herasymj
 *
 */
public class Inventory {

	int coffeeLevel;
	int milkLevel;
	int sugarLevel;
	
	/**
	 * Inventory constructor.
	 * <p>
	 * To initialize inventory it sets sugar, milk and cofee to 0.
	 * <p>
	 */
	public Inventory() {
		coffeeLevel = 0;
		milkLevel = 0;
		sugarLevel = 0;
	}
	
	/**
	 * Returns coffee inventory.
	 * <p>
	 * Returns the current inventory's coffee level.
	 * <p>
	 * 
	 * @return Int - current coffee level
	 */
	public int getCoffee() {
		return coffeeLevel;
	}
	
	/**
	 * Returns milk inventory.
	 * <p>
	 * Returns current inventory's milk level.
	 * <p>
	 * 
	 * @return Int - milk level
	 */
	public int getMilk() {
		return milkLevel;
	}
	
	/**
	 * Returns sugar inventory.
	 * <p>
	 * Returns the current inventory's sugar level.
	 * <p>
	 * 
	 * @return Int - sugar level
	 */
	public int getSugar() {
		return sugarLevel;
	}
	
	/**
	 * Sets coffee inventory.
	 * <p>
	 * Sets the inventory's coffee level to certain amount.
	 * <p>
	 * 
	 * @param Int - coffee amount
	 */
	public void setCoffee(int coffee) {
		coffeeLevel = coffee;
	}
	
	/**
	 * Sets milk inventory.
	 * <p>
	 * Sets the inventory's milk level to certain amount.
	 * <p>
	 * 
	 * @param Int - milk amount
	 */
	public void setMilk(int milk) {
		milkLevel = milk;
	}
	
	/**
	 * Sets sugar inventory.
	 * <p>
	 * Sets that inventory's sugar level to certain amount.
	 * <p>
	 * 
	 * @param Int - sugar amount
	 */
	public void setSugar(int sugar) {
		sugarLevel = sugar;
	}
}
