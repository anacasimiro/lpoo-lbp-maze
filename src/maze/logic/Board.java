package maze.logic;

public class Board {

	private char[][] board;
	private int dimension;
	private Position exit;
	
	
	// Constructor
	
	public Board(int dimension) {
		
		if ( dimension == 0 ) {
			
			ManualBuilder manualBuilder = new ManualBuilder();
			this.exit = new Position(0, 0);
			this.board = manualBuilder.build(this.exit);
			this.dimension = 10;
			
		} else {
			
			AutoBuilder autoBuilder = new AutoBuilder(dimension);
			this.exit = new Position(0, 0);
			this.board = autoBuilder.build(this.exit);
			this.dimension = dimension;
			
		}
		
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