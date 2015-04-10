package maze.test;

import static org.junit.Assert.*;
import maze.logic.Board;
import maze.logic.Direction;
import maze.logic.Maze;
import maze.logic.Position;

import org.junit.Test;

/**
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class BasicTests {

	@Test
	public void heroMovement() {
		
		Maze maze = new Maze();
		Direction[] moves = { Direction.RIGHT };
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertEquals( new Position(2, 1), maze.getHero().getPosition() );
		
	}
	
	
	@Test
	public void heroCollisionWithWall() {
		
		Maze maze = new Maze();
		Direction[] moves = { Direction.UP };
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertEquals( new Position(1, 1), maze.getHero().getPosition() );
		
	}

	
	@Test
	public void heroTakingSword() {
		
		Maze maze = new Maze();
		Direction[] moves = {
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.LEFT,
			Direction.LEFT,
			Direction.LEFT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN
		};
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertTrue( maze.getHero().isArmed() );
		assertEquals( 0, maze.getSwords().size() );
		
	}
	
	
	@Test
	public void heroKilled() {
		
		Maze maze = new Maze();
		Direction[] moves = {
			Direction.DOWN, 
		};
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertTrue( maze.getHero().isDead() );
		
	}
	
	
	@Test
	public void dragonKilled() {
		
		Maze maze = new Maze();
		Direction[] moves = {
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.LEFT,
			Direction.LEFT,
			Direction.LEFT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.UP,
			Direction.UP,
			Direction.UP,
			Direction.UP
		};
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertTrue( maze.getDragons().isEmpty() );
		assertFalse( maze.getHero().isDead() );
		
	}
	
	
	@Test
	public void victory() {
		
		Maze maze = new Maze();
		Direction[] moves = {
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.LEFT,
			Direction.LEFT,
			Direction.LEFT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.UP,
			Direction.UP,
			Direction.UP,
			Direction.UP,
			Direction.UP,
			Direction.UP,
			Direction.UP,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.RIGHT
		};
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertTrue( maze.getDragons().isEmpty() );
		assertFalse( maze.getHero().isDead() );
		assertEquals( maze.getBoard().getExit() , maze.getHero().getPosition() );
		assertTrue( maze.getVictory() );
		
		
	}
	
	
	@Test
	public void tryToExitWithoutSword() {
		
		Maze maze = new Maze();
		Direction[] moves = {
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.RIGHT,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.DOWN,
			Direction.RIGHT
		};
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertEquals( new Position(8, 5) , maze.getHero().getPosition() );
		assertFalse( maze.getVictory() );
		
		
	}
	
	
	@Test
	public void testAutoMazeBuilderEmptyCells() {
		
		/*
		 * Given a random maze with dimension n, the number
		 * of empty cells must be (n-1)^2 / 2 - 1
		 */
		
		Board boardDim7 = new Board(7);
		Board boardDim9 = new Board(9);
		Board boardDim11 = new Board(11);
		
		int dim7Count = 0;
		int dim9Count = 0;
		int dim11Count = 0;
		
		for ( int j = 0; j < boardDim7.getBoard().length; j++ ) {
			
			for ( int i = 0; i < boardDim7.getBoard()[j].length; i++ ) {
				
				if ( boardDim7.getBoard()[j][i] == ' ' ) {
					dim7Count++;
				}
				
			}
			
		}
		
		for ( int j = 0; j < boardDim9.getBoard().length; j++ ) {
			
			for ( int i = 0; i < boardDim9.getBoard()[j].length; i++ ) {
				
				if ( boardDim9.getBoard()[j][i] == ' ' ) {
					dim9Count++;
				}
				
			}
			
		}
		
		for ( int j = 0; j < boardDim11.getBoard().length; j++ ) {
			
			for ( int i = 0; i < boardDim11.getBoard()[j].length; i++ ) {
				
				if ( boardDim11.getBoard()[j][i] == ' ' ) {
					dim11Count++;
				}
				
			}
			
		}
		
		assertEquals( (7 - 1) * (7 - 1) / 2 - 1 , dim7Count);
		assertEquals( (9 - 1) * (9 - 1) / 2 - 1 , dim9Count);
		assertEquals( (11 - 1) * (11 - 1) / 2 - 1 , dim11Count);
		
	}
	
	
	@Test
	public void testHeroEncounterWithSleepingDragon() {
		
		Maze maze = new Maze();
		Direction[] moves = { Direction.DOWN };
		
		maze.getDragons().get(0).setSleeping(true);
		
		for (Direction direction : moves) {
			maze.update(direction);
		}
		
		assertFalse( maze.getHero().isDead() );
		
	}
	
}
