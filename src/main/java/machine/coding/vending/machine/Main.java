package machine.coding.vending.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{

		Set<DrinkType> drinksPresent = new HashSet<DrinkType>();
		drinksPresent.add(DrinkType.TEA);
		drinksPresent.add(DrinkType.COFFEE);
		drinksPresent.add(DrinkType.TOMATO_SOUP);
		Map<Ingredient, Integer> ingredientsPresent = new HashMap<>();
		ingredientsPresent.put(Ingredient.MILK, 200);
		ingredientsPresent.put(Ingredient.COFFEE_POWDER, 100);
		ingredientsPresent.put(Ingredient.TEA_POWDER, 100);
		ingredientsPresent.put(Ingredient.SUGAR, 200);
		ingredientsPresent.put(Ingredient.WATER, 500);
		ingredientsPresent.put(Ingredient.TOMATO_MIX, 500);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		VendingMachine vendingMachine = new VendingMachine(drinksPresent, ingredientsPresent);
		while(true) {
			System.out.println("If user enter 1, if technician enter 2.");
			int key = Integer.parseInt(br.readLine());
			switch (key) {
			case 1: {

				break;
			}
			default:
				boolean isTechnicianWorking = true;
				while(isTechnicianWorking) {
					System.out.println("Contents: "+vendingMachine.getAllIngredients());
					System.out.println("To add Ingredients press 1, to exit press 2.");
					int technicianChoice = Integer.parseInt(br.readLine());
					switch (key) {
					case 1: {
						System.out.println("Enter Ingredient");
						break;
					}
					default: isTechnicianWorking = false;
					}	
				}
			}
		}
	}
}