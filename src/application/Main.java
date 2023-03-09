// Majority of this program's syntax is based off of the lecture videos 
// and demos on the CPSC 219 D2L shell (WINTER 2019).
package application;

import java.io.FileInputStream;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * The class that calls upon MazeGeneerator, Rewards and Snake class, to allow
 * all classes to function together properly in unison.
 * 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		difficulty = 0;
		boolean loopOfGame = true;
		
		// from the creating GUI using JavaFX demos
		// generates the initial GUI scene
		
		/*try {
			//BorderPane root = new BorderPane();
			// from demo 2 (adding a FXML document to the project)
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/SnakeGameDisplay.fxml"));
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Snake Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	*/
		//from the lecture of creating GUI using Java FX
		VBox root = new VBox();
		Button easyButton = new Button("easy(test)");
		
		root.getChildren().add(easyButton);
		
		Scene scene = new Scene (root,600,300);
		primaryStage.setTitle("Snake Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
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

	// for the above, this now extends application, do we need to note this?
	private static final String String = null;

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
					// creating new object of snake, to check if any
					// further altering of map is needed based on this change in position.

					// instance of Snake class was called to deal with
					// running into a wall or itself, extending when eating a pellet,
					// and the movement of the snake itself.
				}
				if (userInput.equalsIgnoreCase("a")) {
					int row_movement = 0;
					int column_movement = -1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();

					// userInput = runIntoWall (user_input,column_snake, row_snake, WALL,
					// row_movement,column_movement);

					// creating new object of snake, to check if any further altering of map is
					// needed based on this change in position.

				}

				if (userInput.equalsIgnoreCase("w")) {
					int row_movement = -1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
					// runIntoWall (user_input,column_snake, row_snake, WALL,
					// row_movement,column_movement);
					// creating new object of snake, to check if any further altering of map is
					// needed based on this change in position.

				}

				if (userInput.equalsIgnoreCase("s")) {
					int row_movement = 1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();

					// creating new object of snake, to check if any further altering of map is
					// needed based on this change in position.
					// runIntoWall (user_input,column_snake, row_snake, WALL,
					// row_movement,column_movement);

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
	
	private Scanner inp; // scans user input
	// these values were alters in the interest of the mazeGenerator class

	private static int SNAKE_LENGTH = 1;
	private int difficulty;

	private static int row_snake = 9;
	private static int column_snake = 4;


	private MazeGenerator mazeCreation;
	private Snake snake;
	private ItemGenerator pellets;

	public static void main(String[] args) {

		//Main application = new Main();
		//application.start(primaryStage);
		// explain this
		launch(args);
		
	}

}
