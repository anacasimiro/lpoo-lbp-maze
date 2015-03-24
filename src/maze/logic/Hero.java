package maze.logic;

public class Hero extends Piece {

	private boolean armed		= false;
	private boolean shielded	= false;
	private boolean dead		= false;
	
	
	// Constructor
	
	public Hero(Position p) {
		super(p, 'H');
	}
	
	
	// Getters and Setters

	public boolean isArmed() {
		return this.armed;
	}
	public boolean isShielded() {
		return this.shielded;
	}
	public boolean isDead() {
		return this.dead;
	}
	public void setArmed(boolean armed) {
		if ( this.armed = armed ) {
			this.symbol = 'A';
		}
	}
	public void setShielded(boolean shielded) {
		if ( this.shielded = shielded ) {
			this.symbol = '';
		}
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
}