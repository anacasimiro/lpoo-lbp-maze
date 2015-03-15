package maze.logic;

public class Hero extends Piece {

	private boolean armed;
	private boolean dead;
	
	
	// Constructor
	
	public Hero(Position p) {
		super(p, 'H');
		this.armed = false;
	}
	
	
	// Getters and Setters

	public boolean isArmed() {
		return this.armed;
	}
	public boolean isDead() {
		return this.dead;
	}
	public void setArmed(boolean armed) {
		if ( this.armed = armed ) {
			this.symbol = 'A';
		}
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
}