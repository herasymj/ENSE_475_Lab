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
	 * Takes the max inventory amount and sets the inventory's coffee, milk, and sugar.
	 * <p>
	 */
	public CoffeeMaker(){
		recipes = new ArrayList<Recipe>();		
		inventory = new Inventory();
		
		inventory.setCoffee(MAX_INVENTORY);
		inventory.setSugar(MAX_INVENTORY);
		inventory.setMilk(MAX_INVENTORY);
		inventory.setExpresso(MAX_INVENTORY);
		inventory.setChocolate(MAX_INVENTORY);
		
		//Add 4 recipes to coffee maker pre-defined the reset recipe num to zero
		Recipe Cappuccino = new Recipe("Cappuccino", 2, 0, 0, 1, 0);
		Recipe Latte = new Recipe("Latte", 5, 0, 0, 1, 0);
		Recipe Expresso = new Recipe("Expresso", 0, 0, 0, 1, 0);
		Recipe Mocha = new Recipe("Mocha", 1, 0, 0, 2, 2);
		
		recipes.add(Cappuccino);
		recipes.add(Latte);
		recipes.add(Expresso);
		recipes.add(Mocha);
		
		recipeNum = 0;
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
		int expresso = rAdd.getExpressoLevel();
		int chocolate = rAdd.getChocolateLevel();
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
		if(rAdd.getExpressoLevel() > MAX_INVENTORY || rAdd.getExpressoLevel() < 0) {
			expresso = MAX_INVENTORY;
		}
		if(rAdd.getChocolateLevel() > MAX_INVENTORY || rAdd.getChocolateLevel() < 0) {
			chocolate = MAX_INVENTORY;
		}
		
		if(this.recipeNum < MAX_NUM_RECIPES) {
			recipes.add(new Recipe(name, milk, sugar, coffee, expresso, chocolate));
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
			for(int i = 0; i < this.recipes.size(); i++) {
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
		for(int i = 0; i < this.recipes.size(); i++) {
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
		int recipeExpresso = getRecipe(recipeName).getExpressoLevel();
		int recipeChocolate = getRecipe(recipeName).getChocolateLevel();
		
		int inventoryCoffee = getInventory().getCoffee();
		int inventoryMilk = getInventory().getMilk();
		int inventorySugar = getInventory().getSugar();
		int inventoryExpresso = getInventory().getExpresso();
		int inventoryChocolate = getInventory().getChocolate();
		
		if(recipeCoffee > inventoryCoffee || recipeSugar > inventorySugar || recipeMilk > inventoryMilk || recipeExpresso > inventoryExpresso || recipeChocolate > inventoryChocolate) {
			return false;
		}
		else {
			getInventory().setCoffee(inventoryCoffee - recipeCoffee);
			getInventory().setMilk(inventoryMilk - recipeMilk);
			getInventory().setSugar(inventorySugar - recipeSugar);
			getInventory().setExpresso(inventoryExpresso - recipeExpresso);
			getInventory().setChocolate(inventoryChocolate - recipeChocolate);
			return true;
		}
	}
	
	/**
	 * Add to current inventory.
	 * <p>
	 * User can decide how much of each ingredient to add.
	 * <p>
	 * 
	 * @param Inventory - inventory to add to.
	 * @return Boolean - true or false
	 */
	public boolean addInventory(Inventory inventory) {
		//return false if inventory full or new inventory empty
		if(inventory == null || (getInventory().getMilk() == 20 && getInventory().getSugar() == 20 && getInventory().getCoffee() == 20 &&
				getInventory().getExpresso() == 20 && getInventory().getChocolate() == 20) || (inventory.getCoffee() == 0
				&& inventory.getSugar() == 0 && inventory.getMilk() == 0 && inventory.getExpresso() == 0 && inventory.getChocolate() == 0)) {
			return false;
		}
		
		int inCoffee = getInventory().getCoffee();
		int inSugar = getInventory().getSugar();
		int inMilk = getInventory().getMilk();
		int inExpresso = getInventory().getExpresso();
		int inChocolate = getInventory().getChocolate();
		
		if(inCoffee + inventory.getCoffee() > 20) {
			getInventory().setCoffee(20);
		}
		else {
			getInventory().setCoffee(inventory.getCoffee() + inCoffee);
		}
		
		if(inMilk + inventory.getMilk() > 20) {
			getInventory().setMilk(20);
		}
		else {
			getInventory().setMilk(inventory.getMilk() + inMilk);
		}
		
		if(inSugar + inventory.getSugar() > 20) {
			getInventory().setSugar(20);
		}
		else {
			getInventory().setSugar(inventory.getSugar() + inSugar);
		}
		
		if(inExpresso + inventory.getExpresso() > 20) {
			getInventory().setExpresso(20);
		}
		else {
			getInventory().setExpresso(inventory.getExpresso() + inExpresso);
		}
		
		if(inChocolate + inventory.getChocolate() > 20) {
			getInventory().setChocolate(20);
		}
		else {
			getInventory().setChocolate(inventory.getChocolate() + inChocolate);
		}
		
		return true;
	}
	
	/**
	 * Edit recipe
	 * <p>
	 * User send in recipe that has been edited. Find recipe with same name and edit values. Return false if recipe does not exist.
	 * <p>
	 * 
	 * @param Recipe - Edited recipe to be changed
	 * @return Boolean - true or false
	 */
	public boolean editRecipe(Recipe recipe) {
		//if recipe don't exists, return false
		if(getRecipe(recipe.getRecipeName()) == null){
			return false;
		}
		
		deleteRecipe(recipe.getRecipeName());
		addRecipe(recipe);
		return true;		
	}
}
