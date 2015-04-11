package maze.cli;

import maze.logic.DragonType;
import maze.logic.Maze;
import maze.logic.Direction;
import maze.logic.Settings;

import java.util.Scanner;

/**
 * 
 * Controls the Command Line Interface
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Launcher {

	private static Maze maze = null;
	

	/**
	 * Asks user for maze configuration
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @param config A container to store the maze configuration
	 */
	private static Settings getMazeSettings(Scanner scanner) {
		
		int mazeDimension, dragonsType, numberOfDragons, numberOfSwords, numberOfShields;
		
		clearConsole();
		
		do {
			mazeDimension = getMazeDimension(scanner);
		} while ( mazeDimension < 0 );
		
		System.out.println("");
		
		do {
			dragonsType = getDragonsType(scanner);
		} while ( dragonsType < 0 );
		
		System.out.println("");

		do {
			numberOfDragons = getDragons(scanner);
		} while ( numberOfDragons < 0 );
		
		System.out.println("");
		
		do {
			numberOfSwords = getSwords(scanner);
		} while ( numberOfSwords < 0 );
		
		System.out.println("");
		
		do {
			numberOfShields = getShields(scanner);
		} while ( numberOfShields < 0 );
		
		System.out.println("");
		
		return new Settings(mazeDimension, DragonType.values()[dragonsType - 1], numberOfDragons, numberOfSwords, numberOfShields);
		
	}
	
	
	/**
	 * Asks user for maze dimension
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @return the maze dimension
	 */
	private static int getMazeDimension(Scanner scanner) {
		
		String input;
		int dimension;
		
		System.out.println("Choose the maze dimension.");
		System.out.println("It must be an odd value larger than 6, or 0 for the demo maze.");
		System.out.print("> ");
		input = scanner.nextLine();
		
		try {
			
			dimension = Integer.parseInt(input);
			
			if ( ( dimension % 2 != 1 && dimension != 0 ) || dimension < 0 ) {
				throw new NumberFormatException();
			}
			
		} catch ( NumberFormatException e ) {
			
			System.out.println("\nInvalid value");
			return -1;
			
		}
		
		return dimension;
		
	}
	
	
	/**
	 * Asks user for dragons type
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @return the dragons type
	 */
	private static int getDragonsType(Scanner scanner) {
		
		String input;
		int type;
		
		System.out.println("Choose the dragons type:\n");
		System.out.println("    1 - Dragons don't move");
		System.out.println("    2 - Dragons move randomly");
		System.out.println("    3 - Dragons sleep and move randomly\n");
		System.out.print("> ");
		input = scanner.nextLine();
		
		try {
			
			type = Integer.parseInt(input);
			
			if ( type < 1 || type > 3 ) {
				throw new NumberFormatException();
			}
			
		} catch ( NumberFormatException e ) {
			
			System.out.println("\nInvalid value");
			return -1;
			
		}
		
		return type;
		
	}
	
	
	/**
	 * Asks user for number of dragons
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @return the number of dragons
	 */
	private static int getDragons(Scanner scanner) {
		
		String input;
		int dragons;
		
		System.out.println("Choose the number of dragons.");
		System.out.print("> ");
		input = scanner.nextLine();
		
		try {
			
			dragons = Integer.parseInt(input);
			
			if ( dragons < 0 || dragons > 10 ) {
				throw new NumberFormatException();
			}
			
		} catch ( NumberFormatException e ) {
			
			System.out.println("\nInvalid value");
			return -1;
			
		}
		
		return dragons;
		
	}
	
	
	/**
	 * Asks user for number of swords
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @return the number of swords
	 */
	private static int getSwords(Scanner scanner) {
		
		String input;
		int swords;
		
		System.out.println("Choose the number of swords.");
		System.out.print("> ");
		input = scanner.nextLine();
		
		try {
			
			swords = Integer.parseInt(input);
			
			if ( swords < 0 || swords > 10 ) {
				throw new NumberFormatException();
			}
			
		} catch ( NumberFormatException e ) {
			
			System.out.println("\nInvalid value");
			return -1;
			
		}
		
		return swords;
		
	}
	
	
	/**
	 * Asks user for number of shields
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @return the number of shields
	 */
	private static int getShields(Scanner scanner) {
		
		String input;
		int shields;
		
		System.out.println("Choose the number of shields.");
		System.out.print("> ");
		input = scanner.nextLine();
		
		try {
			
			shields = Integer.parseInt(input);
			
			if ( shields < 0 || shields > 10 ) {
				throw new NumberFormatException();
			}
			
		} catch ( NumberFormatException e ) {
			
			System.out.println("\nInvalid value");
			return -1;
			
		}
		
		return shields;
		
	}
	
	
	/**
	 * Asks user for input
	 * 
	 * @param scanner The keyboard scanner
	 * 
	 * @return the input
	 */
	private static String getUserInput(Scanner scanner) {
		
		System.out.print("\n> ");
		
		return scanner.nextLine();
		
	}
	
	
	/**
	 * Asks user for hero direction
	 * 
	 * @param scanner The keyboard Scanner
	 * 
	 * @return
	 */
	private static Direction getHeroDirection(String input) {
		
		switch (input.toUpperCase()) {
			case "W":
				return Direction.UP;
			case "D":
				return Direction.RIGHT;
			case "S":
				return Direction.DOWN;
			case "A":
				return Direction.LEFT;
			default:
				return Direction.NONE;
		}
		
	}
	
	
	/**
	 * Controls a new game
	 * 
	 * @param scanner
	 */
	private static boolean newGame(Scanner scanner) {
		
		String input;
		boolean done = false;
		
		printMaze();
		
		while ( !done ) {
			
			if ( (input = getUserInput(scanner)).toUpperCase().equals("Q") ) {
				return false;
			} else {
				done = maze.update( getHeroDirection(input) );
			}
			
			printMaze();
			
		}
		
		return !maze.getHero().isDead();
		
	}

	
	/**
	 * Prints the maze to the console
	 * 
	 */
	private static void printMaze() {
		
		clearConsole();
		System.out.println(maze);
		
	}
	
	
	/**
	 * Clears the console
	 */
	private static void clearConsole() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	
	/**
	 * The Main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		boolean done = false;
		
		do {

			clearConsole();
			System.out.println("[LPOO] MAZE");
			System.out.println("==================================================\n");
			System.out.println("1. New Game (Default)");
			System.out.println("2. New Game (Custom)");
			System.out.println("3. New Game (Demo)");
			System.out.println("0. Exit");
			System.out.print("\n> ");
			input = scanner.nextLine();
			
			switch (input) {
				
				case "1":
					
					//maze = new Maze( getMazeSettings(scanner) );
					maze = new Maze( new Settings() );
					
					if ( newGame(scanner) ) {
						System.out.println("\nYou won! :)\nPress <Enter> to continue...");
					} else {
						System.out.println("\nYou lost! :(\nPress <Enter> to continue...");
					}
					
					scanner.nextLine();
					
				break;
				
				case "2":
					
					maze = new Maze( getMazeSettings(scanner) );
					
					if ( newGame(scanner) ) {
						System.out.println("\nYou won! :)\nPress <Enter> to continue...");
					} else {
						System.out.println("\nYou lost! :(\nPress <Enter> to continue...");
					}
					
					scanner.nextLine();
					
				break;
				
				case "3":
					
					maze = new Maze();
					
					if ( newGame(scanner) ) {
						System.out.println("\nYou won! :)\nPress <Enter> to continue...");
					} else {
						System.out.println("\nYou lost! :(\nPress <Enter> to continue...");
					}
					
					scanner.nextLine();
					
				break;
				
				case "0":
					System.out.println("\nThanks for playing. Good bye!");
					done = true;
				break;
				
				default:
					System.out.println("\nInvalid input! Press <Enter> to continue...");
					scanner.nextLine();
				break;
			}
			
		} while ( !done );
		
	}
	
}
