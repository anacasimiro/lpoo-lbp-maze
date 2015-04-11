package maze.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;

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
	BufferedImage background;
	JButton newGameButton;
	JButton settingsButton;
	
	Settings mazeSettings = new Settings();
	
	
	/**
	 * Creates all necessary widgets
	 * 
	 */
	private void createWidgets() {
		
		settingsButton = new JButton("Settings");
		
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Launcher.changeMainPanel( new SettingsPanel(mazeSettings) );
				
			}
			
		});
		
		settingsButton.setPreferredSize(new Dimension(100, 60));
		
	}
	
	
	
	/**
	 * Adds all widgets to the JPanel
	 */
	private void addWidgets() {
		
		this.add(settingsButton);
		
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
		g.drawImage(background, 0, 0, this);
	}
	
}
