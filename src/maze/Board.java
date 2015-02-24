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
		
		for ( int y = 0; y < height; y++ ) {
			
			for ( int x = 0; x < width; x++ ) {
				
				if ( x == EXIT_X && y == EXIT_Y ) {
					
					this.board[x][y] = 'S';
					
				} else {
					
					if ( x == 0 || x == width - 1 || y == 0 || y == height - 1 ) {
						this.board[x][y] = 'X';
					} else {
						this.board[x][y] = ' ';
					}
					
				}
				
			}
			
		}
		
	}
	
	public void setCell(int x, int y, char c) {
		board[x][y] = c;
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
