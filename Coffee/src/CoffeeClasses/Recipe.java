/**
 * 
 */
package CoffeeClasses;

/**
 * @author herasymj
 *
 */
public class Recipe {

	//fields
	String name;
	int milk;
	int sugar;
	int coffee;
	int expresso;
	int chocolate;
	
	/**
	 * Recipe constructor.
	 * <p>
	 * Takes all values for a new recipe and sets the name, milk, sugar, and coffee levels.
	 * <p>
	 * 
	 * @param String - name of recipe
	 * @param Int - milk level, must be positive integer no greater than MAX_INVENTORY.
	 * @param Int - sugar level, must be positive integer no greater than MAX_INVENTORY.
	 * @param Int - coffee level, must be positive integer no greater than MAX_INVENTORY.
	 */
	public Recipe(java.lang.String recipeName, int milkLevel, int sugarLevel, int coffeeLevel, int expressoLevel, int chocolateLevel) {
		name = recipeName;
		milk = milkLevel;
		sugar = sugarLevel;
		coffee = coffeeLevel;
		expresso = expressoLevel;
		chocolate = chocolateLevel;
	}
	
	/**
	 * Returns coffee level.
	 * <p>
	 * Returns the recipes required coffee level
	 * <p>
	 * 
	 * @return Int - coffee level
	 */
	public int getCoffeeLevel() {
		return coffee;
	}
	
	/**
	 * Returns milk level
	 * <p>
	 * Returns the recipes required milk level.
	 * <p>
	 * 
	 * @return Int - milk level
	 */
	public int getMilkLevel() {
		return milk;
	}
	
	/**
	 * Returns recipe name.
	 * <p>
	 * Returns the current recipes name.
	 * <p>
	 * 
	 * @return String - Recipe Name
	 */
	public java.lang.String getRecipeName(){
		return name;
	}
	
	/**
	 * Returns sugar level.
	 * <p>
	 * Returns the current recipes sugar level.
	 * <p>
	 * 
	 * @return Int - sugar level
	 */
	public int getSugarLevel() {
		return sugar;
	}
	
	/**
	 * Returns expresso level.
	 * <p>
	 * Returns the current recipes expresso level.
	 * <p>
	 * 
	 * @return Int - expresso level
	 */
	public int getExpressoLevel() {
		return expresso;
	}
	
	/**
	 * Returns chocolate level.
	 * <p>
	 * Returns the current recipes chocolate level.
	 * <p>
	 * 
	 * @return Int - chocolate level
	 */
	public int getChocolateLevel() {
		return chocolate;
	}
}
