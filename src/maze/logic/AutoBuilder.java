package maze.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class AutoBuilder implements MazeBuilder {

	private int boardDimension;
	private int visitedCellsDimension;
	private char board[][];
	private char visitedCells[][];
	private Position guideCell;
	private Stack<Position> pathHistory;
	
	private static final int UP		= 0;
	private static final int RIGHT	= 1;
	private static final int DOWN	= 2;
	private static final int LEFT	= 3;
	
	
	// Constructor
	
	public AutoBuilder(int dimension) {
		
		this.boardDimension = dimension;
		this.visitedCellsDimension = ( dimension - 1 ) / 2;
		this.board = new char[this.boardDimension][this.boardDimension];
		this.visitedCells = new char[this.visitedCellsDimension][this.visitedCellsDimension];
		this.pathHistory = new Stack<Position>();
		
	}
	
	
	// Build method
	
	public char[][] build(Position exit) {
				
		this.initBoard();
		this.initVisitedCells();
		this.initExit(exit);
		this.initGuideCell();
		
		Random random = new Random();
		ArrayList<Integer> possibleMoves;
		
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
	
	
	// Init methods
	
	private void initBoard() {
		
		for ( int y = 0; y < this.boardDimension; y++ ) {
			for ( int x = 0; x < this.boardDimension; x++ ) {
				this.board[x][y] = ( x % 2 == 1 && y % 2 == 1 ) ? ' ' : 'X';
			}
		}
		
	}
	private void initVisitedCells() {
		for ( int y = 0; y < this.visitedCellsDimension; y++ ) {
			Arrays.fill(this.visitedCells[y], '.');
		}
	}
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
	
	
	// Setters
	
	private void setBoardCell(Position p, char s) {
		this.board[p.getX()][p.getY()] = s;
	}
	private void setVisitedCell(Position p, char s) {
		this.visitedCells[p.getX()][p.getY()] = s;
	}
	
	
	// Guide Cell methods
	
	private ArrayList<Integer> getPossibleMoves() {
		
		ArrayList<Integer> moves = new ArrayList<Integer>();
		
		// UP
		
		if ( this.guideCell.getY() > 0 && this.visitedCells[this.guideCell.getX()][this.guideCell.getY() - 1] == '.' ) {
			moves.add(UP);
		}
		
		
		// RIGHT
		
		if ( this.guideCell.getX() < this.visitedCellsDimension - 1 && this.visitedCells[this.guideCell.getX() + 1][this.guideCell.getY()] == '.' ) {
			moves.add(RIGHT);
		}
		
		
		// DOWN
		
		if ( this.guideCell.getY() < this.visitedCellsDimension - 1 && this.visitedCells[this.guideCell.getX()][this.guideCell.getY() + 1] == '.' ) {
			moves.add(DOWN);
		}
		
		
		// LEFT
		
		if ( this.guideCell.getX() > 0 && this.visitedCells[this.guideCell.getX() - 1][this.guideCell.getY()] == '.' ) {
			moves.add(LEFT);
		}
		
		
		return moves;
		
	}
	private void moveGuideCell(int direction) {
		
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
		}
		
		this.setVisitedCell(this.guideCell, '+');
		this.pathHistory.push(new Position(this.guideCell));
		
	}
	
}
