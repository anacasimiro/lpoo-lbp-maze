package maze.logic;

public class Board {

	private int height;
	private int width;
	private char[][] board;
	private char wallSymbol;
	private char exitSymbol;
	private Position exit;
	
	ManualBuilder manualBuilder = new ManualBuilder();
	
	public Board(int height, int width) {
		this.height	= height;
		this.width	= width;
		this.board	= manualBuilder.build();
		this.wallSymbol	= 'X';
		this.exitSymbol = 'S';
		this.exit 	= new Position(9, 5);
	}

	public char getSymbol(Position p) {
		return board[p.getX()][p.getY()];
	}
	
	public void setSymbol(Position p, char c) {
		board[p.getX()][p.getY()] = c;
	}
	
	public Position getExit() {
		return this.exit;
	}
	
	public boolean isWall(Position p) {
		return board[p.getX()][p.getY()] == wallSymbol;
	}
	
	public void print() {
		
		for ( int i = 0; i < 50; i++ ) {
			System.out.println();
		}
		
		for ( int y = 0; y < height; y++ ) {
			
			for ( int x = 0; x < width; x++ ) {
				System.out.print(this.board[x][y]);
			}
			
			System.out.println();
			
		}
		
	}
	
}