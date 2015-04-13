package maze.gui;

import javax.swing.JFrame;

/**
 * Controls the Graphical User Interface
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Launcher {
	
	protected static JFrame frame = new JFrame("LPOO - Maze"); 
	private static MainMenuPanel mainMenuPanel = new MainMenuPanel();

	
	/**
	 * Shows the main menu
	 * 
	 */
	public static void showMainMenu() {
		frame.setContentPane(mainMenuPanel);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	
	/**
	 * Shows the game panel
	 * 
	 */
	public static void showGame(GamePanel gamePanel) {
		
		frame.setContentPane(gamePanel);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
	}
	
	
	/**
	 * The Main function
	 * 
	 * @param args Main arguments
	 */
	public static void main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane( mainMenuPanel );
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
