package maze.logic;

public class Shield extends Piece {

	private boolean taken;
	
	public Shield(Position p) {
		super(p, '$');
		this.taken = false;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
}
