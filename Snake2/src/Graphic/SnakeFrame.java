package Graphic;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.Direction;

public class SnakeFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	SnakeGraphicManager manager;
	SnakePanel panel;
	Timer timer;

	ActionListener action = (e) -> {
		timer.setDelay(manager.snake.getDelay());
		SnakeState state = manager.snake.doStep();

		switch (state) {
		case NORMAL:
			break;
		case MANGE:
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					manager.muse.apple_music();
				}

			});
			
			break;
		case PERDRE:
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					manager.muse.game_over_music();
				}
			}
			);
			timer.stop();
			
		default:
		}

		panel.repaint();
	};

	public SnakeFrame(SnakeGraphicManager manager) {
		this.manager = manager;
		this.panel = new SnakePanel(this);
		add(panel);

		setTitle("Snake de JOJO ");
		setSize(manager.width, manager.height + 100);

		addActionListener();
		addTimer();
	}

	private void addTimer() {
		timer = new Timer(manager.snake.getDelay(), action);
		timer.start();
	}

	private void addActionListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT :
					manager.snake.setDirection(Direction.LEFT);
					break;
				case KeyEvent.VK_RIGHT:
					manager.snake.setDirection(Direction.RIGHT);
					break;
				case KeyEvent.VK_UP:
					manager.snake.setDirection(Direction.UP);
					break;
				case KeyEvent.VK_DOWN:
					manager.snake.setDirection(Direction.DOWN);
					break;
				}
			}
		});
	}

}
