package maze.logic;


/**
 * An interface for the classes that generate Mazes
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public interface MazeBuilder {

	
	/**
	 * Builds a new maze
	 * 
	 * @param exit The position of the exit
	 * 
	 * @return a char matrix representing the maze
	 */
	public char[][] build(Position exit);
	
}
