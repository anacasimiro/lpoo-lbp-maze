package maze.logic;

public class Position {

	private int x, y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(Position p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public boolean equals(Position p) {
		return this.x == p.getX() && this.y == p.getY();
	}
	
	public boolean isAdjacent(Position p) {
		return Math.abs( this.x - p.getX() ) + Math.abs( this.y - p.getY() ) == 1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
