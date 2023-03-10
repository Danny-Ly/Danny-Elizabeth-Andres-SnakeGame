package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public interface MazeItems {

	public void printItem();

	public void eat(Snake snake, MazeGenerator generator);

	public boolean isWall();

}

class Bombs implements MazeItems {
	@FXML
	private Label displayMaze;
	
	public void printItem() {
		System.out.print("@");
		//displayMaze.setText("@");

	}

	public void eat(Snake snake, MazeGenerator generator) {
		snake.eatBomb(generator);
	}

	public boolean isWall() {
		return false;
	}
}

class Pellets implements MazeItems {
	@FXML
	private Label displayMaze;
	
	public void printItem() {
		System.out.print(".");
		//displayMaze.setText(".");
	}

	public void eat(Snake snake, MazeGenerator generator) {
		snake.eatPellet(generator);
	}

	public boolean isWall() {
		return false;
	}
}

class Wall implements MazeItems {
	@FXML
	private Label displayMaze;
	
	public boolean isWall() {
		return true;
	}

	public void printItem() {
		System.out.print("#");
		//displayMaze.setText("#");
	}

	public void eat(Snake snake, MazeGenerator generator) {
		throw new RuntimeException("SNAKES CAN'T EAT WALLS");
	}

}

class SnakeSegment implements MazeItems {
	@FXML
	private Label displayMaze;
	
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
		//displayMaze.setText("o");
	}

	public void eat(Snake snake, MazeGenerator generator) {
		throw new RuntimeException("SNAKES CAN'T EAT SNAKES");
	}

	public int[] location() {
		int[] location = new int[2];
		location[1] = column;
		location[0] = row;
		return location;

	}

	private Main main;

}
