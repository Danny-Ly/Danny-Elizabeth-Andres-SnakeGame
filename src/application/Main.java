package application;
	
import java.util.Scanner;

public class Main {
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
			array_for_maze = new int[10][20];
			
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
			}
			
			System.out.println();
				
		}
	
	}
	
	public void snake(){
		
		String move = inp.nextLine();
		if (move.compareToIgnoreCase("w")== 0);
		
			
			
		
		
		
	}
	
	private Scanner inp; // scans user input		
	private static final int EMPTY = 3;
	private static final int SNAKE = 1; 
	private static final int WALL = 2;
	private static final int PELLET = 0;
	private int difficulty;
	private int[][] array_for_maze;
	private int[][] array_for_snake;
	
	
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();
	}
	
}

