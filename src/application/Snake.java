package application;
/**
 * This class is handles when the user inputs WASD, the snake will move accordinly. 
 * And will interact with the mazes randomly generated Walls and pellets,
 * that will infuelnce the snakes action perfomed. 
 * @author Written by Danny, assisted and co-written by Andres and Elizabeth.
 *
 */
public class Snake {
	// initializing all varibles that will be used in this class
	public static int EMPTY = 0;
	public static char WALL = 30000;
	public static char PELLET = 10000;
	public int difficulty = 0;
	public int SNAKE_LENGTH;
	public int row_snake;
	public int column_snake;
	public int column_movement;
	public int row_movement;
	int [][] newSnakeMaze;
	String userInput;
	
	/**
	 * Constructor that is called in main that will infuence how the the snake is moving.
	 * @param useInput a string value of the user input (WASD)
	 * @param col_movement integer value representing the y-axis movment of snake
	 * @param r_movement integer value representing the x-axis movement of snake 
	 * @param col_snake integer value representing the y-axis postion of snake 
	 * @param r_snake integer value representing the x-axis postiotion of snake
	 * @param snakeLength length of snake
	 */
	public Snake(String useInput,int col_movement, int r_movement,int col_snake, int r_snake, int snakeLength) {
		userInput = useInput;
		
		column_movement = col_movement;
		//System.out.println(column_movement);
		row_movement = r_movement;
		//System.out.println(row_movement);
		column_snake = col_snake;
		//System.out.println("column snake" +column_snake);
		row_snake = r_snake;
		//System.out.println("row snake"+ row_snake);
		SNAKE_LENGTH = snakeLength;
		

	}
	// for the extension of the snake, this was inspired by reading Snake Task #5 on this website:
	// https://www.kosbie.net/cmu/fall-11/15-112/handouts/snake/
	//snake.html#:~:text=In%20the%20game%20of%20Snake,food%2C%20and%20thereby%20grows%20larger
	
	/**
	 * updates the postion/movment of snake in the maze based on user input
	 * and the walls or pellets
	 * @param pellets is from Rewards class that represents the pellets in the maze
	 * @param mazeCreation is from MazeGenerator class that represents the walls in the maze
	 */
	public void movementofSnake(Rewards pellets, MazeGenerator mazeCreation) {

		if (SNAKE_LENGTH >= 1) {
			mazeCreation.maze [column_snake][row_snake] = SNAKE_LENGTH;
			mazeCreation.maze [column_snake + column_movement][row_snake + row_movement] = SNAKE_LENGTH+1;
			if (row_movement == 1) {
				row_snake += 1;
			}
			if (row_movement == (-1)) {
				row_snake -= 1;
			}
			if (column_movement == 1) {
				
				column_snake += 1;
			}
			if (column_movement == (-1)) {
				column_snake -= 1;
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 20; j++) {
					if ((mazeCreation.maze [i][j]) != EMPTY){
						if ((mazeCreation.maze [i][j]) == WALL) {	
							(mazeCreation.maze [i][j]) = WALL;
							
						} 
						else if ((mazeCreation.maze[i][j])== PELLET) {
							(mazeCreation.maze[i][j]) = PELLET;
						}
						else if ((mazeCreation.maze[i][j])== (int)(mazeCreation.maze[i][j])) {
							
							(mazeCreation.maze[i][j]) = (mazeCreation.maze[i][j]) - 1;
						}
					}
				}
			}
		}
	}
	/**
	 * This checks if the snake has the same cordinates as a wall
	 * @param mazeCreation is from MazeGenerator class that represent all objects in the maze
	 */
	public void runIntoWall (MazeGenerator mazeCreation ) {
		if ((mazeCreation.maze[column_snake + column_movement][row_snake + row_movement])==(WALL)) {
			System.out.println("GameOver");
			// this needs to be = instead of equalsIgnoreCase to work
			userInput="quit";
			;
		}
	}
	/**
	 * This checks if the snake has the same corrdinates as a pellet
	 * @param mazeCreation is from MazeGenerator class that represent all objects in the maze
	 */
	public void eatPellet (MazeGenerator mazeCreation ) {
		if ((mazeCreation.maze[column_snake + column_movement][row_snake + row_movement])==(PELLET)) {
			SNAKE_LENGTH+=1;
			System.out.println("Extra");
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 20; j++) {
//					if (mazeCreation.maze[i][j]==PELLET) {
//						counter +=1;
//					}
//				} 
//			}
				
		}
	}
	/**
	 * This Checks if the snake has the same cordinates as itslef 
	 * @param mazeCreation is from MazeGenerator class that represent all objects in the maze
	 */
	public void runIntoItself(MazeGenerator mazeCreation) {
		if ((mazeCreation.maze[column_snake + column_movement][row_snake + row_movement])!=EMPTY) {
			if((mazeCreation.maze[column_snake+column_movement][row_snake+ row_movement])<WALL){
				if((mazeCreation.maze[column_snake+column_movement][row_snake+ row_movement])<PELLET) {
					if((mazeCreation.maze[column_snake+column_movement][row_snake+ row_movement])!=SNAKE_LENGTH) {
						System.out.println("GameOver");
						// this needs to be = instead of equalsIgnoreCase to work
						userInput="quit";
					}
				}
			}
		}
	}
}