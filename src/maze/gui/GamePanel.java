package maze.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
	private Image dragon;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param mazeSettings
	 */
	public GamePanel(Maze maze) {
		
		this.maze = maze;
		
		this.setPreferredSize( new Dimension(700 - 700 % maze.getBoard().getDimension(), 700 - 700 % maze.getBoard().getDimension()) );
		
		loadImages();
		
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dragon = new ImageIcon( this.getClass().getResource("res/dragon.gif") ).getImage();
		
	}
	
	
	/**
	 * Draws a tile on the screen
	 * 
	 */
	private void drawTile(Graphics g, Image image, int x, int y) {
		
		g.drawImage(image, x * tileDimension, y * tileDimension, tileDimension, tileDimension, this);
		
	}
	
	
	/**
	 * Draws all the pieces on the board
	 * 
	 * @param g The Graphics object
	 * 
	 */
	private void drawPieces(Graphics g) {
		
		// Hero
		
		drawTile(g, hero, maze.getHero().getPosition().getX(), maze.getHero().getPosition().getY());
		
		
		// Dragons
		
		for ( int i = 0; i < maze.getDragons().size(); i++ ) {
			drawTile(g, dragon, maze.getDragons().get(i).getPosition().getX(), maze.getDragons().get(i).getPosition().getY());
		}
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		tileDimension = this.getHeight() / this.maze.getBoard().getDimension();
		
		for ( int y = 0; y < maze.getBoard().getDimension(); y++ ) {
			
			for ( int x = 0; x < maze.getBoard().getDimension(); x++ ) {
				
				if ( maze.getBoard().getBoard()[x][y] == 'X' ) {
					drawTile(g, wall, x, y);
				} else {
					drawTile(g, path, x, y);
				}
				
			}
			
		}
		
		drawPieces(g);
		
	}
	
}
