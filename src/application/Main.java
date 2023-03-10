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
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * The class that calls upon MazeGenerator, Rewards and Snake class, to allow
 * all classes to function together properly in unison. This class also handles 
 * the GUI screens.
 * 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main extends Application{
	// Initializing/declaring variables that will be used in the class
	private Scanner inp; 
	private MazeGenerator mazeCreation;
	private Snake snake;
	

	/**
	 * This method when pressing the start button in the GUI
	 * will generate and show a difficulty selector scene, 
	 * with a print in there to show button was pressed in console.
	 * @param event an action (button) initiates this method.
	 * @throws IOException
	 */
	//Got this section of code (also syntax) to switch the scene from this video from BroCode.
	// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
	// code allows for switching of scene.
	@FXML 
    public void startGameInput(ActionEvent event) throws IOException {
		System.out.println("Start button pressed\n");
		
		Parent root = FXMLLoader.load(getClass().getResource("DifficultySelector.fxml"));
		Stage difficultyStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene difficultyScene = new Scene(root);
		difficultyStage.setScene(difficultyScene);
		difficultyStage.show();
	}
	/**
	 * This method when pressing the easy button in the GUI
	 * will generate and show a display scene, 
	 * with a print in there to show that button was pressed in console.
	 * @param event an action (button) initiates this method.
	 * @throws IOException
	 */
	@FXML
    public void easyButtonPressed(ActionEvent event) throws IOException {
		int difficultylocal = 0;
		boolean loopOfGame = true;
		String line = "easy";
		
		System.out.println("Easy button pressed\n");
		
		// I also used the code section from BroCode here:
		//// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		Parent root = FXMLLoader.load(getClass().getResource("GameplayDisplay.fxml"));
		Stage displayStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene displayScene = new Scene(root);
		displayStage.setScene(displayScene);
		displayStage.show();
		
		//looping of game in console after the GUI to allow for it to repeat.
		while (loopOfGame == true) {
			if (line.equalsIgnoreCase("easy")) {
				difficultylocal = 0;
				}
				
				System.out.println("_____________");
				System.out.println("SNAKE MAZE \n");
				//determines in console difficulty selection after restart.
				while (!(line.equalsIgnoreCase("easy"))) {
					System.out.println("Select difficulty:\n easy \n medium \n hard");
					line = inp.nextLine();
					line = line.toLowerCase().trim();
					if (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium")
							|| line.equalsIgnoreCase("hard"))) {
						System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to existing string and displays result
					}
		
					if (line.equalsIgnoreCase("medium") || line.equalsIgnoreCase("hard")) {
						difficultylocal = 1;
						System.out.println("This Version is still in progress");
					}
				}
				
			// if selection is easy then allow for the generation of maze with 
			// difficultylocal at 0.
			if (line.equalsIgnoreCase("easy")) {
				difficultylocal = 0;
				// generation of the MazeGenerator and printing of maze
				mazeCreation = new MazeGenerator(difficultylocal);
				snake = new Snake(mazeCreation);
				mazeCreation.boundary();
			}
			// run through userInteraction method, if RuntimeException then print
			// GAMEOVER in console.
			try {
				userInteraction();
				System.out.println("WINNER");
			} catch (RuntimeException ERROR) {
				System.out.println("GAME OVER");
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
				// call mazeCreation for maze to generate
				if (userInput.equalsIgnoreCase("d")) {
					int row_movement = 0;
					int column_movement = 1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}
				
				else if (userInput.equalsIgnoreCase("a")) {
					int row_movement = 0;
					int column_movement = -1;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}

				else if (userInput.equalsIgnoreCase("w")) {
					int row_movement = -1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}

				else if (userInput.equalsIgnoreCase("s")) {
					int row_movement = 1;
					int column_movement = 0;
					snake.moveSnake(mazeCreation, row_movement, column_movement);
					mazeCreation.boundary();
				}
				// if the input is invalid, re-prompts user to input correct. 
				else {
					System.out.println("Please input (w,a,s,d)");
					
				}
				// continues game if pellets are still in game
				if (mazeCreation.ifVictory() == false) {
					return;
				}
			
			}
		}
	}

	/**
	 * This handles user input of when the program is first run, this will initially
	 * make a SnakeGameTitle scene for the GUI. 
	 */
	public void start(Stage startStage) {
		
		// from the creating GUI using JavaFX demos on D2L (CPSC 219 WINTER 2023)
		// this generates the initial GUI scene
		try {
			// from demo 2 of CPSC 216 D2L SHELL (adding a FXML document to the project)
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(new FileInputStream("src/application/SnakeGameTitle.fxml"));
			Scene startScene = new Scene(root,400,400);
			startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			startStage.setScene(startScene);
			startStage.setTitle("Snake Game");
			startStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("__________________");
		System.out.println("Refer to GUI.");
	}

	
	public static void main(String[] args) {
		// got from the demo's from D2L CPSC 219 for launch(args); as it was the code under main.
		launch(args);
	}
}