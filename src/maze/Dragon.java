package maze;

public class Dragon {

	private Position position;
	private boolean dead;
	private char symbol;
	
	public Dragon() {
		this.position = new Position(1, 3);
		this.dead = false;
		this.symbol = 'D';
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
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
