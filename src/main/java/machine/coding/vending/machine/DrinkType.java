package machine.coding.vending.machine;

public enum DrinkType {
	
	COFFEE(0),
	TEA(1),
	TOMATO_SOUP(2),
	MILK(3),
	BLACK_COFFEE(4);
	
	private int id;

	private DrinkType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static DrinkType get(final String value) {
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}
		return DrinkType.valueOf(value.trim().toUpperCase());
	}

}
