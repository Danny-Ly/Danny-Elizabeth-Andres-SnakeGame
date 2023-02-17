package application;

public class Snake {
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
	
	String user_input;
	
	
	public Snake(String use_input,int col_movement, int r_movement,int col_snake, int r_snake, int snakeLength) {
		user_input = use_input;
		
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
	public void runIntoWall (MazeGenerator mazeCreation ) {
		if ((mazeCreation.maze[column_snake + column_movement][row_snake + row_movement])==(WALL)) {
			System.out.println("GameOver");
			// this needs to be = instead of equalsIgnoreCase to work
			user_input="quit";
			;
		}
	}
	public void eatPellet (MazeGenerator mazeCreation ) {
		if ((mazeCreation.maze[column_snake + column_movement][row_snake + row_movement])==(PELLET)) {
			SNAKE_LENGTH+=1;
			System.out.println("Extra");
			
		}
	}
	public void runIntoItself(MazeGenerator mazeCreation) {
		if ((mazeCreation.maze[column_snake + column_movement][row_snake + row_movement])!=EMPTY) {
			if((mazeCreation.maze[column_snake+column_movement][row_snake+ row_movement])<WALL){
				if((mazeCreation.maze[column_snake+column_movement][row_snake+ row_movement])<PELLET) {
					if((mazeCreation.maze[column_snake+column_movement][row_snake+ row_movement])!=SNAKE_LENGTH) {
						System.out.println("GameOver");
						// this needs to be = instead of equalsIgnoreCase to work
						user_input="quit";
					}
				}
			}
		}
	}
}



