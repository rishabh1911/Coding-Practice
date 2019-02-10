package machine.coding.vending.machine;

public class DrinkFactory {
	
	public static Drink getDrinkObject(DrinkType drinkType) {

		switch(drinkType) {
		case COFFEE: 
			return new Coffee();
		case TOMATO_SOUP :
			return new TomatoSoup();
		case TEA :
			return new Tea();
		case BLACK_COFFEE : 
			return new BlackCoffee();
		default:
			return null;
		}

	}

}
