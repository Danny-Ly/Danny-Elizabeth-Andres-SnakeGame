package application;
	
import java.util.Scanner;

public class Main {
	private static final String String = null;



	public void start() {
		System.out.println("SnakeMaze");
		System.out.println("Press Enter To Start");
		inp = new Scanner(System.in); // scans user input
		String line = inp.nextLine(); // creates a string using the last user input
		System.out.println("Your Input is:" + line);
		difficulty = 0;
		

		while (line != "") {
			line = inp.nextLine();
			if (line != ""){
				System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to existing string and displays result
			}
		}
		
		// Exit the while loop if !(line == "easy" || line == "medium" || line == "hard")
		
		while (!(line.equalsIgnoreCase("easy"))) {
			System.out.println("Select difficulty:\n easy \n medium \n hard");
			line = inp.nextLine();
			line = line.toLowerCase().trim();
			if (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium") || line.equalsIgnoreCase("hard"))){
				System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to existing string and displays result
				}
			
			if (line.equalsIgnoreCase("medium") || line.equalsIgnoreCase("hard")) {
				difficulty = 1;
				System.out.println("This Version is still in progress");
			
			}
		}
		
		if (line.equalsIgnoreCase("easy")) {
			difficulty = 0;
			//generate map random
			//MazeGenerator snakeMaze = new MazeGenerator();
			//snakeMaze.creation();
		}
		
		mazeCreation = new MazeGenerator(difficulty);
		pellets = new Rewards(mazeCreation);
		mazeCreation.boundary(pellets);
		
		snake();
		
		}


	
	// need to move some of these into the Snake class
	//have to source one thing before handing in
	
	public void movement_of_snake() {
		
	}
	
	public void snake(){
		
		String user_input = "";
		if (difficulty == 0) {
		while (!(user_input.equalsIgnoreCase("u"))) {
			System.out.println("Make a move");
			inp = new Scanner(System.in);
			user_input = inp.nextLine(); 
			//System.out.println (user_input);
			
			if (user_input.equalsIgnoreCase("d")){
				if ((mazeCreation.maze[column_snake][row_snake + 1])==(WALL)) {
					System.out.println("GameOver");
					// this needs to be = instead of equalsIgnoreCase to work
					user_input="u";
				}
				if ((mazeCreation.maze[column_snake][row_snake + 1])==(PELLET)) {
					
					SNAKE_LENGTH += 1;
					System.out.println("Extra");
				}
				

				if (SNAKE_LENGTH >= 1) {
					mazeCreation.maze [column_snake][row_snake] = SNAKE_LENGTH;
					mazeCreation.maze [column_snake][row_snake + 1] = SNAKE_LENGTH+1;
					row_snake += 1;
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

				mazeCreation.boundary(pellets);		
			
				
				
				//do we have to do compare to right here?
				/*if (SNAKE_LENGTH >= 1) {
					array_for_maze [column_snake][row_snake] = SNAKE_LENGTH; 
					array_for_maze [column_snake][row_snake + 1] = SNAKE_LENGTH +1;
					row_snake += 1;
					for (int i = 0; i < 10; i++) {
						for (int j = 0; j < 20; j++) {
							if (array_for_maze [i][j] == WALL) {	
								array_for_maze [i][j] = 'W';
							} 
							else if (array_for_maze[i][j]== PELLET) {
								array_for_maze [i][j] = 'P';
							}
							else if (array_for_maze[i][j]== EMPTY) {
								array_for_maze [i][j] = 0;
							}
							// how to check if this element is an interger?
							else if (array_for_maze[i][j] instanceof int) {
								array_for_maze[i][j] -= 1;
							}
							
						}
					}
					
				
				
			}*/

				
			
		}
			if (user_input.equalsIgnoreCase("a")){
				if ((mazeCreation.maze[column_snake][row_snake - 1])==(WALL)) {
					System.out.println("GameOver");
					user_input="u";
				}
				if ((mazeCreation.maze[column_snake][row_snake - 1])==(PELLET)) {
					SNAKE_LENGTH += 1;
					System.out.println("Extra");
				}
				if (SNAKE_LENGTH >= 1) {
					mazeCreation.maze [column_snake][row_snake] = SNAKE_LENGTH;
					mazeCreation.maze [column_snake][row_snake - 1] = SNAKE_LENGTH+1;
					row_snake -= 1;
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

				mazeCreation.boundary(pellets);		
			}
			if (user_input.equalsIgnoreCase("w")){
				if ((mazeCreation.maze[column_snake - 1][row_snake])==(W)) {
					System.out.println("GameOver");
					user_input="u";
				}
				if ((mazeCreation.maze[column_snake - 1][row_snake])==(P)) {
					SNAKE_LENGTH += 1;
					System.out.println("Extra");
				}
				
				if (SNAKE_LENGTH >= 1) {
					mazeCreation.maze [column_snake][row_snake] = SNAKE_LENGTH;
					mazeCreation.maze [column_snake - 1][row_snake] = SNAKE_LENGTH+1;
					column_snake -= 1;
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
				mazeCreation.boundary(pellets);	
			}
			if (user_input.equalsIgnoreCase("s")){
				if ((mazeCreation.maze[column_snake + 1][row_snake])==(W)) {
					System.out.println("GameOver");
					user_input="u";
				}
				if ((mazeCreation.maze[column_snake + 1][row_snake])==(P)) {
					SNAKE_LENGTH += 1;
					System.out.println("Extra");
				}
				if (SNAKE_LENGTH >= 1) {
					mazeCreation.maze [column_snake][row_snake] = SNAKE_LENGTH;
					mazeCreation.maze [column_snake + 1][row_snake] = SNAKE_LENGTH + 1;
					column_snake += 1;
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
			mazeCreation.boundary(pellets);	
			
			}

			}
		}
		}
		
	}
	
	private Scanner inp; // scans user input
	//these values were alters in the interest of the mazegenerator class
	private static int EMPTY = 0;
	private static char WALL = 'W';
	private static char PELLET = 'P';
	
	private static char W = 'W';
	private static char P = 'P';
	private static int SNAKE_LENGTH = 1;
	private int difficulty;

	private static int row_snake = 9;
	private static int column_snake = 4;
	private MazeGenerator mazeCreation;
	private Rewards pellets;
	
	
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();
	}
	
}

