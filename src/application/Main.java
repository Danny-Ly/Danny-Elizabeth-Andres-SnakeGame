// Majority of this program's syntax is based off of the lecture videos 
// and demos on the CPSC 219 D2L shell (WINTER 2019).
package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

/**
 * The class that calls upon MazeGeneerator, Rewards and Snake class, to allow
 * all classes to function together properly in unison.
 * 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main extends Application{
	@FXML
	private Label displayMaze;
	
	// I got this code to switch the scene from this video from Bro Code.
	// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
	// code allows for switching of scene.
	@FXML 
    public void startGameInput(ActionEvent event) throws IOException {
		System.out.println("Start button pressed (should switch to a difficulty selector scene)");
		
		Parent root = FXMLLoader.load(getClass().getResource("DifficultySelector.fxml"));
		Stage difficultyStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene difficultyScene = new Scene(root);
		difficultyStage.setScene(difficultyScene);
		difficultyStage.show();
		
	}
	
	void getInputValue(TextField userInputtedValue) {
		String line = "easy";
		difficulty = 0;
		String enteredUserAction = "";
	
		enteredUserAction = userInputtedValue.getText();
		System.out.println(enteredUserAction);
		//userInteraction(enteredUserAction);
		
		// change scanner to string and change it whenever for loop to work 
		// if button pressed, assign this to b, if b then execute this loop, if not b execute another loop
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
			userInteraction(enteredUserAction);
			//System.out.println("WINNER");
		} catch (RuntimeException ERROR) {
			System.out.println("GAME OVER");
		}
		line = "";
	
	}
	
	@FXML
    public void easyButtonPressed(ActionEvent event) throws IOException {
		difficulty = 0;
		boolean loopOfGame = true;
		
		
		System.out.println("Easy button pressed (should switch to a snake game scene)");
		
		mazeCreation = new MazeGenerator(difficulty);
		snake = new Snake(mazeCreation);
		mazeCreation.boundary();
		
		VBox allRows = new VBox();
		TextField userInputtedValue = new TextField();
		Button userInputSnake = new Button ("Input");
		
		userInputSnake.setOnAction(userInputAction -> getInputValue(userInputtedValue));
		
		allRows.getChildren().addAll(userInputtedValue,userInputSnake);
		
		Scene gameScene = new Scene(allRows);
		Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainStage.setScene(gameScene);
		mainStage.show();
	} 
	

	
	@Override
	public void start(Stage primaryStage) {
		difficulty = 0;
		boolean loopOfGame = true;
		
		// from the creating GUI using JavaFX demos
		// generates the initial GUI scene
		
		try {
			// from demo 2 (adding a FXML document to the project)
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/SnakeGameTitle.fxml"));
			Scene mainScene = new Scene(root,1000,400);
			//from demo 2 of GUI lecture
//			MazeGenerator controller = (MazeGenerator)loader.getController();
//			controller.gameStage = primaryStage;
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Snake Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("__________________");
		System.out.println("SnakeMaze");
		System.out.println("Press Enter To Start");
		

	}

	// for the above, this now extends application, do we need to note this?
	private static final String String = null;

	/**
	 * This handles when the user enters WASD, will handle these four cases of
	 * different inputs, and will call Snake class to do their certain action, that
	 * is needed.
	 */
	public void userInteraction(String enteredUserAction) {
		//String userInput = "";
		if (difficulty == 0) {
//			while (!(enteredUserAction.equalsIgnoreCase("quit"))) {
			

				// there is the input of a(right), d(left), w(up), and s(down)
				// that call the snake class to allow for it to function.
				
				if (enteredUserAction.equalsIgnoreCase("d")) {
					int row_movement = 0;
					int column_movement = 1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}

				
				if (enteredUserAction.equalsIgnoreCase("a")) {
					int row_movement = 0;
					int column_movement = -1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}


				
				if (enteredUserAction.equalsIgnoreCase("w")) {
					int row_movement = -1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				
	
					// runIntoWall (user_input,column_snake, row_snake, WALL,
					// row_movement,column_movement);
					// creating new object of snake, to check if any further altering of map is
					// needed based on this change in position.
					
				}
				if (enteredUserAction.equalsIgnoreCase("s")) {
					int row_movement = 1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}


					// creating new object of snake, to check if any further altering of map is
					// needed based on this change in position.
					// runIntoWall (user_input,column_snake, row_snake, WALL,
					// row_movement,column_movement);

//				}
				
				if (mazeCreation.ifVictory() == false) {
					System.out.println("victory");
					//termination of program
					System.exit(0);
					return;
					
					
				
				}
			}
		}
//	}
	
	
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
