package machine.coding.vending.machine;

public class Coffee extends Drink {
	
	public Coffee() {
		ingredients.put(Ingredient.COFFEE_POWDER, 1);
		ingredients.put(Ingredient.MILK, 1);
		ingredients.put(Ingredient.SUGAR, 1);
		ingredients.put(Ingredient.WATER, 1);
	}
}
