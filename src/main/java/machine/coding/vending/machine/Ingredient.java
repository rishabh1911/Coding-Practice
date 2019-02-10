package machine.coding.vending.machine;

public enum Ingredient {
	
	TEA_POWDER(0),
	COFFEE_POWDER(1),
	SUGAR(2),
	MILK(3),
	TOMATO_MIX(4),
	WATER(5);
	
	private int id;

	private Ingredient(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static Ingredient get(final String value) {
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}
		return Ingredient.valueOf(value.trim().toUpperCase());
	}
	
}
