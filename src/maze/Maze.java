package maze;

import java.util.Scanner;

public class Maze {
	
	private Board board;
	private Hero hero;
	private int swordX;
	private int swordY;
	
	private boolean done;
	private String input;
	
	private Scanner scanner;
	
	
	public Maze() {
		
		this.board		= new Board(10, 10);
		this.hero 		= new Hero(1, 1);
		this.swordX		= 1;
		this.swordY		= 8;
		this.done		= false;
		this.scanner	= new Scanner(System.in);

		do {
			
			board.init();
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
		
		System.out.println("\nBye bye!");
		
	}

	
	// Hero
	
	public void drawHero() {
		board.setCell(hero.getX(), hero.getY(), hero.getSymbol());
	}
	
	public void moveHero(int direction) {
		
		switch (direction) {
		
			case 0:
				// Up
				if ( board.getCell(hero.getX(), hero.getY() - 1) != 'X')
					hero.setY( hero.getY() - 1);
				break;
				
			case 1:
				// Right
				if ( board.getCell(hero.getX() + 1, hero.getY()) != 'X')
					hero.setX( hero.getX() + 1);
				break;
				
			case 2:
				// Down
				if ( board.getCell(hero.getX(), hero.getY() + 1) != 'X')
					hero.setY( hero.getY() + 1);
				break;
				
			case 3:
				// Left
				if ( board.getCell(hero.getX() - 1, hero.getY()) != 'X')
					hero.setX( hero.getX() - 1);
				break;
		}
			
	}
	
	
	// Sword
	
	public void drawSword() {
		board.setCell(swordX, swordY, 'E');
	}
	
	
	public boolean checkVictory() {
		return ( board.getExitX() == hero.getX() && board.getExitY() == hero.getY() );
	}
	
	
	
	public static void main(String[] args) {
		new Maze();
	}

}
