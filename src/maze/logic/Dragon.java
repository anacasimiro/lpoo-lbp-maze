package maze.logic;

public class Dragon extends Piece {

	private boolean dead = false;
	private boolean sleeping = false;
	private int type;
	
	
	// Constructor
	
	public Dragon(Position p, int type) {
		super(p, 'D');
		this.type = type;
	}

	
	// Getters and Setters
	
	public boolean isDead() {
		return this.dead;
	}
	public boolean isSleeping() {
		return this.sleeping;
	}
	public int getType() {
		return this.type;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
		if ( sleeping ) {
			this.setSymbol('d');
		} else {
			this.setSymbol('D');
		}
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
