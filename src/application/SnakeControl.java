
package application;

import java.util.TimerTask;

public class SnakeControl extends TimerTask{
	Snake snake;
	MazeGenerator mazeCreation;
	int row_movement;
	int column_movement;
	public SnakeControl(Snake m_snake,MazeGenerator m_mazeCreation, int m_row_movement,int m_column_movement) {
		snake = m_snake;
		mazeCreation = m_mazeCreation;
		row_movement = m_row_movement;
		column_movement = m_column_movement;	

	}
	public int getRow_movement() {
		return row_movement;
	}
	public void setRow_movement(int row_movement) {
		this.row_movement = row_movement;
	}
	public int getColumn_movement() {
		return column_movement;
	}
	public void setColumn_movement(int column_movement) {
		this.column_movement = column_movement;
	}
	public void run() {	
		snake.moveSnake(mazeCreation, row_movement, column_movement);
		mazeCreation.boundary();
	}
}
