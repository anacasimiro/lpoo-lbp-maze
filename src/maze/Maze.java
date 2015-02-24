package maze;

import java.lang.System;
import java.util.Scanner;

public class Maze {
	
	private Board board;
	private Hero hero;
	private boolean done;
	private String input;
	private Scanner scanner;
	
	
	public Maze() {
		
		this.board		= new Board(10, 10);
		this.hero 		= new Hero(1, 1);
		this.done		= false;
		this.scanner	= new Scanner(System.in);

		do {
			
			board.init();
			drawHero();
			board.print();
		
			System.out.println();
			System.out.print("> ");
			input = scanner.nextLine();

			switch (input) {
				case "W":
					hero.moveUp();
					break;
				case "S":
					hero.moveDown();
					break;
				case "A":
					hero.moveLeft();
					break;
				case "D":
					hero.moveRight();
					break;
				case "Exit":
					done = true;
					break;
			}
			
		} while( !done );
		
		System.out.println("\nBye bye!");
		
	}
	
	public void drawHero() {
		board.setCell(hero.getX(), hero.getY(), 'H');
	}
	
	public static void main(String[] args) {
		new Maze();
	}

}
