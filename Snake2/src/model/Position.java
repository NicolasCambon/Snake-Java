package model;

public class Position {
	public final int line;
	public final int column;

	public Position(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public boolean equals(Position other) {
		return line == other.line && column == other.column;
	}

	public Position move(Direction direction) {
		switch (direction) {
		case LEFT:
			return new Position(line, column - 1);
		case RIGHT:
			return new Position(line, column + 1);
		case UP:
			return new Position(line + 1, column);
		case DOWN:
			return new Position(line - 1, column);
		default:
			return null;
		}
	}

	public boolean isValid(int nbLines, int nbColumns) {
		return line >= 0 && line < nbLines && column >= 0 && column < nbColumns;
	}

}
