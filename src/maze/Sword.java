package maze;

public class Sword {

	private Position position;
	private boolean taken;
	private char symbol;
	
	public Sword() {
		this.position = new Position(1, 4);
		this.taken = false;
		this.symbol = 'E';
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
}
