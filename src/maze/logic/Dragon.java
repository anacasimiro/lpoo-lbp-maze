package maze.logic;


/**
 * A class that represents a dragon
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Dragon extends Piece {

	private boolean dead = false;
	private boolean sleeping = false;
	private int type;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param p The position of the dragon
	 * @param type The type of the dragon
	 * 
	 */
	public Dragon(Position p, int type) {
		super(p, 'D');
		this.type = type;
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


	/**
	 * Getter for sleeping
	 *
	 * @return the sleeping
	 */
	public boolean isSleeping() {
		return sleeping;
	}


	/**
	 * Setter for sleeping
	 *
	 * @param sleeping the sleeping to set
	 */
	public void setSleeping(boolean sleeping) {
		if ( this.sleeping = sleeping ) {
			this.setSymbol('d');
		} else {
			this.setSymbol('D');
		}
	}


	/**
	 * Getter for type
	 *
	 * @return the type
	 */
	public int getType() {
		return type;
	}


	/**
	 * Setter for type
	 *
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	
}
