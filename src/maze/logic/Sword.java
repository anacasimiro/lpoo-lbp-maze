package maze.logic;

public class Sword extends Piece {

	private boolean taken;
	
	public Sword() {
		super(new Position(1, 4), 'E');
		this.taken = false;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
}
