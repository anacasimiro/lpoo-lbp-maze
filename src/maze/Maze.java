package maze;

import java.util.Scanner;

public class Maze {
	
	private Board board;
	private Hero hero;
	private Position sword;
	
	private boolean done;
	private String input;
	
	private Scanner scanner;
	
	
	public Maze() {
		
		this.board		= new Board(10, 10);
		this.hero 		= new Hero(new Position(1, 1));
		this.sword		= new Position(1, 8);
		this.done		= false;
		this.scanner	= new Scanner(System.in);

		do {
			
			board.init();
			checkSword();
			drawHero();
			if ( hero.getSymbol() == 'H' )
				drawSword();
			board.print();
			
			if ( checkVictory() )
				break;
		
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
				
				case "Q":
					// Exit
					done = true;
					break;
			}
			
		} while( !done );
		
		System.out.println("\nSeu piçudo!!");
		
	}

	
	// Hero
	
	public void drawHero() {
		board.setSymbol(hero.getPosition(), hero.getSymbol());
	}
	
	public void moveHero(int direction) {
		
		Position nextp = hero.nextPosition(direction);
				
		if ( board.getSymbol( nextp ) != 'X' && ( board.getSymbol( nextp ) != 'S' || hero.getSymbol() == 'A' ) ) {
			hero.setPosition( nextp );
		}
			
	}
	
	
	// Sword
	
	public void drawSword() {
		board.setSymbol(sword, 'E');
	}
	
	public void checkSword() {
		if ( sword.equals( hero.getPosition() ) ) {
			hero.setSymbol('A');
		}
	}
	
	
	public boolean checkVictory() {
		return ( board.getExitPosition().equals( hero.getPosition() ) );
	}
	
	public static void main(String[] args) {
		new Maze();
	}

}
