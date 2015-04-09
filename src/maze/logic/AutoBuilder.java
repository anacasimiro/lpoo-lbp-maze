package maze.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;


/**
 * A class to randomly generate a new maze
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class AutoBuilder implements MazeBuilder {

	private int boardDimension;
	private int visitedCellsDimension;
	private char board[][];
	private char visitedCells[][];
	private Position guideCell;
	private Stack<Position> pathHistory;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param dimension The Maze dimension
	 */
	public AutoBuilder(int dimension) {
		
		this.boardDimension = dimension;
		this.visitedCellsDimension = ( dimension - 1 ) / 2;
		this.board = new char[this.boardDimension][this.boardDimension];
		this.visitedCells = new char[this.visitedCellsDimension][this.visitedCellsDimension];
		this.pathHistory = new Stack<Position>();
		
	}
	
	
	/**
	 * Builds a new maze
	 * 
	 * @param exit A Position to store the exit
	 * 
	 * @return a char matrix representing the maze
	 */
	public char[][] build(Position exit) {
				
		this.initBoard();
		this.initVisitedCells();
		this.initExit(exit);
		this.initGuideCell();
		
		Random random = new Random();
		ArrayList<Direction> possibleMoves;
		
		do {
		
			possibleMoves = this.getPossibleMoves();
			
			if ( possibleMoves.size() > 0 ) {
				this.moveGuideCell( possibleMoves.get( random.nextInt( possibleMoves.size() ) ) );
			} else {
				this.guideCell = new Position(this.pathHistory.pop());
			}
		
		} while ( !this.pathHistory.empty() );
		
		return this.board;
		
	}
	
	
	/**
	 * Prepares the board for the application of the maze generation algorithm
	 * 
	 */
	private void initBoard() {
		
		for ( int y = 0; y < this.boardDimension; y++ ) {
			for ( int x = 0; x < this.boardDimension; x++ ) {
				this.board[x][y] = ( x % 2 == 1 && y % 2 == 1 ) ? ' ' : 'X';
			}
		}
		
	}

	
	/**
	 * Prepares the visitedCells array fot the application of the maze generation algorithm
	 * 
	 */
	private void initVisitedCells() {
		for ( int y = 0; y < this.visitedCellsDimension; y++ ) {
			Arrays.fill(this.visitedCells[y], '.');
		}
	}

	
	/**
	 * Puts an exit on the maze
	 * 
	 * @param exit The position of the exit
	 */
	private void initExit(Position exit) {
		
		int x, y;
		Random random = new Random();
		
		if ( random.nextBoolean() ) {
			
			// Horizontal
			y = random.nextBoolean() ? 0 : this.boardDimension - 1;
			x = random.nextInt( this.visitedCellsDimension ) * 2 + 1;
			
		} else {
			
			// Vertical
			y = random.nextInt( this.visitedCellsDimension ) * 2 + 1;
			x = random.nextBoolean() ? 0 : this.boardDimension - 1;
			
		}
		
		exit.setX(x);
		exit.setY(y);
		this.setBoardCell(exit, 'S');
		
	}

	
	
	/**
	 * Places the guideCell for the application of the maze generation algorithm
	 * 
	 */
	private void initGuideCell() {
		
		int x, y;
		Random random = new Random();
		
		if ( random.nextBoolean() ) {
			
			// Horizontal
			y = random.nextBoolean() ? 0 : this.visitedCellsDimension - 1;
			x = random.nextInt( this.visitedCellsDimension );
			
		} else {
			
			// Vertical
			y = random.nextInt( this.visitedCellsDimension );
			x = random.nextBoolean() ? 0 : this.visitedCellsDimension - 1;
			
		}
		
		this.setVisitedCell(this.guideCell = new Position(x, y), '+');
		this.pathHistory.push(new Position(this.guideCell));
		
	}
	
	
	/**
	 * Sets a symbol on a board cell
	 * 
	 * @param p The position of the cell
	 * @param s The symbol
	 */
	private void setBoardCell(Position p, char s) {
		this.board[p.getX()][p.getY()] = s;
	}
	
	
	/**
	 * Marks a board cell as visited
	 * 
	 * @param p The position of the cell
	 * @param s The symbol
	 */
	private void setVisitedCell(Position p, char s) {
		this.visitedCells[p.getX()][p.getY()] = s;
	}
	
	
	/**
	 * Calculates the possible moves for the guide cell
	 * 
	 * @return an ArrayList containing the possible moves
	 */
	private ArrayList<Direction> getPossibleMoves() {
		
		ArrayList<Direction> moves = new ArrayList<Direction>();
		
		// UP
		
		if ( this.guideCell.getY() > 0 && this.visitedCells[this.guideCell.getX()][this.guideCell.getY() - 1] == '.' ) {
			moves.add(Direction.UP);
		}
		
		
		// RIGHT
		
		if ( this.guideCell.getX() < this.visitedCellsDimension - 1 && this.visitedCells[this.guideCell.getX() + 1][this.guideCell.getY()] == '.' ) {
			moves.add(Direction.RIGHT);
		}
		
		
		// DOWN
		
		if ( this.guideCell.getY() < this.visitedCellsDimension - 1 && this.visitedCells[this.guideCell.getX()][this.guideCell.getY() + 1] == '.' ) {
			moves.add(Direction.DOWN);
		}
		
		
		// LEFT
		
		if ( this.guideCell.getX() > 0 && this.visitedCells[this.guideCell.getX() - 1][this.guideCell.getY()] == '.' ) {
			moves.add(Direction.LEFT);
		}
		
		
		return moves;
		
	}


	/**
	 * Moves the guide cell
	 * 
	 * @param direction The direction of the movement
	 */
	private void moveGuideCell(Direction direction) {
		
		switch (direction) {
			case UP:
				this.setBoardCell(new Position(this.guideCell.getX() * 2 + 1, this.guideCell.getY() * 2), ' ');
				this.guideCell.setY(this.guideCell.getY() - 1);
			break;
				
			case RIGHT:
				this.setBoardCell(new Position(this.guideCell.getX() * 2 + 2, this.guideCell.getY() * 2 + 1), ' ');
				this.guideCell.setX(this.guideCell.getX() + 1);
			break;
				
			case DOWN:
				this.setBoardCell(new Position(this.guideCell.getX() * 2 + 1, this.guideCell.getY() * 2 + 2), ' ');
				this.guideCell.setY(this.guideCell.getY() + 1);
			break;
				
			case LEFT:
				this.setBoardCell(new Position(this.guideCell.getX() * 2, this.guideCell.getY() * 2 + 1), ' ');
				this.guideCell.setX(this.guideCell.getX() - 1);
			break;
			
			default:
				
			break;
		}
		
		this.setVisitedCell(this.guideCell, '+');
		this.pathHistory.push(new Position(this.guideCell));
		
	}
	
}
