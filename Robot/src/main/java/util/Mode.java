package util;


public enum Mode {
	UP("UP"),
	DOWN("DOWN");

	private String writingmode;

	Mode(String writingmode) {
		this.writingmode = writingmode;
	}

	public static Mode from(String writingmode) {
		for (Mode mode : values()) {
			if (mode.getWritingMode().equalsIgnoreCase(writingmode)) {
				return mode;
			}
		}
		return null;
	}

	public Mode changeMode(int rotatePoint) {
		int resultIndex =rotatePoint;
		return values()[resultIndex];
	}

	public String getWritingMode() {
		return writingmode;
	}
	
	

}
