package maze.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * The main class that represents a game
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Maze {
	
	private Settings settings;
	private Board board;
	private Hero hero;
	private ArrayList<Dragon> dragons	= new ArrayList<Dragon>();
	private ArrayList<Sword> swords		= new ArrayList<Sword>();
	private ArrayList<Shield> shields	= new ArrayList<Shield>();
	private boolean victory				= false;
	
	
	/**
	 * 
	 * Creates a new instance of the class
	 *
	 * @param config
	 */
	public Maze(Settings settings) {
		
		this.settings	= settings;
		this.board		= new Board( this.settings.getMazeDimension() );
		this.hero 		= new Hero( this.randomEmptyPosition() );
		
		// Add dragons
		for ( int i = 0; i < this.settings.getNumberOfDragons(); i++ ) {
			this.newDragon(this.settings.getDragonsType());
		}
		
		// Add swords
		for ( int i = 0; i < this.settings.getNumberOfSwords(); i++ ) {
			this.newSword();			
		}
		
		// Add shields
		for ( int i = 0; i < this.settings.getNumberOfShields(); i++ ) {
			this.newShield();			
		}
		
		this.drawPieces();
		
	}
	
	
	/**
	 * Updates the maze
	 * 
	 * @param heroDirection
	 * 
	 * @return true if game ended, false otherwise
	 */
	public boolean update(Direction heroDirection) {
		
		this.moveHero( heroDirection );
		this.updatePieces();
		this.drawPieces();
		
		return this.victory || this.hero.isDead();
		
	}
	
	
	// Pieces methods
	
	private void newDragon(int type) {
		
		Position dragonPosition;
		
		do {
			dragonPosition = this.randomEmptyPosition();
		} while ( dragonPosition.isAdjacent( this.hero.getPosition() ) );
		
		this.dragons.add( new Dragon( dragonPosition, type ) );
		
	}
	private void newSword() {
		this.swords.add( new Sword( this.randomEmptyPosition() ) );
	}
	private void newShield() {
		this.shields.add( new Shield( this.randomEmptyPosition() ) );
	}
	private boolean moveHero(Direction direction) {
		
		ArrayList<Direction> possibleMoves = this.getPossibleMoves( this.hero.getPosition() );
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
		
		ArrayList<Direction> possibleMoves;
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
		
		// Draw Shields
		for ( int i = 0; i < this.shields.size(); i++ ) {
			this.board.setSymbol(this.shields.get(i).getPosition(), this.shields.get(i).getSymbol());
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
		
		Random random = new Random();
		
		
		// Hero
		if ( this.hero.getPosition().isEqual( this.board.getExit() ) ) {
			this.victory = true;
			return;
		}
		
		// Dragons
		for ( int i = 0; i < this.dragons.size(); i++ ) {
			
			// Control Sleep
			if ( this.dragons.get(i).getType() == 3 ) {
				this.dragons.get(i).setSleeping( random.nextBoolean() );
			}
			
			// Control Movement 
			if ( this.dragons.get(i).getType() == 2 || this.dragons.get(i).getType() == 3 ) {
				if ( !this.dragons.get(i).isSleeping() ) {
					moveDragon( this.dragons.get(i) );
				}
			}
			
			// Control Encounters With Hero
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
		
		// Sheilds
		for ( int i = 0; i < this.shields.size(); i++ ) {
			
			if ( this.shields.get(i).getPosition().isEqual( this.hero.getPosition() ) ) {
				
				this.hero.setShielded(true);
				this.shields.remove(i--);
				
			}
			
		}
		
	}
	
		
	// Other methods
	
	private ArrayList<Direction> getPossibleMoves(Position p) {
		
		ArrayList<Direction> moves = new ArrayList<Direction>();
		char topSymbol		= this.board.getSymbol( new Position(p.getX(), p.getY() - 1) );
		char rightSymbol	= this.board.getSymbol( new Position(p.getX() + 1, p.getY()) );
		char bottomSymbol	= this.board.getSymbol( new Position(p.getX(), p.getY() + 1) );
		char leftSymbol		= this.board.getSymbol( new Position(p.getX() - 1, p.getY()) );
		
		
		// Up
		if ( topSymbol != 'X' && topSymbol != 'S' ) {
			moves.add(Direction.UP);
		}
		
		// Right
		if ( rightSymbol != 'X' && rightSymbol != 'S' ) {
			moves.add(Direction.RIGHT);
		}
		
		// Down
		if ( bottomSymbol != 'X' && bottomSymbol != 'S' ) {
			moves.add(Direction.DOWN);
		}
		
		// Left
		if ( leftSymbol != 'X' && leftSymbol != 'S' ) {
			moves.add(Direction.LEFT);
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


	
	
	/**
	 * Getter for hero
	 *
	 * @return the hero
	 */
	public Hero getHero() {
		return this.hero;
	}
	
	


	/**
	 * Converts the maze to a formatted string
	 * 
	 * @return A formatted string representing the maze
	 */
	@Override
	public String toString() {
		
		String output = "";
		
		for ( int y = 0; y < this.board.getDimension(); y++ ) {
			
			for ( int x = 0; x < board.getDimension(); x++ ) {
			
				output += board.getSymbol(new Position(x, y)) + " ";
				
			}
			
			output += "\n";
			
		}
		
		return output;
		
	}
	
}
