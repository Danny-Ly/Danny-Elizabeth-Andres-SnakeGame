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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;

/**
 * The class that calls upon MazeGenerator, Rewards and Snake class, to allow
 * all classes to function together properly in unison.
 * 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main extends Application{
	// Initializing/declaring variables that will be used in the class
	private Scanner inp; 
	private MazeGenerator mazeCreation;
	private Snake snake;

	private Stage stage;
	private Scene scene;

	// I got this code to switch the scene from this video from Bro Code.
	// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
	// code allows for switching of scene.
	@FXML 
    public void startGameInput(ActionEvent event) throws IOException {
		System.out.println("Start button pressed (should switch to a difficulty selector scene)");
		
		Parent root = FXMLLoader.load(getClass().getResource("DifficultySelector.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	@FXML
    public void easyButtonPressed(ActionEvent event) throws IOException {
		int difficulty = 0;
		boolean loopOfGame = true;
		
		System.out.println("Easy button pressed (should switch to a snake game scene)");
		
		Parent root = FXMLLoader.load(getClass().getResource("GameplayDisplay.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		String line = "easy";
		
		while (loopOfGame == true) {

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
					System.out.println("Restarted game on EASY: ");
				} catch (RuntimeException ERROR) {
					System.out.println("GAME OVER");
					System.out.println("Restarted game on EASY: ");
				}
				line = "";
			}
		
		}
	
	
	
	/**
	 * This handles when the user enters WASD, will handle these four cases of
	 * different inputs, and will call Snake class to do their certain action, that
	 * is needed.
	 */
	public void userInteraction() {
		int difficulty = 0;
		String userInput = "";
		if (difficulty == 0) {
			while (!(userInput.equalsIgnoreCase("quit"))) {
				System.out.println("Make a move");
				inp = new Scanner(System.in);
				userInput = inp.nextLine();

				// there is the input of a(right), d(left), w(up), and s(down)
				// that call the snake class for the movement of the snake
				// call mazecreation for maze to generate
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
				// continues game if pellets are still in game
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
	public void start(Stage primaryStage) {
		int difficultylocal = 0;
		boolean loopOfGame = true;
		
		// from the creating GUI using JavaFX demos
		// generates the initial GUI scene
		
		try {
			//BorderPane root = new BorderPane();
			// from demo 2 (adding a FXML document to the project)
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/SnakeGameTitle.fxml"));
			
			Scene scene = new Scene(root,1000,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Snake Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("__________________");
		System.out.println("Refer to GUI:");
	}

	
	public static void main(String[] args) {
		// got from the demo's from D@L for launch(args)
		launch(args);
	}
}