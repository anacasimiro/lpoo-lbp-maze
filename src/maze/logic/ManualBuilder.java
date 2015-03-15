package maze.logic;

public class ManualBuilder implements IMazeBuilder {

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
