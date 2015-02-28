package maze;

public class Hero {

	private int x;
	private int y;
	private char symbol;
	
	public Hero(int x, int y) {
		this.x		= x;
		this.y		= y;
		this.symbol	= 'H';
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
