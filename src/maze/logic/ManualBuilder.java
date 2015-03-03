package maze.logic;

public class ManualBuilder implements IMazeBuilder {

	public char[][] build() {
		
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
		
		return board;
		
	}
	
}
