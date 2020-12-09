package Graphic;

import model.Music;
import model.SnakeGame;

public class SnakeGraphicManager {
	SnakeGame snake;

	int width = 800;
	int height = 800;
	Music muse = new Music();

	public void startGame() {
		snake = new SnakeGame(45,45);
		SnakeFrame frame = new SnakeFrame(this);
		frame.setVisible(true);
		muse.Snake_music();
	}

	public double getX(int line, int column) {
		return column * cellWidth();
	}

	public double getY(int line, int column) {
		return (snake.nbLines - line - 1) * cellHeight();
	}

	public double cellWidth() {
		return width / snake.nbColumns;
	}

	public double cellHeight() {
		return height / snake.nbLines;
	}
}
