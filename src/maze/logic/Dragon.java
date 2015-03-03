package maze.logic;

public class Dragon extends Piece {

	private boolean dead;
	
	public Dragon() {
		super(new Position(1, 3), 'D');
		this.dead = false;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public Position nextPosition(int direction) {
		
		Position p = new Position(this.position);
		
		switch (direction) {
		
			case 0:
				// Up
				p.setY(p.getY() - 1);
				break;
				
			case 1:
				// Right
				p.setX(p.getX() + 1);
				break;
				
			case 2:
				// Down
				p.setY(p.getY() + 1);
				break;
				
			case 3:
				// Left
				p.setX(p.getX() - 1);
				break;
				
		}
		
		return p;
		
	}
	
}
