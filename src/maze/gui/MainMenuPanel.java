package maze.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import maze.logic.Maze;
import maze.logic.Settings;

/**
 * A class that represents the main menu
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class MainMenuPanel extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private Image background;
	
	private JButton newGameButton;
	private JButton demoGameButton;
	private JButton settingsButton;
	private JButton exitButton;

	
	private Settings mazeSettings = new Settings();

	
	/**
	 * Creates all necessary widgets
	 * 
	 */
	private void createWidgets() {

		
		newGameButton = new JButton("New Game");
		newGameButton.setFocusPainted(false);
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if ( answer == JOptionPane.YES_OPTION ) {
					Launcher.showGame( new GamePanel( new Maze(mazeSettings) ) );
				}
				
			}
			
		});
		
		
		demoGameButton = new JButton("Demo Game");
		demoGameButton.setFocusPainted(false);
		demoGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a demo game?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if ( answer == JOptionPane.YES_OPTION ) {
					Launcher.showGame( new GamePanel( new Maze() ) );
				}
				
			}
			
		});
		
		
		settingsButton = new JButton("Settings");
		settingsButton.setFocusPainted(false);
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Launcher.changeMainPanel( new SettingsPanel(mazeSettings) );
				
			}
			
		});
		
		
		exitButton = new JButton("Exit");
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if ( answer == JOptionPane.YES_OPTION ) {
					System.exit(0);
				}
				
			}
			
		});
		
		
	}
	
	
	/**
	 * Adds all widgets to the JPanel
	 */
	private void addWidgets() {
		
		this.add(newGameButton);
		this.add(demoGameButton);
		this.add(settingsButton);
		this.add(exitButton);
		
	}
	
	
	/**
	 * Creates a new instance of the class
	 *
	 */
	public MainMenuPanel() {
		
		try {
			background = ImageIO.read( this.getClass().getResource("res/background.jpg") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setPreferredSize( new Dimension(600, 400) );
		
		this.setLayout( new GridBagLayout() );
		
		createWidgets();
		addWidgets();
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, this);
	}
	
}
