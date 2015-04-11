package maze.logic;

/**
 * An Enum to represent Dragon Types
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public enum DragonType {

	STILL(1), MOVING(2), MOVING_SLEEPING(3);
	
	private int value;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param value The value of the dragon type
	 */
	private DragonType(int value) {
		this.value = value;
	}


	/**
	 * Getter for value
	 *
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}
	
	
	@Override
	public String toString() {
		
		switch (this.value) {
			case 1:
				return "Still";
			case 2:
				return "Moving";
			case 3:
				return "Moving and Sleeping";
			default:
				return "";
		}
		
	}
	
}
