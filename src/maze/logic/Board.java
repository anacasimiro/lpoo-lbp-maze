package maze.logic;

import java.io.Serializable;

/**
 * A class that represents the board of a maze
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Board implements Serializable {

	private static final long serialVersionUID = 1L;
	private char[][] board;
	private int dimension;
	private Position exit;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param dimension The dimension of the board
	 */
	public Board(int dimension) {
		
		MazeBuilder mazeBuilder = dimension == 0 ? new ManualBuilder() : new AutoBuilder(dimension);
		this.exit = new Position(0, 0);
		this.board = mazeBuilder.build(this.exit);
		this.dimension = dimension == 0 ? 10 : dimension;
		
	}
	
	
	/**
	 * Creates a new instance of the class with a user-created board
	 *
	 * @param board The board
	 */
	public Board(char[][] board) {
		this.board = board;
		this.dimension = board.length;
	}


	/**
	 * Gives the symbol currently on the given position
	 * 
	 * @param p The position
	 * 
	 * @return the symbol
	 */
	public char getSymbol(Position p) {
		return board[p.getX()][p.getY()];
	}
	
	
	/**
	 * Getter for dimension
	 * 
	 * @return the dimension of the board
	 */
	public int getDimension() {
		return this.dimension;
	}
	
	
	/**
	 * Getter for exit
	 * 
	 * @return the position of the exit
	 */
	public Position getExit() {
		return this.exit;
	}
	
	
	/**
	 * Getter for board
	 * 
	 * @return the board
	 */
	public char[][] getBoard() {
		return this.board;
	}
	
	
	/**
	 * Setter for exit
	 * 
	 * @param exit The exit position
	 */
	public void setExit(Position exit) {
		this.exit = exit;
	}
	
	
	/**
	 * Sets the symbol on a position of the board
	 * 
	 * @param p The position
	 * @param c The symbol
	 */
	public void setSymbol(Position p, char c) {
		board[p.getX()][p.getY()] = c;
	}
	
	
	/**
	 * Checks if a current position is a wall
	 * 
	 * @param p The position
	 * 
	 * @return true if position is a wall, false otherwise
	 */
	public boolean isWall(Position p) {
		return board[p.getX()][p.getY()] == 'X';
	}
	
	
	/**
	 * Checks if a position is empty
	 * 
	 * @param p The position
	 * 
	 * @return true if position is empty, false otherwise
	 */
	public boolean isEmpty(Position p) {
		return board[p.getX()][p.getY()] == ' ';
	}
	
	
	/**
	 * Checks if a position is on the edge of the board 
	 * 
	 * @param p The position
	 * 
	 * @return true if position is on edge, false otherwise
	 */
	public boolean isEdge(Position p) {
		
		return p.getX() == 0 || p.getY() == 0 || p.getX() == dimension - 1 || p.getY() == dimension - 1;
		
	}
	
	
	/**
	 * Checks if a position is a corner of the board 
	 * 
	 * @param p The position
	 * 
	 * @return true if position is a corner, false otherwise
	 */
	public boolean isCorner(Position p) {
		
		return 	(p.getX() == 0 && p.getY() == 0) ||
				(p.getX() == dimension - 1 && p.getY() == 0) ||
				(p.getX() == 0 && p.getY() == dimension - 1) ||
				(p.getX() == dimension - 1 && p.getY() == dimension - 1);
		
	}
	
}