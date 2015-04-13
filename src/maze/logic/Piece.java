package maze.logic;

import java.io.Serializable;

/**
 * An abstract class that represents a piece of the board
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public abstract class Piece implements Serializable {

	private static final long serialVersionUID = 1L;
	Position position;
	char symbol;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param position The position of the piece
	 * @param symbol The symbol of the piece
	 * 
	 */
	public Piece(Position position, char symbol) {
		this.position = new Position(position);
		this.symbol = symbol;
	}


	/**
	 * Getter for position
	 *
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}


	/**
	 * Setter for position
	 *
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}


	/**
	 * Getter for symbol
	 *
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}


	/**
	 * Setter for symbol
	 *
	 * @param symbol the symbol to set
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
}
