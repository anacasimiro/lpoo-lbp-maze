package maze.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import maze.logic.Board;
import maze.logic.Hero;
import maze.logic.Maze;
import maze.logic.Position;
import maze.logic.Settings;

/**
 * A class that represents the maze creation panel
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class CreationPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Maze maze;
	private Board board;
	private Settings settings;
	
	private int mazeDimension;
	private int tileDimension;
	
	private Position mouseTile;
	private Position heroPosition = null;
	
	private Image path;
	private Image wall;
	private Image hero;
	private Image dragon;
	private Image sword;
	private Image shield;
	private Image exitClosed;
	private Image currentPiece;
	
	private JFrame helpFrame;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 * @param maze The maze
	 */
	public CreationPanel(Maze maze) {
		
		this.maze = maze;
		this.settings = maze.getSettings();
		this.mazeDimension = settings.getMazeDimension();
		this.tileDimension = (700 - 700 % mazeDimension) / mazeDimension;
		setPreferredSize( new Dimension(tileDimension * mazeDimension, tileDimension * mazeDimension) );
		setFocusable(true);
		
		createHelpFrame();
		createInitialBoard();
		loadImages();
		
		addKeyListener(new MyKeyAdapter());
		addMouseListener(new MyMouseAdapter());		
		addMouseMotionListener(new MyMouseMotionAdapter());
		
		this.currentPiece = path;
		this.mouseTile = new Position(1, 1);
		
	}
	
	
	/**
	 * Creates the initial board filled with walls
	 * 
	 */
	private void createInitialBoard() {
		
		char[][] boardArray = new char[mazeDimension][mazeDimension];
		
		for ( int i = 0; i < mazeDimension; i++ ) {
			Arrays.fill(boardArray[i], 'X');
		}
		
		board = new Board(boardArray);
		maze.setBoard(board);
		
	}
	
	
	/**
	 * Creates a help JFrame
	 * 
	 */
	private void createHelpFrame() {
		
		helpFrame = new JFrame("Help");
		helpFrame.setResizable(false);
		helpFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JTextArea helpText = new JTextArea();
		helpText.setEditable(false);
		helpText.setBorder(new EmptyBorder(20, 20, 20, 20));
		helpText.setSize(new Dimension(360, 600));
		helpText.setLineWrap(true);
		helpText.setText(
		
			"To change the element you're putting on the maze:\n\n" +
			"    <P> - Path\n" +
			"    <W> - Wall\n" +
			"    <H> - Hero\n" +
			"    <D> - Dragon\n" +
			"    <E> - Sword\n" +
			"    <C> - Shield\n" +
			"    <S> - Exit\n\n\n" +
			"To start the game, press <N>"
				
		);
		
		helpFrame.add(helpText);
		helpFrame.pack();
		helpFrame.setVisible(true);
		
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
			dragon = ImageIO.read( this.getClass().getResource("res/dragon.png") );
			sword = ImageIO.read( this.getClass().getResource("res/sword.png") );
			shield = ImageIO.read( this.getClass().getResource("res/shield.png") );
			exitClosed = ImageIO.read( this.getClass().getResource("res/exitClosed.png") );
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Starts the created game
	 * 
	 */
	private void startGame() {
		
		for ( int y = 0; y < mazeDimension; y++ ) {
			
			for ( int x = 0; x < mazeDimension; x++ ) {
				
				switch ( board.getBoard()[x][y] ) {
					case 'H':
						maze.setHero( new Hero(new Position(x, y)) );
					break;
					case 'D':
						maze.newDragon( new Position(x, y) );
						maze.getSettings().setNumberOfDragons( maze.getSettings().getNumberOfDragons() + 1 );
					break;
					case 'E':
						maze.newSword( new Position(x, y) );
						maze.getSettings().setNumberOfSwords( maze.getSettings().getNumberOfSwords() + 1 );
					break;
					case 'C':
						maze.newShield( new Position(x, y) );
						maze.getSettings().setNumberOfShields( maze.getSettings().getNumberOfShields() + 1 );
					break;
					case 'S':
						maze.getBoard().setExit(new Position(x, y));
					break;
				}
				
			}
			
		}
		
		helpFrame.setVisible(false);
		Launcher.showGame( new GamePanel( maze ) );
		
	}
	
	
	/**
	 * A custom KeyAdapter 
	 * 
	 * @author Ana Casimiro
	 * @author Joao Bernardino
	 *
	 */
	private class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyTyped(KeyEvent e) {
			
			switch (e.getKeyChar() ) {
				case 'p':
					currentPiece = path;
				break;
				case 'w':
					currentPiece = wall;
				break;
				case 'h':
					currentPiece = hero;
				break;
				case 'd':
					currentPiece = dragon;
				break;
				case 'e':
					currentPiece = sword;
				break;
				case 'c':
					currentPiece = shield;
				break;
				case 's':
					currentPiece = exitClosed;
				break;
				case 'n':
					if ( heroPosition != null ) {
						startGame();
					}
				break;
			}
			
			repaint();
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {

			switch (e.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "LPOO - Maze", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION ) {
						helpFrame.setVisible(false);
						Launcher.showMainMenu();
					}
				break;
			}
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
	
	
	/**
	 * A custom MouseAdapter
	 * 
	 * @author Ana Casimiro
	 * @author Joao Bernardino
	 *
	 */
	private class MyMouseAdapter extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			if ( currentPiece == path ) {
				
				if ( !board.isEdge(mouseTile) ) {
					if ( board.getSymbol(mouseTile) == 'H' ) {
						heroPosition = null;
					}
					board.setSymbol(mouseTile, ' ');
				}
				
			} else if ( currentPiece == wall ) {
				
				if ( board.getSymbol(mouseTile) == 'H' ) {
					heroPosition = null;
				}
				board.setSymbol(mouseTile, 'X');
				
			} else if ( currentPiece == hero ) {
				
				if ( !board.isEdge(mouseTile) && !board.isWall(mouseTile) ) {
					if ( heroPosition != null ) {
						board.setSymbol(heroPosition, ' ');
					}
					board.setSymbol(mouseTile, 'H');
					heroPosition = new Position(mouseTile);
				}
				
			} else if ( currentPiece == dragon ) {
				
				if ( !board.isEdge(mouseTile) && !board.isWall(mouseTile) ) {
					if ( board.getSymbol(mouseTile) == 'H' ) {
						heroPosition = null;
					}
					board.setSymbol(mouseTile, 'D');
				}
				
			} else if ( currentPiece == sword ) {
				
				if ( !board.isEdge(mouseTile) && !board.isWall(mouseTile) ) {
					if ( board.getSymbol(mouseTile) == 'H' ) {
						heroPosition = null;
					}
					board.setSymbol(mouseTile, 'E');
				}
				
			} else if ( currentPiece == shield ) {
				
				if ( !board.isEdge(mouseTile) && !board.isWall(mouseTile) ) {
					if ( board.getSymbol(mouseTile) == 'H' ) {
						heroPosition = null;
					}
					board.setSymbol(mouseTile, 'C');
				}
				
			} else if ( currentPiece == exitClosed ) {
				
				if ( board.isEdge(mouseTile) && !board.isCorner(mouseTile) ) {
					if ( board.getSymbol(mouseTile) == 'H' ) {
						heroPosition = null;
					}
					board.setSymbol(mouseTile, 'S');
				}
				
			}
			
			repaint();
			
		}
		
	}
	
	
	/**
	 * A custom MouseMotionAdapter
	 * 
	 * @author Ana Casimiro
	 * @author Joao Bernardino
	 *
	 */
	private class MyMouseMotionAdapter extends MouseMotionAdapter {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			
			mouseTile.setX(e.getX() / tileDimension);
			mouseTile.setY(e.getY() / tileDimension);
			
			repaint();
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
			mouseTile.setX(e.getX() / tileDimension);
			mouseTile.setY(e.getY() / tileDimension);
			
			if ( currentPiece == path ) {
				
				if ( !board.isEdge(mouseTile) ) {
					board.setSymbol(mouseTile, ' ');
				}
				
			} else if ( currentPiece == wall ) {
				
				board.setSymbol(mouseTile, 'X');
				
			}
			
			repaint();
			
		}
		
	}
	
	
	/**
	 * Draws a tile on the screen
	 * 
	 * @param g The graphics
	 * @param image The image
	 * @param x The horizontal coordinate
	 * @param y The vertical coordinate
	 * 
	 */
	private void drawTile(Graphics g, Image image, int x, int y) {
		
		g.drawImage(image, x * tileDimension, y * tileDimension, tileDimension, tileDimension, null);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for ( int y = 0; y < this.board.getDimension(); y++ ) {
			
			for ( int x = 0; x < this.board.getDimension(); x++ ) {
				
				switch ( this.board.getBoard()[x][y] ) {
					case 'X':
						drawTile(g, wall, x, y);
					break;
					case ' ':
						drawTile(g, path, x, y);
					break;
					case 'H':
						drawTile(g, path, x, y);
						drawTile(g, hero, x, y);
					break;
					case 'D':
						drawTile(g, path, x, y);
						drawTile(g, dragon, x, y);
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
						drawTile(g, exitClosed, x, y);
					break;
				}

			}
			
		}
		
		if ( currentPiece == path ) {
			
			if ( !board.isEdge(mouseTile) ) {
				drawTile(g, currentPiece, mouseTile.getX(), mouseTile.getY());
			}
			
		} else if ( currentPiece == exitClosed ) {
			
			if ( board.isEdge(mouseTile) && !board.isCorner(mouseTile) ) {
				drawTile(g, currentPiece, mouseTile.getX(), mouseTile.getY());
			}
			
		} else if ( currentPiece == hero || currentPiece == dragon || currentPiece == sword || currentPiece == shield ) {
			
			if ( !board.isWall(mouseTile) ) {				
				drawTile(g, currentPiece, mouseTile.getX(), mouseTile.getY());
			}
			
		} else {
			drawTile(g, currentPiece, mouseTile.getX(), mouseTile.getY());
		}		
		
	}
	
}