package console;

public class MainConsole {

	public static void main(String[] args) {
		SnakeConsoleManager manager = new SnakeConsoleManager();
		manager.newGame(10, 12);
		manager.startGame();

	}

}