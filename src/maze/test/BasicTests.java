package maze.test;

import static org.junit.Assert.*;
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
		assertTrue( !maze.getHero().isDead() );
		
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
		assertTrue( !maze.getHero().isDead() );
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
	
	
}
