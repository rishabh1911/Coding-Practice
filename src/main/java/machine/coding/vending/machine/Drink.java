package machine.coding.vending.machine;

import java.util.HashMap;
import java.util.Map;

/**
 *  An abstract class defining each drink.
 * @author Rishabh Agarwal
 */
public abstract class Drink {

	/**
	 * A map of ingredient required and it's quantity for a drink 
	 */
	Map<Ingredient, Integer> ingredients = new HashMap<>();
	
	public Map<Ingredient, Integer> getAllIngredients() {
		return ingredients;
	}
	
	public int getIngredientValue(Ingredient ingredient) {
		return ingredients.get(ingredient);
	}
	
}
