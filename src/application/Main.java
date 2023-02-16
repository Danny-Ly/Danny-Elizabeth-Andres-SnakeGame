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
		System.out.println("Select difficulty:\n easy \n medium \n hard");
		// Exit the while loop if !(line == "easy" || line == "medium" || line == "hard")
		line.compareTo("easy");
		while (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium") ||line.equalsIgnoreCase("hard"))){
			line = inp.nextLine();
			line = line.toLowerCase().trim();
			if (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium") || line.equalsIgnoreCase("hard"))){
				System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to existing string and displays result
			}
		}
		
		if (line.equalsIgnoreCase("easy")) {
			difficulty = 0;
			//generate map random
			//MazeGenerator snakeMaze = new MazeGenerator();
			//snakeMaze.creation();

			array_for_maze = new int[column_map][row_map];
			
			for (int i = 0; i < 20; i++) {
				array_for_maze[0][i] = WALL;
				
			}
			for (int i = 0; i < 10; i++) {
				array_for_maze[i][0] = WALL;
			}
			for (int i = 0; i < 20; i++) {
				array_for_maze[9][i] = WALL;
			}
			for (int i = 0; i < 10; i++) {
				array_for_maze[i][19] = WALL;
			}
			
			array_for_maze [2][2] = WALL; // y then x
			array_for_maze [2][3] = WALL;
			array_for_maze [2][4] = WALL;
			array_for_maze [2][5] = WALL;
			array_for_maze [3][2] = WALL;
			array_for_maze [4][2] = WALL;
			
			array_for_maze [2][15] = WALL; 
			array_for_maze [2][16] = WALL;
			array_for_maze [3][16] = WALL;
			array_for_maze [4][16] = WALL;
			array_for_maze [5][15] = WALL;
			array_for_maze [5][16] = WALL;

			array_for_maze [5][9] = WALL;
			array_for_maze [5][8] = WALL;
			array_for_maze [5][10] = WALL;
			array_for_maze [4][8] = WALL;
			array_for_maze [4][10] = WALL;
			
			array_for_maze [6][2] = WALL; 
			array_for_maze [6][3] = WALL;
			array_for_maze [6][4] = WALL;
			array_for_maze [7][4] = WALL;

			array_for_maze [7][14] = WALL; 
			array_for_maze [7][17] = WALL;
			array_for_maze [7][16] = WALL;
			array_for_maze [7][15] = WALL;
			
			array_for_maze [3][10] = PELLET;
			array_for_maze [2][14] = PELLET;
			array_for_maze [1][8] = PELLET;
			array_for_maze [1][8] = PELLET;
			
			array_for_maze [column_snake][row_snake] = SNAKE;

			boundary(); 
		}
		
		if (line.equalsIgnoreCase("medium")) {
			difficulty = 1;
			System.out.println("This Version is still in progress");
		}
		if (line.equalsIgnoreCase("hard")){
			difficulty = 2;
			System.out.println("This Version is still in progress");
		}
		
		snake();
	}
	
	public void boundary(){
		 
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if (array_for_maze [i][j] == WALL) {	
					System.out.print("#");
				}
				if (array_for_maze[i][j]== PELLET) {
					System.out.print(".");
				}
				if (array_for_maze[i][j]== SNAKE) {
					System.out.print("O");
				}
				if (array_for_maze[i][j]== EMPTY) {
					System.out.print(" ");
				}
			}
			
			System.out.println();				
		}	
	}
	// need to move some of these into the Snake class
	//have to source one thing before handing in
	public void snake(){
		
		String user_input = "";
		while (!(user_input.equalsIgnoreCase("u"))) {
			System.out.println("Make a move");
			inp = new Scanner(System.in);
			user_input = inp.nextLine(); 
			//System.out.println (user_input);
			
			if (user_input.equalsIgnoreCase("d")){
				if ((array_for_maze[column_snake][row_snake + 1])==(WALL)) {
					System.out.println("GameOver");
					// this needs to be = instead of equalsIgnoreCase to work
					user_input="u";
				}
				if ((array_for_maze[column_snake][row_snake + 1])==(PELLET)) {
					
					SNAKE_LENGTH += 1;
					System.out.println("Extra");
				}
				// USE THIS CODE IF THE BOTTOM ONE ISNT WORKING!
				/*array_for_maze [column_snake][row_snake] = EMPTY;
				array_for_maze [column_snake ][row_snake+1] = SNAKE;
				row_snake += 1;*/
				
				//do we have to do compare to right here?
				if (SNAKE_LENGTH >= 1) {
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
							// how to check if this element is an integer?
							//https://stackoverflow.com/questions/12558206/how-can-i-check-if-a-value-is-of-type-integer
							else if ((array_for_maze[i][j])== (int)(array_for_maze[i][j])) {
								array_for_maze[i][j] -= 1;
							}
							
						}
					}
				
				
			}
				boundary();	
			}
			if (user_input.equalsIgnoreCase("a")){
				if ((array_for_maze[column_snake][row_snake - 1])==(WALL)) {
					System.out.println("GameOver");
					user_input="u";
				}
				if ((array_for_maze[column_snake][row_snake - 1])==(PELLET)) {
					SNAKE_LENGTH += 1;
				}
				array_for_maze [column_snake][row_snake] = EMPTY;
				array_for_maze [column_snake][row_snake - 1] = SNAKE;
				row_snake -= 1;
				boundary();	
			}
			if (user_input.equalsIgnoreCase("w")){
				if ((array_for_maze[column_snake - 1][row_snake])==(WALL)) {
					System.out.println("GameOver");
					user_input="u";
				}
				if ((array_for_maze[column_snake - 1][row_snake])==(PELLET)) {
					SNAKE_LENGTH += 1;
				}
				array_for_maze [column_snake][row_snake] = EMPTY;
				array_for_maze [column_snake - 1][row_snake] = SNAKE;
				column_snake -= 1;
				boundary();	
			}
			if (user_input.equalsIgnoreCase("s")){
				if ((array_for_maze[column_snake + 1][row_snake])==(WALL)) {
					System.out.println("GameOver");
					user_input="u";
				}
				if ((array_for_maze[column_snake + 1][row_snake])==(PELLET)) {
					SNAKE_LENGTH += 1;
				}
				array_for_maze [column_snake][row_snake] = EMPTY;
				array_for_maze [column_snake + 1][row_snake] = SNAKE;
				column_snake += 1;
				boundary();	
			}

		
		}
		
	}
	
	private Scanner inp; // scans user input		
	private static int EMPTY = 0;
	private static int SNAKE = 1; 
	private static char WALL = 'W';
	private static char PELLET = 'P';
	private static int SNAKE_LENGTH = 1;
	private int difficulty;
	private int[][] array_for_maze;
	//private Snake snakeMove = new Snake();

	private static int row_map = 20;
	private static int column_map = 10;
	
	private static int row_snake = 9;
	private static int column_snake = 4;
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();
	}
	
}

