package maze;

public class Board {

	private int height;
	private int width;
	private char[][] board;
	
	private static final int EXIT_X = 9;
	private static final int EXIT_Y = 5;
	
	public Board(int height, int width) {
		this.height	= height;
		this.width	= width;
		this.board	= new char[width][height];
	}
	
	public void init() {
		
		// Draw outer walls
		for ( int y = 0; y < height; y++ ) {
			
			for ( int x = 0; x < width; x++ ) {
					
				if ( x == 0 || x == width - 1 || y == 0 || y == height - 1 ) {
					this.board[x][y] = 'X';
				} else {
					this.board[x][y] = ' ';
				}
				
			}
			
		}
		
		// Create inner walls
		this.board[2][2] = 'X';
		this.board[2][3] = 'X';
		this.board[2][4] = 'X';
		this.board[2][6] = 'X';
		this.board[2][7] = 'X';
		this.board[2][8] = 'X';
		this.board[3][2] = 'X';
		this.board[3][3] = 'X';
		this.board[3][4] = 'X';
		this.board[3][6] = 'X';
		this.board[3][7] = 'X';
		this.board[3][8] = 'X';
		this.board[5][2] = 'X';
		this.board[5][3] = 'X';
		this.board[5][4] = 'X';
		this.board[5][6] = 'X';
		this.board[5][7] = 'X';
		this.board[7][2] = 'X';
		this.board[7][3] = 'X';
		this.board[7][4] = 'X';
		this.board[7][5] = 'X';
		this.board[7][6] = 'X';
		this.board[7][7] = 'X';
		this.board[EXIT_X][EXIT_Y] = 'S';
		
	}

	public char getSymbol(Position p) {
		return board[p.getX()][p.getY()];
	}
	
	public void setSymbol(Position p, char c) {
		board[p.getX()][p.getY()] = c;
	}
	
	public Position getExitPosition() {
		return new Position(EXIT_X, EXIT_Y);
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