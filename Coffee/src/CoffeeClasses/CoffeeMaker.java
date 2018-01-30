/**
 * 
 */
package CoffeeClasses;
import java.util.*;

/**
 * @author herasymj
 *
 */
public class CoffeeMaker {

	public static int MAX_INVENTORY = 20;
	public static int MAX_NUM_RECIPES = 4;
	private ArrayList<Recipe> recipes;
	private int recipeNum;
	private Inventory inventory;
	
	/**
	 * CoffeeMaker constructor, sets inventory.
	 * <p>
	 * Takes the max inventory amount and sets the inventory's coffe, milk, and sugar.
	 * <p>
	 */
	public CoffeeMaker(){
		recipes = new ArrayList<Recipe>();		
		inventory = new Inventory();
		
		inventory.setCoffee(MAX_INVENTORY);
		inventory.setSugar(MAX_INVENTORY);
		inventory.setMilk(MAX_INVENTORY);
	}
	
	/**
	 * Adds a recipe to the coffee maker
	 * <p>
	 * Takes a recipe and if not at max recipes, will add it to the recipe list. Return true if recipe could be added, else false.
	 * <p>
	 * 
	 * @param Recipe - Recipe to be added
	 * @return Boolean - True of False
	 */
	public boolean addRecipe(Recipe rAdd) {
		int coffee = rAdd.getCoffeeLevel();
		int milk = rAdd.getMilkLevel();
		int sugar = rAdd.getSugarLevel();
		String name = rAdd.getRecipeName();
		
		if(rAdd.getCoffeeLevel() > MAX_INVENTORY || rAdd.getCoffeeLevel() < 0) {
			coffee = MAX_INVENTORY;
		}
		if(rAdd.getMilkLevel() > MAX_INVENTORY || rAdd.getMilkLevel() < 0) {
			milk = MAX_INVENTORY;
		}
		if(rAdd.getSugarLevel() > MAX_INVENTORY || rAdd.getSugarLevel() < 0) {
			sugar = MAX_INVENTORY;
		}
		
		if(this.recipeNum < MAX_NUM_RECIPES) {
			recipes.add(new Recipe(name, milk, sugar, coffee));
			this.recipeNum += 1;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Deletes a recipe from list if exists.
	 * <p>
	 * Takes a recipe and checks if its in the list, and if it does delete it and return true. Else false.
	 * <p>
	 * 
	 * @param String - Recipe name to remove
	 * @return Boolean - true or false
	 */
	public boolean deleteRecipe(java.lang.String recipeName) {
		if(getRecipe(recipeName) == null) {
			return false;
		}
		else {
			for(int i = 0; i < this.recipeNum; i++) {
				if(recipes.get(i).getRecipeName().equals(recipeName)) {
					recipes.remove(i);
					this.recipeNum -= 1;
				}
			}
			return true;
		}
	}
	
	/**
	 * Returns current inventory.
	 * @return Inventory - current inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Find recipe in list.
	 * <p>
	 * Takes recipe name and tries to find recipe in recipe list.
	 * <p>
	 * 
	 * @param String - name of recipe to find
	 * @return Recipe - returns recipe or null if not found
	 */
	public Recipe getRecipe(java.lang.String recipeName) {
		for(int i = 0; i < this.recipeNum; i++) {
			if(recipes.get(i).getRecipeName().equals(recipeName)) {
				return recipes.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Makes coffee using a specific recipe.
	 * <p>
	 * Takes recipe name, and if there is enough inventory to make recipe, make the coffee. Returns true if coffee is made, else false.
	 * <p>
	 * 
	 * @param String - name of recipe to make
	 * @return Boolean - true or false
	 */
	public boolean makeCoffee(java.lang.String recipeName) {
		if(getRecipe(recipeName) == null) {
			return false;
		}
		int recipeCoffee = getRecipe(recipeName).getCoffeeLevel();
		int recipeMilk = getRecipe(recipeName).getMilkLevel();
		int recipeSugar = getRecipe(recipeName).getSugarLevel();
		
		int inventoryCoffee = getInventory().getCoffee();
		int inventoryMilk = getInventory().getMilk();
		int inventorySugar = getInventory().getSugar();
		
		if(recipeCoffee > inventoryCoffee || recipeSugar > inventorySugar || recipeMilk > inventoryMilk) {
			return false;
		}
		else {
			getInventory().setCoffee(inventoryCoffee - recipeCoffee);
			getInventory().setMilk(inventoryMilk - recipeMilk);
			getInventory().setSugar(inventorySugar - recipeSugar);
			return true;
		}
	}
	
	/**
	 * 
	 * <p>
	 * 
	 * <p>
	 * 
	 * @param Inventory - inventory to add to.
	 * @return Boolean - true or false
	 */
	public boolean addInventory(Inventory inventory) {
		return true;
	}
	
	/**
	 * 
	 * <p>
	 * 
	 * <p>
	 * 
	 * @param Recipe - Edited recipe to be changed
	 * @return Boolean - true or false
	 */
	public boolean editRecipe(Recipe recipe) {
		return true;
	}
}
