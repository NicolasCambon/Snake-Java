package model;
import java.util.ArrayList;

import Graphic.SnakeState;

public class SnakeGame {
	/** Le nombre de lignes. */
	public final int nbLines;

	/** Le nombre de colonnes. */
	public final int nbColumns;

	/** La direction. */
	private Direction direction;
	private Direction olddirection;

	/** La liste des positions. */
	private final ArrayList<Position> positions;

	/** Flag de fin de partie. */
	public boolean gameOver;
	
	public int score;
	
	public Pomme pomme;
	


	/**
	 * Constructeur d'un snake.
	 * 
	 * @param nbLines   Le nombre de lignes.
	 * @param nbColumns Le nombre de colonnes.
	 */
	public SnakeGame(int nbLines, int nbColumns) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.positions = new ArrayList<>();
		initialize();
	}

	private void initialize() {
		this.gameOver = false;
		this.pomme = new Pomme(nbLines,nbColumns);
		this.direction = Direction.RIGHT;
		pomme.tirerPomme();
		positions.add(new Position(nbLines / 2, nbColumns / 2));
		positions.add(new Position(nbLines / 2, (nbColumns / 2)-1));
	}

	public void setDirection(Direction direction) {
		if (this.direction!=null)
			olddirection = this.direction;
		this.direction = direction;
	}

	public SnakeState doStep() {
		Position newPosition;
		if (comparepose(direction)) 
			newPosition = positions.get(0).move(direction);
		else 
			newPosition = positions.get(0).move(olddirection);
		Position endElement = positions.get(positions.size()-1);

		if (!isValid(newPosition)) {
			gameOver = true;
		

			return SnakeState.PERDRE;
		}	
		for (int element=positions.size()-1;element>0;element--)
			positions.set(element,positions.get(element-1));
		positions.set(0, newPosition);
		
		if (eatapple(positions.get(0))) {
			score+=100;
			positions.add(endElement);
			newapple();
		
			return SnakeState.MANGE;
		}
		
		return SnakeState.NORMAL;
	}
	
	private boolean eatapple(Position pos){
		return pos.equals(pomme.pose);
	}
	private void newapple() {
			do {
				pomme.tirerPomme();
			}while(element_place(pomme.pose.line,pomme.pose.column));	
	}

	private boolean isValid(Position p) {
		for(int element=2; element<positions.size();element++)
			if (containsPart(p.line,p.column,element))
				return false;
		return p.isValid(nbLines, nbColumns);
	}

	@Override
	public String toString() {
		String res = "";

		for (int line = nbLines - 1; line >= 0; line--) {
			for (int column = 0; column < nbColumns; column++) {
				if (element_place(line,column)) {
					if (positions.get(0).equals(new Position(line,column))) 
						res += direction;
					else 
						res +="B";
				}
				else if(pomme.pose.equals(new Position(line, column)))
					res += "P";
				else 
					res += "0";
			}
			res += "\n";
		}

		return res;
	}
	public boolean element_place(int line, int column) {
		for(int element=0; element<positions.size();element++)
			if (containsPart(line, column,element))
				return true;
		return false;
	}

	public boolean GameOver() {
		return gameOver;
	}

	public boolean containsPart(int line, int column,int element) {
		if (element<positions.size())
			return positions.get(element).equals(new Position(line, column));
		return false;
	}

	public int getDelay() {
		return 800/positions.size();
	}
	public boolean comparepose(Direction mouv) {
		if (mouv == Direction.LEFT)
			return !(positions.get(0).column-1== positions.get(1).column && positions.get(0).line== positions.get(1).line);
		else if (mouv == Direction.UP)
			return !(positions.get(0).column== positions.get(1).column && positions.get(0).line+1== positions.get(1).line);
		else if (mouv == Direction.RIGHT)
			return !(positions.get(0).column+1== positions.get(1).column && positions.get(0).line== positions.get(1).line);
		else
			return !(positions.get(0).column== positions.get(1).column && positions.get(0).line-1== positions.get(1).line);
	}

}
