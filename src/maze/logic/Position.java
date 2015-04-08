package maze.logic;

public class Position {

	private int x, y;
	
	
	// Constructors
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Position(Position p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	
	// Getters and Setters
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}	
	public void setY(int y) {
		this.y = y;
	}
	
	
	// Comparison methods
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return this.getX() == other.getX() && this.getY() == other.getY();
	}
	
	public boolean isAdjacent(Position p) {
		return Math.abs( this.x - p.getX() ) + Math.abs( this.y - p.getY() ) <= 1;
	}
	
	
	// Other methods
	
	public Position next(Direction direction) {
		
		Position p = new Position(this);
		
		switch (direction) {
			case UP:
				p.setY(this.y - 1);
			break;
			case RIGHT:
				p.setX(this.x + 1);
			break;
			case DOWN:
				p.setY(this.y + 1);
			break;
			case LEFT:
				p.setX(this.x - 1);
			break;
			default:
				
			break;
		}
		
		return p;
		
	}
	
}
