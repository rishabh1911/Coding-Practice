package machine.coding.vending.machine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VendingMachine {

	/**
	 * A map of ingredient present in vending machine
	 */
	Map<Ingredient, Integer> ingredientsPresent = new HashMap<>();

	Set<DrinkType> drinksPresent = new HashSet<DrinkType>();
	
	VendingMachine(Set<DrinkType> drinksPresent, Map<Ingredient, Integer> ingredientsPresent) {
		this.ingredientsPresent = ingredientsPresent;
		this.drinksPresent = drinksPresent;
	}

	public Map<Ingredient, Integer> getAllIngredients() {
		return ingredientsPresent;
	}

	public int getIngredientValue(Ingredient ingredient) {
		return ingredientsPresent.get(ingredient);
	}

	public boolean isDrinkPossible(DrinkType drink) {
		boolean isPossible = true;
		Map<Ingredient, Integer> drinkIngredients = DrinkFactory.getDrinkObject(drink).getAllIngredients();
		Iterator<Map.Entry<Ingredient, Integer>> it = drinkIngredients.entrySet().iterator();
		while(it.hasNext()) {
			Ingredient ingredient = it.next().getKey();
			int requiredValue = it.next().getValue();
			if(getIngredientValue(ingredient)<requiredValue) {
				isPossible = false;
				break;
			}
		}
		return isPossible;
	}

	public Drink getDrink(DrinkType drink) {
		if( !isDrinkPossible(drink) ) return null;
		Drink myDrink = DrinkFactory.getDrinkObject(drink);
		Map<Ingredient, Integer> drinkIngredients = myDrink.getAllIngredients();
		Iterator<Map.Entry<Ingredient, Integer>> it = drinkIngredients.entrySet().iterator();
		while(it.hasNext()) {
			Ingredient ingredient = it.next().getKey();
			int requiredValue = it.next().getValue();
			ingredientsPresent.put(ingredient, getIngredientValue(ingredient)-requiredValue);
		}
		return myDrink;
	}

	public boolean addDrink(DrinkType drink) {
		drinksPresent.add(drink);
		return true;
	}

	public boolean removeDrink(DrinkType drink) {
		drinksPresent.remove(drink);
		return true;
	}

}
