package maze.logic;

import java.util.Random;
import java.util.Scanner;

public class Maze {
	
	private Board board;
	private Hero hero;
	private Sword sword;
	private Dragon dragon;
	
	private boolean victory;
	private String input;
	
	private Scanner scanner;
	
	
	public Maze() {
		
		this.board		= new Board(10, 10);
		this.hero 		= new Hero(new Position(1, 1));
		this.sword		= new Sword();
		this.dragon		= new Dragon();
		this.victory	= false;
		this.scanner	= new Scanner(System.in);

		do {
			
			checkSword();
			
			drawHero();
			drawSword();
			
			if ( fightDragon() ) {
				
				if ( hero.getHasSword() ) {
					dragon.setDead(true);
				} else {
					drawDragon();
					board.print();
					break;
				}
				
			}
			
			drawDragon();
			
			board.print();
			
			if ( checkVictory() ) {
				victory = true;
				break;
			}
		
			System.out.println();
			System.out.print("> ");
			input = scanner.nextLine();

			switch (input.toUpperCase()) {
			
				case "W":
					// Up
					moveHero(0);
					break;
					
				case "D":
					// Right
					moveHero(1);
					break;
					
				case "S":
					// Down
					moveHero(2);
					break;
					
				case "A":
					// Left
					moveHero(3);
					break;
			}
			
			if ( input.equalsIgnoreCase("Q") ) {
				break;
			}
			
			Random r = new Random();
			moveDragon( r.nextInt(5) );
			
		} while( !victory );
		
		if ( victory ) {
			System.out.println("\nYou lucky bastard!!");
		} else {
			System.out.println("\nL0L L00SER!!");
		}
		
	}

	
	// Hero
	
	private void drawHero() {
		board.setSymbol(hero.getPosition(), hero.getSymbol());
	}
	
	private void moveHero(int direction) {
		
		Position nextp = hero.nextPosition(direction);
				
		if ( !board.isWall( nextp ) && ( !board.getExit().equals( nextp ) || hero.getHasSword() ) ) {
			hero.setPosition( nextp );
		}
			
	}
	
	
	// Sword
	
	private void drawSword() {
		if ( !sword.isTaken() ) {
			board.setSymbol(sword.getPosition(), sword.getSymbol());
		}
	}
	
	private void checkSword() {
		if ( sword.getPosition().equals( hero.getPosition() ) ) {
			hero.setHasSword(true);
			sword.setTaken(true);
		}
	}
	
	
	// Dragon
	
	private void drawDragon() {
		if ( !dragon.isDead() ) {
			if ( !sword.isTaken() && dragon.getPosition().equals( sword.getPosition() ) ) {
				board.setSymbol(dragon.getPosition(), 'F');
			} else {
				board.setSymbol(dragon.getPosition(), dragon.getSymbol());
			}
		}
	}
	
	private boolean fightDragon() {
		return dragon.getPosition().isAdjacent( hero.getPosition() ) || dragon.getPosition().equals( hero.getPosition() );
	}
	
	private void moveDragon(int direction) {
		
		Position nextp = dragon.nextPosition(direction);
				
		if ( !board.isWall( nextp ) && !board.getExit().equals( nextp ) ) {
			dragon.setPosition( nextp );
		}
			
	}
	
	
	private boolean checkVictory() {
		return ( board.getExit().equals( hero.getPosition() ) );
	}
	
	public static void main(String[] args) {
		new Maze();
	}

}
