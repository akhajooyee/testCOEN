package util;
public enum Heading {
	NORTH("NORTH"),
	EAST("EAST"),
	SOUTH("SOUTH"),
	WEST("WEST");

	private String value;

	Heading(String value) {
		this.value = value;
	}

	public static Heading from(String value) {
		for (Heading head : values()) {
			if (head.getHeading().equalsIgnoreCase(value)) {
				return head;
			}
		}
		return null;
	}

	public Heading changeHeading(int rotatePoint) {
		int resultIndex = ((ordinal() + rotatePoint) + 4) % 4;
		return values()[resultIndex];
	}

	public String getHeading() {
		return value;
	}
}

