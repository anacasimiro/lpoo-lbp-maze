package maze.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Controls the Graphical User Interface
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class Launcher {
	
	private static JFrame frame;
	private static JButton playButton;
	private static JButton exitButton;
	
	
	/**
	 * Creates the main window widgets
	 * 
	 */
	private static void createWidgets() {
		
		playButton = new JButton("New Game");
		exitButton = new JButton("Exit");
		
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				
				JFrame gameFrame = new JFrame();
				gameFrame.setSize(500, 500);
				gameFrame.setLocationRelativeTo(null);
				
				gameFrame.addWindowListener( new WindowAdapter() {
				
					@Override
					public void windowClosing(WindowEvent e) {
						frame.setVisible(true);
					}
					
				});
				
				gameFrame.setVisible(true);
				
			}
			
		});
		
		exitButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				System.exit(0);
				
			}
			
		});
		
	}
	
	
	/**
	 * Adds the widgets to the main window
	 * 
	 */
	private static void addWidgets() {
		
		frame.getContentPane().add(playButton);
		frame.getContentPane().add(exitButton);
		
	}
	
	
	/**
	 * The Main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		frame = new JFrame("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout( new GridLayout(2, 1, 0, 10) );
		frame.setResizable(false);
		
		createWidgets();
		addWidgets();
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
