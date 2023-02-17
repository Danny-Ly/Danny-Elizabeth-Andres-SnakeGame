// Majority of this program's syntax is based off of the lecture videos 
// and demos on the CPSC 219 D2L shell (WINTER 2019).
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
		
		String userInput = "";
		if (difficulty == 0) {
		while (!(userInput.equalsIgnoreCase("quit"))) {
			System.out.println("Make a move");
			inp = new Scanner(System.in);
			userInput = inp.nextLine(); 
			//System.out.println (user_input);
			
			if (userInput.equalsIgnoreCase("d")){
				int row_movement = 1;
				int column_movement = 0;
				
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
				
	
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;

				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
			
				//mainAndClassInteraction(column_movement, row_movement,
					//	 column_snake,  row_snake, SNAKE_LENGTH, pellets, mazeCreation, WALL, PELLET);
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				mazeCreation.boundary(pellets);		
				
			
		}
			if (userInput.equalsIgnoreCase("a")){
				int row_movement = (-1);
				int column_movement = 0;
				
				// userInput = runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
						

				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				mazeCreation.boundary(pellets);		
			}
			
			if (userInput.equalsIgnoreCase("w")){
				int row_movement = 0;
				int column_movement = (-1);
				
				//runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
		
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				mazeCreation.boundary(pellets);	
			}
			
			if (userInput.equalsIgnoreCase("s")){
				int row_movement = 0;
				int column_movement = 1;
				
				//runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
				
				

				//snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
//				for (int i = 0; i < 10; i++) {
//					for (int j = 0; j < 20; j++) {
//						if (mazeCreation.maze[i][j]==PELLET) {
//							
//							counter +=1;
//							System.out.println(counter);
//						}
//					} 
//				}	
				mazeCreation.boundary(pellets);	
				
//				if (counter == 0) {
//					System.out.println("YOU WON!");
//					userInput = "quit";
//				}
			
			}

		}
	}
}

	
	public void start() {
		
		difficulty = 0;
		boolean loopOfGame = true;
		while (loopOfGame == true){
			System.out.println("__________________");
			System.out.println("SnakeMaze");
			System.out.println("Press Enter To Start");
			inp = new Scanner(System.in); // scans user input
			String line = inp.nextLine(); // creates a string using the last user input
			System.out.println("Your Input is:" + line);
		
			// this loop infinitely loops the game 
			
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
	}

	
	private Scanner inp; // scans user input
	//these values were alters in the interest of the mazegenerator class
//	private static int EMPTY = 0;
//	private static int WALL = 30000;
//	private static int PELLET = 10000;
//	
//	private static char W =30000;
//	private static char P = 10000;
	private static int SNAKE_LENGTH = 1;
	private int difficulty;
	//private int counter=0;

	private static int row_snake = 9;
	private static int column_snake = 4;

	private static MazeGenerator mazeCreation;
	private static Rewards pellets;
	private static Snake snakeMove;
	
	
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();
	}
	
}

