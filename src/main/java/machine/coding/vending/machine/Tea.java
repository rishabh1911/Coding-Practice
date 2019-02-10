package machine.coding.vending.machine;

public class Tea extends Drink {
	
	public Tea() {
		ingredients.put(Ingredient.TEA_POWDER, 1);
		ingredients.put(Ingredient.MILK, 1);
		ingredients.put(Ingredient.SUGAR, 1);
		ingredients.put(Ingredient.WATER, 1);
	}

}
