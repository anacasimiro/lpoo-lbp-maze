package maze.logic;

/**
 * An Enum to represent movements
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public enum Direction {

	UP(0), RIGHT(1), DOWN(2), LEFT(3), NONE(-1);
	
	private int value;
	
	private Direction(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
