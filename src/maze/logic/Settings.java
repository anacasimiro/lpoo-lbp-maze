/**
 * 
 */
package maze.logic;

/**
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Settings {

	private int mazeDimension;
	private int dragonsType;
	private int numberOfDragons;
	private int numberOfSwords;
	private int numberOfShields;
	
	/**
	 * 
	 * Creates a new instance of the class
	 *
	 * @param mazeDimension
	 * @param dragonsType
	 * @param numberOfDragons
	 * @param numberOfSwords
	 * @param numberOfShields
	 */
	public Settings( int mazeDimension, int dragonsType, int numberOfDragons, int numberOfSwords, int numberOfShields) {
		this.mazeDimension = mazeDimension;
		this.dragonsType = dragonsType;
		this.numberOfDragons = numberOfDragons;
		this.numberOfSwords = numberOfSwords;
		this.numberOfShields = numberOfShields;
	}

	
	/**
	 * Getter for mazeDimension
	 *
	 * @return the mazeDimension
	 */
	public int getMazeDimension() {
		return mazeDimension;
	}

	
	/**
	 * Setter for mazeDimension
	 *
	 * @param mazeDimension the mazeDimension to set
	 */
	public void setMazeDimension(int mazeDimension) {
		this.mazeDimension = mazeDimension;
	}

	
	/**
	 * Getter for dragonsType
	 *
	 * @return the dragonsType
	 */
	public int getDragonsType() {
		return dragonsType;
	}

	
	/**
	 * Setter for dragonsType
	 *
	 * @param dragonsType the dragonsType to set
	 */
	public void setDragonsType(int dragonsType) {
		this.dragonsType = dragonsType;
	}

	
	/**
	 * Getter for numberOfDragons
	 *
	 * @return the numberOfDragons
	 */
	public int getNumberOfDragons() {
		return numberOfDragons;
	}

	
	/**
	 * Setter for numberOfDragons
	 *
	 * @param numberOfDragons the numberOfDragons to set
	 */
	public void setNumberOfDragons(int numberOfDragons) {
		this.numberOfDragons = numberOfDragons;
	}

	
	/**
	 * Getter for numberOfSwords
	 *
	 * @return the numberOfSwords
	 */
	public int getNumberOfSwords() {
		return numberOfSwords;
	}

	
	/**
	 * Setter for numberOfSwords
	 *
	 * @param numberOfSwords the numberOfSwords to set
	 */
	public void setNumberOfSwords(int numberOfSwords) {
		this.numberOfSwords = numberOfSwords;
	}

	
	/**
	 * Getter for numberOfShields
	 *
	 * @return the numberOfShields
	 */
	public int getNumberOfShields() {
		return numberOfShields;
	}

	
	/**
	 * Setter for numberOfShields
	 *
	 * @param numberOfShields the numberOfShields to set
	 */
	public void setNumberOfShields(int numberOfShields) {
		this.numberOfShields = numberOfShields;
	}

}
