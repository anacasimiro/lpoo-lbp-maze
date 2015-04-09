package maze.logic;


/**
 * A class to generate the demo maze
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class ManualBuilder implements MazeBuilder {

	
	/**
	 * Builds a new maze
	 * 
	 * @param exit A Position to store the exit
	 * 
	 * @return a char matrix representing the maze
	 */
	public char[][] build(Position exit) {
		
		char board[][] = {
				{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},
				{'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', 'X', 'X', 'X', ' ', 'X', 'X', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X'},
				{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				{'X', 'X', 'X', 'X', 'X', 'S', 'X', 'X', 'X', 'X'}
		};
		
		exit.setX(9);
		exit.setY(5);
		
		return board;
		
	}
	
}
