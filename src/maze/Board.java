package maze;

public class Board {

	private int height;
	private int width;
	private char[][] board;
	private char wallSymbol;
	private char exitSymbol;
	private Position exit;
	
	public Board(int height, int width) {
		this.height	= height;
		this.width	= width;
		this.board	= new char[width][height];
		this.wallSymbol	= 'X';
		this.exitSymbol = 'S';
		this.exit 	= new Position(9, 5);
	}
	
	public void init() {
		
		// Draw outer wallSymbols
		for ( int y = 0; y < height; y++ ) {
			
			for ( int x = 0; x < width; x++ ) {
					
				if ( x == 0 || x == width - 1 || y == 0 || y == height - 1 ) {
					this.board[x][y] = wallSymbol;
				} else {
					this.board[x][y] = ' ';
				}
				
			}
			
		}
		
		// Create inner wallSymbols
		this.board[2][2] = wallSymbol;
		this.board[2][3] = wallSymbol;
		this.board[2][4] = wallSymbol;
		this.board[2][6] = wallSymbol;
		this.board[2][7] = wallSymbol;
		this.board[2][8] = wallSymbol;
		this.board[3][2] = wallSymbol;
		this.board[3][3] = wallSymbol;
		this.board[3][4] = wallSymbol;
		this.board[3][6] = wallSymbol;
		this.board[3][7] = wallSymbol;
		this.board[3][8] = wallSymbol;
		this.board[5][2] = wallSymbol;
		this.board[5][3] = wallSymbol;
		this.board[5][4] = wallSymbol;
		this.board[5][6] = wallSymbol;
		this.board[5][7] = wallSymbol;
		this.board[7][2] = wallSymbol;
		this.board[7][3] = wallSymbol;
		this.board[7][4] = wallSymbol;
		this.board[7][5] = wallSymbol;
		this.board[7][6] = wallSymbol;
		this.board[7][7] = wallSymbol;
		this.board[exit.getX()][exit.getY()] = exitSymbol;
		
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