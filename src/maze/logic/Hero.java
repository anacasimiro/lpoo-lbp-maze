package maze.logic;

public class Hero extends Piece {

	private boolean hasSword;
	
	public Hero(Position p) {
		super(new Position(1, 1), 'H');
		this.hasSword = false;
	}

	public boolean getHasSword() {
		return hasSword;
	}

	public void setHasSword(boolean sword) {
		if ( sword ) {
			this.symbol = 'A';
		}
		this.hasSword = sword;
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
