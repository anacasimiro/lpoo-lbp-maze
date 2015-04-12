package maze.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.logic.Direction;
import maze.logic.Maze;

/**
 * A class that represents the in-game panel
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Maze maze;
	
	private int tileDimension;
	
	private Image path;
	private Image wall;
	private Image hero;
	private Image heroWithSword;
	private Image heroWithShield;
	private Image heroWithSwordAndShield;
	private Image dragon;
	private Image dragonSleeping;
	private Image sword;
	private Image shield;
	private Image exit;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param mazeSettings
	 */
	public GamePanel(Maze maze) {
		
		this.maze = maze;
		
		this.setPreferredSize( new Dimension(700 - 700 % maze.getBoard().getDimension(), 700 - 700 % maze.getBoard().getDimension()) );
		
		setFocusable(true);
		
		loadImages();
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				boolean done;
				
				switch ( e.getKeyChar() ) {
					case 'w':
						done = maze.update( Direction.UP );
					break;
					case 'd':
						done = maze.update( Direction.RIGHT );
					break;
					case 's':
						done = maze.update( Direction.DOWN );
					break;
					case 'a':
						done = maze.update( Direction.LEFT );
					break;
					default:
						done = false;
					break;
				}
				
				repaint();
				
				if ( done ) {
					endGame( maze.getVictory() );
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				boolean done = false;
				
				switch ( e.getKeyCode() ) {
					case KeyEvent.VK_UP:
						done = maze.update( Direction.UP );
					break;
					case KeyEvent.VK_RIGHT:
						done = maze.update( Direction.RIGHT );
					break;
					case KeyEvent.VK_DOWN:
						done = maze.update( Direction.DOWN );
					break;
					case KeyEvent.VK_LEFT:
						done = maze.update( Direction.LEFT );
					break;
					case KeyEvent.VK_ESCAPE:
						if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "LPOO - Maze", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION ) {
							Launcher.showMainMenu();
						}
					break;
				}
				
				repaint();
				
				if ( done ) {
					endGame( maze.getVictory() );
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			
		});
		
	}
	
	
	/**
	 * Loads all necessary images
	 * 
	 */
	private void loadImages() {
		
		try {
			path = ImageIO.read( this.getClass().getResource("res/path.png") );
			wall = ImageIO.read( this.getClass().getResource("res/wall.png") );
			hero = ImageIO.read( this.getClass().getResource("res/hero.png") );
			heroWithSword = ImageIO.read( this.getClass().getResource("res/heroWithSword.png") );
			heroWithShield = ImageIO.read( this.getClass().getResource("res/heroWithShield.png") );
			heroWithSwordAndShield = ImageIO.read( this.getClass().getResource("res/heroWithSwordAndShield.png") );
			dragon = ImageIO.read( this.getClass().getResource("res/dragon.png") );
			dragonSleeping = ImageIO.read( this.getClass().getResource("res/dragonSleeping.png") );
			sword = ImageIO.read( this.getClass().getResource("res/sword.png") );
			shield = ImageIO.read( this.getClass().getResource("res/shield.png") );
			exit = ImageIO.read( this.getClass().getResource("res/exit.png") );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Draws a tile on the screen
	 * 
	 */
	private void drawTile(Graphics g, Image image, int x, int y) {
		
		g.drawImage(image, x * tileDimension, y * tileDimension, tileDimension, tileDimension, null);
		
	}
	
	
	/**
	 * Ends the game
	 * 
	 */
	private void endGame(boolean victory) {
		
		if ( victory ) {
			JOptionPane.showMessageDialog(this, "Congratulations! You won!", "LPOO - Maze", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Sorry! You lost!", "LPOO - Maze", JOptionPane.INFORMATION_MESSAGE);
		}
			
		Launcher.showMainMenu();
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		tileDimension = this.getHeight() / this.maze.getBoard().getDimension();
		
		for ( int y = 0; y < maze.getBoard().getDimension(); y++ ) {
			
			for ( int x = 0; x < maze.getBoard().getDimension(); x++ ) {
				
				switch ( maze.getBoard().getBoard()[x][y] ) {
					case 'X':
						drawTile(g, path, x, y);
						drawTile(g, wall, x, y);
					break;
					case ' ':
						drawTile(g, path, x, y);
					break;
					case 'H':
						drawTile(g, path, x, y);
						drawTile(g, hero, x, y);
					break;
					case 'A':
						drawTile(g, path, x, y);
						drawTile(g, heroWithSword, x, y);
					break;
					case 'P':
						drawTile(g, path, x, y);
						drawTile(g, heroWithShield, x, y);
					break;
					case 'Y':
						drawTile(g, path, x, y);
						drawTile(g, heroWithSwordAndShield, x, y);
					break;
					case 'D':
						drawTile(g, path, x, y);
						drawTile(g, dragon, x, y);
					break;
					case 'd':
						drawTile(g, path, x, y);
						drawTile(g, dragonSleeping, x, y);
					break;
					case 'F':
						drawTile(g, path, x, y);
						drawTile(g, dragon, x, y);
					break;
					case 'E':
						drawTile(g, path, x, y);
						drawTile(g, sword, x, y);
					break;
					case 'C':
						drawTile(g, path, x, y);
						drawTile(g, shield, x, y);
					break;
					case 'S':
						
						if ( maze.getHero().isArmed() ) {
							drawTile(g, path, x, y);
						} else {
							drawTile(g, exit, x, y);
						}
						
					break;
					default:
						
					break;
				}

			}
			
		}
		
	}
	
}