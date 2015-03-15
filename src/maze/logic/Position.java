package maze.logic;

public class Position {

	private int x, y;
	
	private static final int UP		= 0;
	private static final int RIGHT	= 1;
	private static final int DOWN	= 2;
	private static final int LEFT	= 3;

	
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
	
	public boolean isEqual(Position p) {
		return this.x == p.getX() && this.y == p.getY();
	}
	public boolean isAdjacent(Position p) {
		return Math.abs( this.x - p.getX() ) + Math.abs( this.y - p.getY() ) <= 1;
	}
	
	
	// Other methods
	
	public Position next(int direction) {
		
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
		}
		
		return p;
		
	}
	
}
