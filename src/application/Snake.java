package application;
import java.util.ArrayList;
/**
 * This class is handles when the user inputs WASD, the snake will move accordingly. 
 * And will interact with the mazes randomly generated Walls and pellets,
 * that will infleunce the snakes action performed. 
 * @author Written by Danny, assisted and co-written by Andres and Elizabeth.
 *
 */
public class Snake {
	ArrayList <SnakeSegment> arraySnakeSegment;
	
	
	public Snake(MazeGenerator mazeCreation) {
		int y = 4;
		int x =9;
		arraySnakeSegment = new ArrayList <SnakeSegment>();
		SnakeSegment snakeSeg = new SnakeSegment(y, x);
		arraySnakeSegment.add(snakeSeg);
		mazeCreation.add(snakeSeg);
		
		
	}
	public void moveSnake(MazeGenerator mazeCreation, int row_movement, int column_movement){
		SnakeSegment head = arraySnakeSegment.get(0);
		int[] headArray = head.location();
		
		
	}
	

	/**
	 * This checks if the snake has the same coordinates as a pellet
	 * @param mazeCreation is from MazeGenerator class that represent all objects in the maze
	 */
	public void eatPellet (MazeGenerator mazeCreation) {
		
	}
}