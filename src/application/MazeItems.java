package application;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;



/**
 * This interface is used to create an array of type Mazeitems.
 * 
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */
public interface MazeItems {
	
	/*
	 * prints desired program output for each maze item
	 */
	public void printItem();
	
	/*
	 * when the snake runs into the mazeitem each item will execute their said
	 * fuctions
	 * 
	 * @param Snake to determine how each object will affect the snake and
	 * 
	 * @param generator to determine how each object will affect the maze
	 */
	public void eat(Snake snake, MazeGenerator generator);
	
	/*
	 * checks to see if each maze item is a wall
	 */
	public boolean isWall();
}


/*
 * Bombs class will print the desired output Regenerate maze if snake touches
 * the bomb and
 * 
 * @return false for if its a wall
 */
class Bombs implements MazeItems {
	public void printItem() {
		System.out.print("@");
	}
	public void eat(Snake snake, MazeGenerator generator) {
		snake.eatBomb(generator);
	}
	public boolean isWall() {
		return false;
	}
}

/*
 * Pellets class will print the desired output Extend the snake if it touches
 * the pellet
 * 
 * @return false for if its a wall
 */
class Pellets implements MazeItems {
	public void printItem() {
		System.out.print(".");
	}
	public void eat(Snake snake, MazeGenerator generator) {
		snake.eatPellet(generator);
	}
	public boolean isWall() {
		return false;
	}
}







/*
 * @return true for if its a wall Wall class will print the desired output and
 * throw and exception (caught in main) if the snake runs into the wall
 */
class Wall implements MazeItems {
	
	public boolean isWall() {
		return true;
	}
	public void printItem() {

		System.out.print("#");
	}
	public void eat(Snake snake, MazeGenerator generator) {
		throw new RuntimeException("SNAKES CAN'T EAT WALLS");
	}
}

/*
 * SnakeSegement class will print the desired output assigns x and y values for
 * the position of the snake seg
 * 
 * @return false for if its a wall and throw and exception (caught in main) if
 * the snake runs into itself
 */
class SnakeSegment implements MazeItems {
	int row;
	int column;
	public SnakeSegment(int y, int x) {
		row = y;
		column = x;
	}
	public boolean isWall() {
		return false;
	}
	public void printItem() {
		System.out.print("o");
	}
	public void eat(Snake snake, MazeGenerator generator) {
		throw new RuntimeException("SNAKES CAN'T EAT SNAKES");
	}
	// makes an array to keep track of the location of the snake
	public int[] location() {
		int[] location = new int[2];
		location[1] = column;
		location[0] = row;
		return location;
	}
}