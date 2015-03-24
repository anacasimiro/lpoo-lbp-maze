package maze.logic;

public class Board {

	private char[][] board;
	private int dimension;
	private Position exit;
	
	
	// Constructor
	
	public Board(int dimension) {
		
		IMazeBuilder mazeBuilder = dimension == 0 ? new ManualBuilder() : new AutoBuilder(dimension);
		this.exit = new Position(0, 0);
		this.board = mazeBuilder.build(this.exit);
		this.dimension = dimension == 0 ? 10 : dimension;
		
	}

	
	// Getters and Setters
	
	public char getSymbol(Position p) {
		return board[p.getX()][p.getY()];
	}
	public int getDimension() {
		return this.dimension;
	}
	public Position getExit() {
		return this.exit;
	}
	public void setSymbol(Position p, char c) {
		board[p.getX()][p.getY()] = c;
	}
	
	// Other methods
	
	public boolean isWall(Position p) {
		return board[p.getX()][p.getY()] == 'X';
	}
	public boolean isEmpty(Position p) {
		return board[p.getX()][p.getY()] == ' ';
	}
	public void display() {
		
		for ( int i = 0; i < 50; i++ ) {
			System.out.println();
		}
		
		for ( int y = 0; y < board.length; y++ ) {
			
			for ( int x = 0; x < board.length; x++ ) {
				System.out.print(this.board[x][y] + " ");
			}
			
			System.out.println();
			
		}
		
	}
	
}