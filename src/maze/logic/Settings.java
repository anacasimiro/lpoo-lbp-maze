package maze.logic;

import java.io.Serializable;

/**
 * A class that represents the Maze settings
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Settings implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mazeDimension;
	private DragonType dragonsType;
	private int numberOfDragons;
	private int numberOfSwords;
	private int numberOfShields;
	
	
	/**
	 * Creates a new instance of the class with default parameters
	 *
	 */
	public Settings() {
		this.mazeDimension = 17;
		this.dragonsType = DragonType.MOVING_SLEEPING;
		this.numberOfDragons = 4;
		this.numberOfSwords = 2;
		this.numberOfShields = 1;
	}
	
	
	/**
	 * Creates a new instance of the class with the given parameters
	 *
	 * @param mazeDimension The maze dimension
	 * @param dragonsType The dragons type
	 * @param numberOfDragons The number of dragons
	 * @param numberOfSwords The number of swords
	 * @param numberOfShields The number of shields
	 */
	public Settings( int mazeDimension, DragonType dragonsType, int numberOfDragons, int numberOfSwords, int numberOfShields) {
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
	public DragonType getDragonsType() {
		return dragonsType;
	}

	
	/**
	 * Setter for dragonsType
	 *
	 * @param dragonsType the dragonsType to set
	 */
	public void setDragonsType(DragonType dragonsType) {
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
