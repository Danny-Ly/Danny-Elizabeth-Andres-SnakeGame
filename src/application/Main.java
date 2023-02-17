package application;
	
import java.util.Scanner;

public class Main {
	private static final String String = null;
	
//	public void mainAndClassInteraction(int column_movement, int row_movement,
//			int column_snake, int row_snake, int SNAKE_LENGTH,
//			 Rewards pellets, MazeGenerator mazeCreation, int WALL, int PELLET) {
//		
//			snakeMove = new Snake(column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
//			snakeMove.movementofSnake(pellets, mazeCreation);
//			row_snake = snakeMove.row_snake;
//			column_snake = snakeMove.column_snake;
//			mazeCreation.boundary(pellets);
//	}



	public void userInteraction(){
		
		String user_input = "";
		if (difficulty == 0) {
		while (!(user_input.equalsIgnoreCase("quit"))) {
			System.out.println("Make a move");
			inp = new Scanner(System.in);
			user_input = inp.nextLine(); 
			//System.out.println (user_input);
			
			if (user_input.equalsIgnoreCase("d")){
				int row_movement = 1;
				int column_movement = 0;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				user_input = snakeMove.user_input;
				
	
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
//				if ((mazeCreation.maze[column_snake][row_snake + 1])==(PELLET)) {
//							
//					SNAKE_LENGTH += 1;
//					System.out.println("Extra");
//				}
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				user_input = snakeMove.user_input;
				//mainAndClassInteraction(column_movement, row_movement,
					//	 column_snake,  row_snake, SNAKE_LENGTH, pellets, mazeCreation, WALL, PELLET);
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				mazeCreation.boundary(pellets);		
				
			
		}
			if (user_input.equalsIgnoreCase("a")){
				int row_movement = (-1);
				int column_movement = 0;
				
				// userInput = runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				user_input = snakeMove.user_input;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				user_input = snakeMove.user_input;

				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				mazeCreation.boundary(pellets);		
			}
			
			if (user_input.equalsIgnoreCase("w")){
				int row_movement = 0;
				int column_movement = (-1);
				
				//runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				user_input = snakeMove.user_input;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				user_input = snakeMove.user_input;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				mazeCreation.boundary(pellets);	
			}
			
			if (user_input.equalsIgnoreCase("s")){
				int row_movement = 0;
				int column_movement = 1;
				
				//runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				user_input = snakeMove.user_input;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				user_input = snakeMove.user_input;
				
//				if((mazeCreation.maze[column_snake+1][row_snake])!=0){
//					if((mazeCreation.maze[column_snake+1][row_snake])<WALL){
//						if((mazeCreation.maze[column_snake+1][row_snake])<PELLET) {
//							if((mazeCreation.maze[column_snake+1][row_snake])!=SNAKE_LENGTH) {
//								System.out.println("GameOver");
//								// this needs to be = instead of equalsIgnoreCase to work
//								user_input="u";
//							}
//						}	
//					}
//
//				}
				snakeMove = new Snake(user_input, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				mazeCreation.boundary(pellets);	
			
			}

		}
	}
}

	
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
		}
		
		
		mazeCreation = new MazeGenerator(difficulty);
		mazeCreation.boundary(pellets);
		
		userInteraction();
		
		}

	
	private Scanner inp; // scans user input
	//these values were alters in the interest of the mazegenerator class
	private static int EMPTY = 0;
	private static int WALL = 30000;
	private static int PELLET = 10000;
	
	private static char W =30000;
	private static char P = 10000;
	private static int SNAKE_LENGTH = 1;
	private int difficulty;

	private static int row_snake = 9;
	private static int column_snake = 4;
	
	private MazeGenerator mazeCreation;
	private Rewards pellets;
	private Snake snakeMove;
	//private Snake runWallSnake;
	
	
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();
	}
	
}

