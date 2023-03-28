package application;

import java.util.ArrayList;

/**
 * This class is used the movement, extension,and consumption of the snake. This
 * class passes the user interaction from main and handles the outcome
 * accordingly.
 * 
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */
public class Snake {
	// Initializing/declaring variables that will be used in creating the snake,
	// And customization of the movement
	private ArrayList<SnakeSegment> arraySnakeSegment;
	private SnakeSegment oldTail;

	/**
	 * Constructor for Snake class, that creates a array list for snake and adds
	 * snake segments to the array list.
	 * 
	 * @param mazeCreation is from MazeGenerator class that represent how all
	 *                     objects are manipulated in the maze
	 */
	public Snake(MazeGenerator mazeCreation) {
		// x, y coordinate of where snake starts. These values will continue to change.
		int y = 4;
		int x = 9;
		// making arraylist for snake and making a snake seg to add to array list
		arraySnakeSegment = new ArrayList<SnakeSegment>();
		SnakeSegment snakeSeg = new SnakeSegment(y, x);
		// Adding SnakeSeg to arraylist and showing in maze
		arraySnakeSegment.add(snakeSeg);
		mazeCreation.add(snakeSeg);
	}

	/**
	 * This moves the snake through the maze and based on user input and deletes old
	 * position of snake
	 * 
	 * @param mazeCreation    parameter from MazeGenerator class that represent how
	 *                        all objects are manipulated in the maze.
	 * @param row_movement    based on user input WASD, either 0, 1 or -1
	 * @param column_movement based on user input WASD, either 0, 1 or -1
	 */
	public void moveSnake(MazeGenerator mazeCreation, int row_movement, int column_movement) {
		// assigning head of the snake to first element in arraylist
		SnakeSegment head = arraySnakeSegment.get(0);
		int[] headArray = head.location();
		// Finding updated x, y positions
		int updatedLocationRow = headArray[0] + row_movement;
		int updatedLocationColumn = headArray[1] + column_movement;
		SnakeSegment updatedHead = new SnakeSegment(updatedLocationRow, updatedLocationColumn);
		// updating the position of the snake
		arraySnakeSegment.add(0, updatedHead);
		// removing old position of head
		oldTail = arraySnakeSegment.remove(arraySnakeSegment.size() - 1); //
		MazeItems oldItem = mazeCreation.add(updatedHead);
		if (head != oldItem) {

			mazeCreation.remove(oldTail);
			if (oldItem != null) {
				oldItem.eat(this, mazeCreation);
			}
		}
	}

	public SnakeSegment getSnakeHead() {
		SnakeSegment head = arraySnakeSegment.get(0);
		return head;

	}

	public void eatNinjaStar(MazeGenerator mazeCreation) {
		SnakeSegment oldTail = arraySnakeSegment.remove(arraySnakeSegment.size() - 1);
		mazeCreation.remove(oldTail);
		if (arraySnakeSegment.size() == 0) {
			throw new RuntimeException("NO MORE SNAKE LEFT");
		}

	}

	/**
	 * This regenerates the maze if the snake eats a bomb
	 * 
	 * @param mazeCreation is from MazeGenerator class that represent how all
	 *                     objects are manipulated in the maze.
	 */
	public void eatBomb(MazeGenerator mazeCreation) {
		mazeCreation.regnerateMaze();
	}

	/**
	 * This extends the snake if a pellet is eaten by adding the old location to the
	 * arraylist.
	 * 
	 * @param mazeCreation is from MazeGenerator class that represent how all
	 *                     objects are manipulated in the maze.
	 */
	public void eatPellet(MazeGenerator mazeCreation) {
		arraySnakeSegment.add(oldTail);
		mazeCreation.add(oldTail);
	}
	
	public void eatSpeed(MazeGenerator mazeCreation) {
		//int actionValue = 2;
		//System.out.println(actionValue);
		System.out.println("Speed pellet consumed");
		
	}
	
	public void eatNinjaStar(MazeGenerator mazeCreation) {
		SnakeSegment oldTail = arraySnakeSegment.remove(arraySnakeSegment.size()-1);
		mazeCreation.remove(oldTail);
		if (arraySnakeSegment.size()== 0) {
			throw new RuntimeException("NO MORE SNAKE LEFT");
		}	
	}	
}