package maze.logic;


/**
 * A class to represent a position on the maze
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Position {

	private int x, y;
	

	/**
	 * Creates a new instance of the class
	 *
	 * @param x The horizontal coordinate
	 * @param y The vertical coordinate
	 * 
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * The Copy Constructor
	 *
	 * @param p The position to copy
	 */
	public Position(Position p) {
		this.x = p.getX();
		this.y = p.getY();
	}
	
	
	/**
	 * Getter for x
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * Setter for x
	 *
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * Getter for y
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * Setter for y
	 *
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	
	/**
	 * Checks if two positions are adjacent
	 * 
	 * @param p The other Position
	 * 
	 * @return true if positions are adjacent, false otherwise
	 */
	public boolean isAdjacent(Position p) {
		return Math.abs( this.x - p.getX() ) + Math.abs( this.y - p.getY() ) <= 1;
	}
	
	
	/**
	 * Calculates the next position after a move towards a given direction
	 * 
	 * @param direction The direction of the movement
	 * 
	 * @return the next position
	 */
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
	
}
