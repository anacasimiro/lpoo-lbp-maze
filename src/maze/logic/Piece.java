package maze.logic;

public class Piece {

	Position position;
	Position previousPosition;
	char symbol;
	
	public Piece(Position position, char symbol) {
		this.position = new Position(position);
		this.symbol = symbol;
	}

	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPreviousPosition() {
		return previousPosition;
	}
	
	public void setPreviousPosition(Position previousPosition) {
		this.previousPosition = previousPosition;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
}
