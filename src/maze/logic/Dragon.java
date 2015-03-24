package maze.logic;

import java.util.Random;

public class Dragon extends Piece {

	private boolean dead;
	private boolean sleeping;
	
	
	// Constructor
	
	public Dragon(Position p) {
		super(p, 'D');
		this.dead = false;
		
		Random random = new Random();
		this.setSleeping( random.nextBoolean() );
	}

	
	// Getters and Setters
	
	public boolean isDead() {
		return this.dead;
	}
	public boolean isSleeping() {
		return this.sleeping;
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

	
}
