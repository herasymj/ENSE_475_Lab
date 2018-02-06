package CoffeeClasses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffeeMakerTest1 {

	/**
	 * Test method for {@link Coffee.CoffeeMaker#CoffeeMaker()}.
	 */
	@Test
	public void testCoffeeMaker() {
		CoffeeMaker cm = new CoffeeMaker();
		
		assertEquals(20, cm.getInventory().milkLevel);
		assertEquals(20, cm.getInventory().sugarLevel);
		assertEquals(20, cm.getInventory().coffeeLevel);
	}

	/**
	 * Test method for {@link Coffee.CoffeeMaker#addRecipe(Coffee.Recipe)}.
	 */
	@Test
	public void testAddRecipe() {
		CoffeeMaker cm = new CoffeeMaker();
		Recipe r1 = new Recipe("r1", 15, 100, 21, 7, 6);
		Recipe r2 = new Recipe("r2", 2, 2, 2, 2, 2);
		Recipe r3 = new Recipe("r3", 3, 3, 3, 3, 3);
		Recipe r4 = new Recipe("r4", 4, 4, 4, 4, 4);
		Recipe r5 = new Recipe("r5", 5, 5, 5, 5, 5);
		
		assertEquals(true, cm.addRecipe(r1));
		assertEquals(true, cm.addRecipe(r2));
		assertEquals(true, cm.addRecipe(r3));
		assertEquals(true, cm.addRecipe(r4));
		assertEquals(false, cm.addRecipe(r5));
	}

	/**
	 * Test method for {@link Coffee.CoffeeMaker#deleteRecipe(java.lang.String)}.
	 */
	@Test
	public void testDeleteRecipe() {
		CoffeeMaker cm = new CoffeeMaker();
		Recipe r4 = new Recipe("r4", 4, 4, 4, 4, 4);
		Recipe r5 = new Recipe("r5", 5, 5, 5, 5, 5);
		
		cm.addRecipe(r4);
		cm.addRecipe(r5);
		
		assertEquals(true, cm.deleteRecipe("r4"));
		assertEquals(true, cm.deleteRecipe("r5"));
		assertEquals(false, cm.deleteRecipe("r3"));
		assertEquals(false, cm.deleteRecipe("gdfgdfg"));
	}

	/**
	 * Test method for {@link Coffee.CoffeeMaker#getRecipe(java.lang.String)}.
	 */
	@Test
	public void testGetRecipe() {
		CoffeeMaker cm = new CoffeeMaker();
		Recipe r1 = new Recipe("r1", 15, 100, 21, 45, 3);
		Recipe r2 = new Recipe("r2", 2, 2, 2, 2, 2);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		
		assertEquals(r1.name, cm.getRecipe("r1").getRecipeName());
		assertEquals(r1.milk, cm.getRecipe("r1").milk);
		assertEquals(r2.name, cm.getRecipe("r2").name);
		assertEquals(r2.milk, cm.getRecipe("r2").milk);
		assertEquals(r2.sugar, cm.getRecipe("r2").sugar);
		assertEquals(r2.coffee, cm.getRecipe("r2").coffee);
		assertEquals(null, cm.getRecipe("r3"));
		assertEquals(null, cm.getRecipe("fdsfdsfds"));
	}

	/**
	 * Test method for {@link Coffee.CoffeeMaker#makeCoffee(java.lang.String)}.
	 */
	@Test
	public void testMakeCoffee() {
		CoffeeMaker cm = new CoffeeMaker();
		Recipe r3 = new Recipe("r3", 3, 3, 3, 3, 3);
		Recipe r4 = new Recipe("r4", 4, 4, 4, 4, 4);
		Recipe r5 = new Recipe("r5", 5, 5, 5, 5, 5);
		
		cm.addRecipe(r3);
		cm.addRecipe(r5);
		cm.addRecipe(r4);
		
		assertEquals(true, cm.makeCoffee("r3"));//3
		assertEquals(true, cm.makeCoffee("r4"));//7
		assertEquals(true, cm.makeCoffee("r5"));//12
		assertEquals(true, cm.makeCoffee("r5"));//17
		assertEquals(false, cm.makeCoffee("r5"));//22 - should not work
		assertEquals(true, cm.makeCoffee("r3"));//20 - should work
	}

	@Test
	void testAddInventory() {
		CoffeeMaker cm = new CoffeeMaker();
		Recipe r3 = new Recipe("r3", 3, 3, 3, 3, 3);
		Recipe r4 = new Recipe("r4", 4, 4, 4, 4, 4);
		Recipe r5 = new Recipe("r5", 5, 5, 5, 5, 5);
		
		cm.addRecipe(r3);
		cm.addRecipe(r5);
		cm.addRecipe(r4);
		
		cm.makeCoffee("r3");
		cm.makeCoffee("r4");
		cm.makeCoffee("r5");
		
		Inventory in1 = new Inventory();
		Inventory in2 = new Inventory();
		in2.setChocolate(10);
		in2.setSugar(10);
		in2.setMilk(10);
		in2.setExpresso(10);
		in2.setCoffee(10);
		
		assertEquals(false, cm.addInventory(in1));
		assertEquals(true, cm.addInventory(in2));
		assertEquals(true, cm.addInventory(in2));
		assertEquals(false, cm.addInventory(in2));
	}

	@Test
	void testEditRecipe() {
		CoffeeMaker cm = new CoffeeMaker();
		Recipe r3 = new Recipe("r3", 3, 3, 3, 3, 3);
		Recipe r4 = new Recipe("r4", 4, 4, 4, 4, 4);
		Recipe r5 = new Recipe("r5", 5, 5, 5, 5, 5);
		
		cm.addRecipe(r3);
		cm.addRecipe(r5);
		
		Recipe newR5 = new Recipe("r5", 5, 5, 5, 5, 6);
		
		assertEquals(true, cm.editRecipe(newR5));
		assertEquals(false, cm.editRecipe(r4));
	}

}
