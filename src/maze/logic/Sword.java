package maze.logic;

/**
 * A class that represents a sword
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Sword extends Piece {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param p The position of the sword
	 */
	public Sword(Position p) {
		super(p, 'E');
	}
	
}
