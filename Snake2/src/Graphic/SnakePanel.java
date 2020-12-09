package Graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Position;
import model.SnakeGame;


public class SnakePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	SnakeFrame frame;

	public SnakePanel(SnakeFrame frame) {
		this.frame = frame;
		setBackground(Color.PINK);
	}
	

	public void paint(Graphics g) {
		super.paint(g);
		paintSnake(g);
	}

	public void paintSnake(Graphics g) {
		SnakeGame snake = frame.manager.snake;
		if (snake.gameOver) {
			End(g);
		}
		else
			for (int line = 0; line < snake.nbLines; line++)
				for (int column = 0; column < snake.nbColumns; column++)
					paintCell(g, line, column);
	}
	
	private void End(Graphics g) {
		SnakeGraphicManager manager = frame.manager;
		SnakeGame snake = manager.snake;
		setBackground(Color.BLACK);
		Font fon = new Font("TimesRoman ",Font.BOLD,80);
		g.setFont(fon);
		g.setColor(Color.RED);
		g.drawString("GAME OVER !", 100, 300);
		Font font = new Font("TimesRoman",Font.BOLD,60);
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString("Score : "+snake.score, 250, 400);
	}
	

	private void paintCell(Graphics g, int line, int column) {
		SnakeGraphicManager manager = frame.manager;
		SnakeGame snake = manager.snake;
		int x = (int) manager.getX(line, column);
		int y = (int) manager.getY(line, column);
		int cellWidth = (int) manager.cellWidth();
		int cellHeight = (int) manager.cellHeight();

		g.setColor(Color.WHITE);
		g.fillRect(x, y, cellWidth, cellHeight);

	
		if (snake.element_place(line, column)) {
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, y, cellWidth, cellHeight);
		}
		if (snake.pomme.pose.equals(new Position(line, column))) {
			g.setColor(Color.GREEN);
			g.fillOval(x, y, cellWidth, cellHeight);
		}
		
		g.setColor(Color.BLACK);

		g.drawRect(x, y, cellWidth, cellHeight);
		
		Font fonte = new Font("TimesRoman ",Font.BOLD,30);
		g.setFont(fonte);
		g.setColor(Color.RED);
		g.drawString("SCORE : "+snake.score, 300, 800 );
		
	}

//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		
//		SnakeGame snake = frame.manager.snake;
//		
//		g.setColor(Color.RED);
//		
//		g.drawRect(40, 100, 200, 50);
//
//		g.setColor(Color.BLUE);
//		
//		g.fillRect(440, 100, 200, 50);
//	
//		g.drawString("Une chaine", 400, 400);
//		
//		g.setColor(Color.MAGENTA);
//		
//		g.drawLine(10, 10, 500, 500);
//		
//		g.setColor(Color.GREEN);
//		
//		g.fillOval(100, 600, 100, 200);
//		
//	
//	}
}
