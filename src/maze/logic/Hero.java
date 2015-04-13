package maze.logic;

/**
 * A class that represents the hero
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Hero extends Piece {

	private static final long serialVersionUID = 1L;
	private boolean armed		= false;
	private boolean shielded	= false;
	private boolean dead		= false;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param p The position of the hero
	 * 
	 */
	public Hero(Position p) {
		super(p, 'H');
	}


	/**
	 * Getter for armed
	 *
	 * @return the armed
	 */
	public boolean isArmed() {
		return armed;
	}


	/**
	 * Setter for armed
	 *
	 * @param armed the armed to set
	 */
	public void setArmed(boolean armed) {
		
		if ( this.armed = armed ) {
		
			if ( this.shielded ) {
				this.symbol = 'Y';				
			} else {
				this.symbol = 'A';
			}
			
		}
		
	}


	/**
	 * Getter for shielded
	 *
	 * @return the shielded
	 */
	public boolean isShielded() {
		return shielded;
	}


	/**
	 * Setter for shielded
	 *
	 * @param shielded the shielded to set
	 */
	public void setShielded(boolean shielded) {
		
		if ( this.shielded = shielded ) {
			
			if ( this.armed ) {
				this.symbol = 'Y';				
			} else {
				this.symbol = 'P';
			}
			
		}
		
	}


	/**
	 * Getter for dead
	 *
	 * @return the dead
	 */
	public boolean isDead() {
		return dead;
	}


	/**
	 * Setter for dead
	 *
	 * @param dead the dead to set
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
}