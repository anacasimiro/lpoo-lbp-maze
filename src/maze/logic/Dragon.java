package maze.logic;

public class Dragon extends Piece {

	private boolean dead;
	
	
	// Constructor
	
	public Dragon(Position p) {
		super(p, 'D');
		this.dead = false;
	}

	
	// Getters and Setters
	
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	
}
