package maze.logic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Maze {
	
	private Board board;
	private Hero hero;
	private ArrayList<Dragon> dragons;
	private ArrayList<Sword> swords;
	private boolean victory;
	
	private static final int UP		= 0;
	private static final int RIGHT	= 1;
	private static final int DOWN	= 2;
	private static final int LEFT	= 3;
	
	
	// Constructor
	
	public Maze(int boardDimension, int dragonsCount, int swordsCount) {
		
		this.board		= new Board( boardDimension );
		this.hero 		= new Hero( new Position(1, 1) );
		this.dragons	= new ArrayList<Dragon>();
		this.swords		= new ArrayList<Sword>();
		this.victory	= false;
		
		Scanner scanner	= new Scanner(System.in);
		String input;
		
		// Add dragons
		for ( int i = 0; i < dragonsCount; i++ ) {
			this.newDragon();			
		}
		
		// Add swords
		for ( int i = 0; i < swordsCount; i++ ) {
			this.newSword();			
		}
		
		this.drawPieces();
		this.board.display();

		do {
			
			System.out.print("\n> ");
			input = scanner.nextLine();
			
			if ( input.toUpperCase().equals("Q") ) {
				break;
			}
			
			if ( !this.moveHero( this.direction(input) ) ) {
				board.display();
				continue;
			}
			
			this.updatePieces();
			this.drawPieces();
			board.display();
			
		} while( !victory && !this.hero.isDead() );
		
		if ( victory ) {
			System.out.println("\nYou won! :)");
		} else {
			System.out.println("\nYou lost! :(");
		}
		
		scanner.close();
		
	}
	
	
	// Pieces methods
	
	private void newDragon() {
		
		Position dragonPosition;
		
		do {
			dragonPosition = this.randomEmptyPosition();
		} while ( dragonPosition.isAdjacent( this.hero.getPosition() ) );
		
		this.dragons.add( new Dragon( dragonPosition ) );
		
	}
	private void newSword() {
		this.swords.add( new Sword( this.randomEmptyPosition() ) );
	}	
	private boolean moveHero(int direction) {
		
		ArrayList<Integer> possibleMoves = this.getPossibleMoves( this.hero.getPosition() );
		Position nextPosition = this.hero.getPosition().next(direction);
		
		if ( possibleMoves.contains(direction) || ( nextPosition.isEqual( this.board.getExit() ) && this.hero.isArmed() ) ) {
			this.board.setSymbol(this.hero.getPosition(), ' ');
			this.hero.setPosition( nextPosition );
			return true;
		} else {
			return false;
		}
			
	}
	private void moveDragon(Dragon dragon) {
		
		ArrayList<Integer> possibleMoves;
		Position nextPosition;
		Random random = new Random();
	
		possibleMoves = this.getPossibleMoves( dragon.getPosition() );
		nextPosition = dragon.getPosition().next( possibleMoves.get( random.nextInt( possibleMoves.size() ) ) );
		this.board.setSymbol( dragon.getPosition() , ' ');
		dragon.setPosition( nextPosition );
		
	}
	private void drawPieces() {
		
		// Draw Swords
		for ( int i = 0; i < this.swords.size(); i++ ) {
			this.board.setSymbol(this.swords.get(i).getPosition(), this.swords.get(i).getSymbol());
		}

		// Draw Dragons
		for ( int i = 0; i < this.dragons.size(); i++ ) {
			if ( this.board.getSymbol( this.dragons.get(i).getPosition() ) == 'E' ) {
				this.board.setSymbol(this.dragons.get(i).getPosition(), 'F');
			} else {
				this.board.setSymbol(this.dragons.get(i).getPosition(), this.dragons.get(i).getSymbol());
			}
		}
		
		// Draw Hero
		board.setSymbol(this.hero.getPosition(), this.hero.getSymbol());
		
	}
	private void updatePieces() {
		
		// Hero
		if ( this.hero.getPosition().isEqual( this.board.getExit() ) ) {
			this.victory = true;
			return;
		}
		
		// Dragons
		for ( int i = 0; i < this.dragons.size(); i++ ) {
			
			moveDragon( this.dragons.get(i) );
			
			if ( this.dragons.get(i).getPosition().isAdjacent( this.hero.getPosition() ) ) {
			
				if ( this.hero.isArmed() ) {
					this.board.setSymbol( this.dragons.get(i).getPosition() , ' ');
					this.dragons.remove(i--);
				} else {
					this.hero.setDead(true);
				}
				
			}
			
		}
		
		// Swords
		for ( int i = 0; i < this.swords.size(); i++ ) {
			
			if ( this.swords.get(i).getPosition().isEqual( this.hero.getPosition() ) ) {
				
				this.hero.setArmed(true);
				this.swords.remove(i--);
				
			}
			
		}
		
	}
	
		
	// Other methods
	
	private int direction(String input) {
		
		switch (input.toUpperCase()) {
			case "W":
				return UP;
			case "D":
				return RIGHT;
			case "S":
				return DOWN;
			case "A":
				return LEFT;
			default:
				return -1;
		}
		
	}
	private ArrayList<Integer> getPossibleMoves(Position p) {
		
		ArrayList<Integer> moves = new ArrayList<Integer>();
		char topSymbol		= this.board.getSymbol( new Position(p.getX(), p.getY() - 1) );
		char rightSymbol	= this.board.getSymbol( new Position(p.getX() + 1, p.getY()) );
		char bottomSymbol	= this.board.getSymbol( new Position(p.getX(), p.getY() + 1) );
		char leftSymbol		= this.board.getSymbol( new Position(p.getX() - 1, p.getY()) );
		
		
		// Up
		if ( topSymbol != 'X' && topSymbol != 'S' ) {
			moves.add(UP);
		}
		
		// Right
		if ( rightSymbol != 'X' && rightSymbol != 'S' ) {
			moves.add(RIGHT);
		}
		
		// Down
		if ( bottomSymbol != 'X' && bottomSymbol != 'S' ) {
			moves.add(DOWN);
		}
		
		// Left
		if ( leftSymbol != 'X' && leftSymbol != 'S' ) {
			moves.add(LEFT);
		}
		
		return moves;
		
	}
	private Position randomEmptyPosition() {
		
		Position p = new Position(0, 0);
		Random random = new Random();
		
		do {
			p.setX( random.nextInt( board.getDimension() - 2 ) + 1 );
			p.setY( random.nextInt( board.getDimension() - 2 ) + 1 );
		} while ( !this.board.isEmpty(p) );
		
		return p;
		
	}
	
	// Main function
	
	public static void main(String[] args) {
		new Maze(17, 3, 10);
	}

}
