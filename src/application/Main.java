// Majority of this program's syntax is based off of the lecture videos 
// and demos on the CPSC 219 D2L shell (WINTER 2019).
package application;
import java.util.Scanner;

/**
 * The class that calls upon MazeGeneerator, Rewards and Snake class, 
 * to allow all classes to function together properly in unison. 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main {
	private static final String String = null;
	
	/**
	 * This handles when the user enters WASD, will handle these four cases of different inputs,
	 *  and will call Snake class to do their certain action, that is needed.
	 */
	public void userInteraction(){
		String userInput = "";
		if (difficulty == 0) {
		while (!(userInput.equalsIgnoreCase("quit"))) {
			System.out.println("Make a move");
			inp = new Scanner(System.in);
			userInput = inp.nextLine(); 
			
			//there is the input of a(right), d(left), w(up), and s(down)
			// that call the snake class to allow for it to function.
			if (userInput.equalsIgnoreCase("d")){
				int row_movement = 1;
				int column_movement = 0;
				//creating new object of snake, to check if any
				//further altering of map is needed based on this change in postion.
				
				// instance of Snake class was called to deal with 
				// running into a wall or itself, extending when eating a pellet,
				// and the movement of the snake itself. 
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
				
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
		
				
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
				
				//creating new object of snake, to check if any further altering of map is needed based on this change in postion.
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;				
				
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
			
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;

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
				//creating new object of snake, to check if any further altering of map is needed based on this change in postion.
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
								
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
								
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
								
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				mazeCreation.boundary(pellets);	
			}
			
			if (userInput.equalsIgnoreCase("s")){
				int row_movement = 0;
				int column_movement = 1;
				
				//creating new object of snake, to check if any further altering of map is needed based on this change in postion.
				//runIntoWall (user_input,column_snake, row_snake, WALL, row_movement,column_movement);
				snakeMove = new Snake(userInput, column_movement, row_movement,column_snake, row_snake, SNAKE_LENGTH);
				snakeMove.runIntoWall(mazeCreation);
				userInput = snakeMove.userInput;
		
				snakeMove.eatPellet(mazeCreation);
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;
				
				snakeMove.runIntoItself(mazeCreation);
				userInput = snakeMove.userInput;
				
				snakeMove.movementofSnake(pellets, mazeCreation);
				row_snake = snakeMove.row_snake;
				column_snake = snakeMove.column_snake;
				SNAKE_LENGTH = snakeMove.SNAKE_LENGTH;

				mazeCreation.boundary(pellets);	
				
			
			}

		}
	}
}

	/**
	 * This handles user input of when the program is first run, this is where the diffuclty us chosen,
	 * that will impact how the maze is created
	 */
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
				//generation of the MazeGenerator and printing of maze
				mazeCreation = new MazeGenerator(difficulty);
				mazeCreation.boundary(pellets);
				
				userInteraction();
			} 
	}

	
	private Scanner inp; // scans user input
	//these values were alters in the interest of the mazeGenerator class

	private static int SNAKE_LENGTH = 1;
	private int difficulty;

	private static int row_snake = 9;
	private static int column_snake = 4;
	
	private MazeGenerator mazeCreation;
	private Rewards pellets;
	private Snake snakeMove;
	
	
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();
	}
	
}

