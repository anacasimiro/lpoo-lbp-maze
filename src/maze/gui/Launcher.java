package maze.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * Controls the Graphical User Interface
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Launcher {
	
	private static JFrame frame = new JFrame("[LPOO] Maze"); 
	private static MainMenuPanel mainMenuPanel = new MainMenuPanel();
	
	
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

	
	/**
	 * Shows the main menu
	 * 
	 */
	public static void showMainMenu() {
		frame.setContentPane(mainMenuPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	
	/**
	 * Change the frame's contentPane
	 * 
	 * @param mainPanel The new main panel
	 */
	public static void changeMainPanel(JComponent panel) {
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
}
