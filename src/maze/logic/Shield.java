package maze.logic;

/**
 * A class that represents a shield
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Shield extends Piece {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param p The position of the shield
	 */
	public Shield(Position p) {
		super(p, 'C');
	}
	
}
