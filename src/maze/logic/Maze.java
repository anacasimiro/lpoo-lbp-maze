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
	 * Creates a new instance of the class with the demo maze
	 *
	 * @param config
	 */
	public Maze() {
		
		this.settings	= new Settings(10, 1, 1, 1, 0);
		this.board		= new Board(0);
		this.hero 		= new Hero( new Position(1, 1) );
		
		this.dragons.add( new Dragon( new Position(1, 3), 1) );
		this.swords.add( new Sword( new Position(1, 8) ) );
		
		this.drawPieces();
		
	}
	
	
	/**
	 * Creates a new instance of the class with given settings
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
	
	
	/**
	 * Creates a new dragon
	 * 
	 * @param type
	 */
	private void newDragon(int type) {
		
		Position dragonPosition;
		
		do {
			dragonPosition = this.randomEmptyPosition();
		} while ( dragonPosition.isAdjacent( this.hero.getPosition() ) );
		
		this.dragons.add( new Dragon( dragonPosition, type ) );
		
	}
	

	/**
	 * Creates a new sword
	 * 
	 */
	private void newSword() {
		this.swords.add( new Sword( this.randomEmptyPosition() ) );
	}
	
	
	/**
	 * Creates a new shield
	 */
	private void newShield() {
		this.shields.add( new Shield( this.randomEmptyPosition() ) );
	}
	
	
	/**
	 * Moves the hero
	 * 
	 * @param direction
	 * 
	 * @return true if movement was possible, false otherwise
	 */
	private boolean moveHero(Direction direction) {
		
		ArrayList<Direction> possibleMoves = this.getPossibleMoves( this.hero.getPosition() );
		Position nextPosition = this.hero.getPosition().next(direction);
		
		if ( possibleMoves.contains(direction) || ( nextPosition.equals( this.board.getExit() ) && this.hero.isArmed() ) ) {
			this.board.setSymbol(this.hero.getPosition(), ' ');
			this.hero.setPosition( nextPosition );
			return true;
		} else {
			return false;
		}
			
	}
	
	
	/**
	 * Moves a dragon
	 * 
	 * @param dragon
	 */
	private void moveDragon(Dragon dragon) {
		
		ArrayList<Direction> possibleMoves;
		Position nextPosition;
		Random random = new Random();
	
		possibleMoves = this.getPossibleMoves( dragon.getPosition() );
		nextPosition = dragon.getPosition().next( possibleMoves.get( random.nextInt( possibleMoves.size() ) ) );
		this.board.setSymbol( dragon.getPosition() , ' ');
		dragon.setPosition( nextPosition );
		
	}
	
	
	/**
	 * Draws the pieces on the board
	 * 
	 */
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
	
	
	/**
	 * Updates all the pieces
	 * 
	 */
	private void updatePieces() {
		
		Random random = new Random();
		
		
		// Hero
		if ( this.hero.getPosition().equals( this.board.getExit() ) ) {
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
			
			if ( this.swords.get(i).getPosition().equals( this.hero.getPosition() ) ) {
				
				this.hero.setArmed(true);
				this.swords.remove(i--);
				
			}
			
		}
		
		// Sheilds
		for ( int i = 0; i < this.shields.size(); i++ ) {
			
			if ( this.shields.get(i).getPosition().equals( this.hero.getPosition() ) ) {
				
				this.hero.setShielded(true);
				this.shields.remove(i--);
				
			}
			
		}
		
	}
	
	
	/**
	 * Calculates the possible moves from a given position
	 * 
	 * @param p The current position
	 * 
	 * @return an ArrayList containing the possible movements
	 */
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
	
	
	/**
	 * Calculates a random empty position on the board
	 * 
	 * @return the empty position
	 */
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
	 * Getter for dragons
	 *
	 * @return the dragons
	 */
	public ArrayList<Dragon> getDragons() {
		return dragons;
	}
	
	


	/**
	 * Getter for swords
	 *
	 * @return the swords
	 */
	public ArrayList<Sword> getSwords() {
		return swords;
	}
	
	


	/**
	 * Getter for shields
	 *
	 * @return the shields
	 */
	public ArrayList<Shield> getShields() {
		return shields;
	}
	
	


	/**
	 * Getter for victory
	 *
	 * @return the victory
	 */
	public boolean getVictory() {
		return victory;
	}


	/**
	 * Getter for board
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
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
