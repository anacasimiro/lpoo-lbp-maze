package maze;

public class Hero {

	private Position position;
	private char symbol;
	
	public Hero(Position p) {
		this.position = p;
		this.symbol	= 'H';
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
	
	public Position nextPosition(int direction) {
	
		Position p = new Position(this.position);
		
		switch (direction) {
		
			case 0:
				// Up
				p.setY(p.getY() - 1);
				break;
				
			case 1:
				// Right
				p.setX(p.getX() + 1);
				break;
				
			case 2:
				// Down
				p.setY(p.getY() + 1);
				break;
				
			case 3:
				// Left
				p.setX(p.getX() - 1);
				break;
				
		}
		
		return p;
		
	}
	
}
