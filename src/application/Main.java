// Majority of this program's syntax is based off of the lecture videos 
// and demos on the CPSC 219 D2L shell (WINTER 2019).
package application;

import java.util.Scanner;

/**
 * The class that calls upon MazeGeneerator, Rewards and Snake class, to allow
 * all classes to function together properly in unison.
 * 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main {

	/**
	 * This handles when the user enters WASD, will handle these four cases of
	 * different inputs, and will call Snake class to do their certain action, that
	 * is needed.
	 */
	public void userInteraction() {
		String userInput = "";
		if (difficulty == 0) {
			while (!(userInput.equalsIgnoreCase("quit"))) {
				System.out.println("Make a move");
				inp = new Scanner(System.in);
				userInput = inp.nextLine();

				// there is the input of a(right), d(left), w(up), and s(down)
				// that call the snake class to allow for it to function.
				if (userInput.equalsIgnoreCase("d")) {
					int row_movement = 0;
					int column_movement = 1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
					
				}
				if (userInput.equalsIgnoreCase("a")) {
					int row_movement = 0;
					int column_movement = -1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();

					

				}

				if (userInput.equalsIgnoreCase("w")) {
					int row_movement = -1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
					

				}

				if (userInput.equalsIgnoreCase("s")) {
					int row_movement = 1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();

		

				}
				if (mazeCreation.ifVictory() == false) {
					return;
					
					
					
				}
			}
		}
	}

	/**
	 * This handles user input of when the program is first run, this is where the
	 * difficulty us chosen, that will impact how the maze is created
	 */
	public void start() {
		difficulty = 0;
		boolean loopOfGame = true;
		System.out.println("__________________");
		System.out.println("SnakeMaze");
		System.out.println("Press Enter To Start");
		inp = new Scanner(System.in); // scans user input
		String line = inp.nextLine(); // creates a string using the last user input
		System.out.println("Your Input is:" + line + " If invaild please press enter.");

		// this loop infinitely loops the wrong user input game

		while (line != "") {
			line = inp.nextLine();
			if (line != "") {
				System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to
																							// existing string and
																							// displays result
			}
		}
		while (loopOfGame == true) {

			// Exit the while loop if !(line == "easy" )

			while (!(line.equalsIgnoreCase("easy"))) {
				System.out.println("Select difficulty:\n easy \n medium \n hard");
				line = inp.nextLine();
				line = line.toLowerCase().trim();
				if (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium")
						|| line.equalsIgnoreCase("hard"))) {
					System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to
																								// existing string and
																								// displays result
				}

				if (line.equalsIgnoreCase("medium") || line.equalsIgnoreCase("hard")) {
					difficulty = 1;
					System.out.println("This Version is still in progress");

				}
			}

			if (line.equalsIgnoreCase("easy")) {
				difficulty = 0;
			}
			// generation of the MazeGenerator and printing of maze
			mazeCreation = new MazeGenerator(difficulty);
			snake = new Snake(mazeCreation);
			mazeCreation.boundary();

			try {
				userInteraction();
				System.out.println("WINNER");
			} catch (RuntimeException ERROR) {
				System.out.println("GAME OVER");
			}
			line = "";
		}
	}

	private Scanner inp; // scans user input
	// these values were alters in the interest of the mazeGenerator class


	private int difficulty;


	private MazeGenerator mazeCreation;
	private Snake snake;


	public static void main(String[] args) {

		Main application = new Main();
		application.start();
	}

}
