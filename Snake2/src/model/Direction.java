package model;

public enum Direction {
	LEFT, RIGHT, UP, DOWN;

	public String toString() {
		switch (this) {
		case LEFT:
			return "L";
		case RIGHT:
			return "R";
		case UP:
			return "U";
		case DOWN:
			return "D";
		default:
			return "?";
		}
	}

}
