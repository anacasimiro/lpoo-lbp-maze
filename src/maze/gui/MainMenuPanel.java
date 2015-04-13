package maze.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	private JButton loadGameButton;
	private JButton demoGameButton;
	private JButton createMazeButton;
	private JButton settingsButton;
	private JButton exitButton;

	private JPanel buttonsPanel;
	
	private Settings mazeSettings = new Settings();

	
	/**
	 * Creates all necessary widgets
	 * 
	 */
	private void createWidgets() {

		
		newGameButton = new JButton("New Game");
		//newGameButton.setFocusPainted(false);
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "LPOO - Maze", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if ( answer == JOptionPane.YES_OPTION ) {
					Launcher.showGame( new GamePanel( new Maze(mazeSettings) ) );
				}
				
			}
			
		});
		
		
		loadGameButton = new JButton("Load Game");
		//newGameButton.setFocusPainted(false);
		loadGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		
		demoGameButton = new JButton("Demo Game");
		//demoGameButton.setFocusPainted(false);
		demoGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a demo game?", "LPOO - Maze", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if ( answer == JOptionPane.YES_OPTION ) {
					Launcher.showGame( new GamePanel( new Maze() ) );
				}
				
			}
			
		});
		
		
		createMazeButton = new JButton("Create Maze");
		//demoGameButton.setFocusPainted(false);
		createMazeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to create a maze?", "LPOO - Maze", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if ( answer == JOptionPane.YES_OPTION ) {
					//Launcher.showGame( new GamePanel( new Maze() ) );
				}
				
			}
			
		});
		
		
		settingsButton = new JButton("Settings");
		//settingsButton.setFocusPainted(false);
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingsDialog(mazeSettings);
			}
			
		});
		
		
		exitButton = new JButton("Exit");
		//exitButton.setFocusPainted(false);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "LPOO - Maze", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
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
		
		buttonsPanel.add(newGameButton);
		buttonsPanel.add(demoGameButton);
		buttonsPanel.add(createMazeButton);
		buttonsPanel.add(settingsButton);
		buttonsPanel.add(exitButton);
		
	}
	
	
	/**
	 * Creates a new instance of the class
	 *
	 */
	public MainMenuPanel() {
		
		buttonsPanel = new JPanel();
		
		try {
			background = ImageIO.read( this.getClass().getResource("res/background.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.setPreferredSize( new Dimension(852, 480) );
		this.setLayout( new BorderLayout() );
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		createWidgets();
		addWidgets();
	
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), 0, 0, this);
	}
	
}
