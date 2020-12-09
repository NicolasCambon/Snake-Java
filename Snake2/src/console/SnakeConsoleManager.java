package console;
import java.util.Scanner;
import model.Direction;
import model.SnakeGame;

public class SnakeConsoleManager {
	private SnakeGame snake;
	private Scanner scanner = new Scanner(System.in);
	
	public void newGame(int nbLines, int nbColumns) {
		snake = new SnakeGame(nbLines, nbColumns);	
	}

	public void startGame() {
		do {
			System.out.println(snake);
			playStep();	
		} while(!snake.GameOver());
		
		System.out.println(snake);
		System.out.println("Game over !");
	}
	
	private void playStep() {
		System.out.println("4 - Gauche");
		System.out.println("8 - Haut");
		System.out.println("6 - Droite");
		System.out.println("2 - Bas");
		System.out.println("Rien - Avancer");
		
		String line = scanner.nextLine();
		
		if (line.equals("4") && snake.comparepose(Direction.LEFT)) {
			snake.setDirection(Direction.LEFT);
		} else if (line.equals("8")&& snake.comparepose(Direction.UP)) {
			snake.setDirection(Direction.UP);
		} else if (line.equals("6")&& snake.comparepose(Direction.RIGHT)) {
			snake.setDirection(Direction.RIGHT);
		} else if (line.equals("2")&& snake.comparepose(Direction.DOWN)) {
			snake.setDirection(Direction.DOWN);
		} else {
			snake.doStep();
		}
	}
}
