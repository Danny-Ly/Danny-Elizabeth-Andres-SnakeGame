package application;

public class Snake {
	public static int EMPTY = 0;
	public static char WALL = 'W';
	public static char PELLET = 'P';
	
	public static int SNAKE_LENGTH = 1;

	public int row_snake;
	public int column_snake;
	
	public int column_movement;
	public int row_movement;
	
	
	public Snake(int col_movement, int r_movement,MazeGenerator mazeCreation) {
		column_movement = col_movement;
		row_movement = r_movement;
	}
	
	public void movementofSnake() {
		
		
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
}
//		for(int i=0; i<mazeCreation.maze.length; i++) {
//			for(int j=0; j <mazeCreation.maze[i].length; j++) {
//				int[] locationarray = new int[2];
//				locationarray[0]=i;
//				locationarray[1]= j;
//				if (mazeCreation.maze [i][j] == WALL) {	
//					System.out.print("#");
//				}
//				else if (mazeCreation.maze[i][j] == PELLET){
//					// make this maze equal to pellet.
//					mazeCreation.maze[i][j] = PELLET;
//					System.out.print(".");
//				}
//				else if (mazeCreation.maze[i][j]== EMPTY) {
//					System.out.print(" ");
//				}	
//				else if (mazeCreation.maze[i][j]== (int)mazeCreation.maze[i][j]) {
//					if (mazeCreation.maze [i][j] != 0) {
//						System.out.print("O");	
//					}
//				
//				}
//			}	
//		
//			System.out.println();
//		}
//	}
//}
	
