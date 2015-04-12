package maze.gui;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	 * Change the frame's contentPane
	 * 
	 * @param mainPanel The new main panel
	 */
	public static void changeMainPanel(JComponent panel) {
		frame.setContentPane(panel);
		frame.pack();
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
		
		frame.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				
				if ( frame.getContentPane().getClass() == GamePanel.class ) {
					
					int width = frame.getWidth() + frame.getInsets().left + frame.getInsets().right;
					int height = frame.getWidth() + frame.getInsets().top + frame.getInsets().bottom;
					
					frame.setSize( width , height);
					
				}
				
			}
			
		});
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
