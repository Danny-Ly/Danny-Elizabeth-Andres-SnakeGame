package application;

import java.util.ArrayList;

/**
 * This class is handles when the user inputs WASD, the snake will move
 * accordingly. And will interact with the mazes randomly generated Walls and
 * pellets, that will infleunce the snakes action performed.
 * 
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */
public class Snake {
	ArrayList<SnakeSegment> arraySnakeSegment;
	SnakeSegment oldTail;

	public Snake(MazeGenerator mazeCreation) {
		int y = 4;
		int x = 9;
		arraySnakeSegment = new ArrayList<SnakeSegment>();
		SnakeSegment snakeSeg = new SnakeSegment(y, x);
		arraySnakeSegment.add(snakeSeg);
		mazeCreation.add(snakeSeg);

	}

	public void moveSnake(MazeGenerator mazeCreation, int row_movement, int column_movement) {
		SnakeSegment head = arraySnakeSegment.get(0);
		int[] headArray = head.location();
		int updatedLocationRow = headArray[0] + row_movement;
		int updatedLocationColumn = headArray[1] + column_movement;
		SnakeSegment updatedHead = new SnakeSegment(updatedLocationRow, updatedLocationColumn);
		arraySnakeSegment.add(0, updatedHead);
		oldTail = arraySnakeSegment.remove(arraySnakeSegment.size() - 1);
		MazeItems oldItem = mazeCreation.add(updatedHead);
		mazeCreation.remove(oldTail);
		if (oldItem != null) {
			oldItem.eat(this, mazeCreation);
		}

	}

	public void eatBomb(MazeGenerator mazeCreation) {
		mazeCreation.regnerateMaze();
	}

	/**
	 * This checks if the snake has the same coordinates as a pellet
	 * 
	 * @param mazeCreation is from MazeGenerator class that represent all objects in
	 *                     the maze
	 */
	public void eatPellet(MazeGenerator mazeCreation) {
		arraySnakeSegment.add(oldTail);
		mazeCreation.add(oldTail);	

	}
}