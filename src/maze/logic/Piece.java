package maze.logic;

public class Piece {

	Position position;
	char symbol;
	
	
	// Constructors
	
	public Piece(Position position, char symbol) {
		this.position = new Position(position);
		this.symbol = symbol;
	}

	
	// Getters and Setters
	
	public Position getPosition() {
		return position;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
}
