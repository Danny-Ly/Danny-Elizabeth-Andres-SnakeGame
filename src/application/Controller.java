package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {
	// Initializing/declaring variables that will be used in the class
//	Stage controllerStage;
	
	private MazeGenerator mazeCreation;
	private Snake snake;

	// asked chatGPT on how to return this label (method with return label)
	public Label getLabel(String someText) {
//		String sometext = "text here";
		Label displayMaze = new Label("Text Label");
		displayMaze.setText(someText);
		return displayMaze;

	}

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
		
	void getInputValue(TextField userInputtedValue, Stage mainStage) {
			String line = "something";
			int difficulty = 0;
			String enteredUserAction = "";
		
			enteredUserAction = userInputtedValue.getText();
			System.out.println(enteredUserAction);

			if (line.equalsIgnoreCase("something")) {
				difficulty = 0;
			}
			// generation of the MazeGenerator and printing of maze
			
			
//			mazeCreation = new MazeGenerator(difficulty);
//			snake = new Snake(mazeCreation);
//			mazeCreation.boundary();
			
			try {
				userInteraction(enteredUserAction,mainStage);
				System.out.println("YOU WIN");
			} catch (RuntimeException ERROR) {
				System.out.println("GAME OVER");
				Main main = new Main();
				main.start(mainStage);
//				difficultyStage.show();
				
			}
			line = "";
			
		
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
		
		System.out.println("Easy button pressed\n");
		
		// I also used the code section from BroCode here:
		//// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		mazeCreation = new MazeGenerator(difficultylocal);
		snake = new Snake(mazeCreation);
		mazeCreation.boundary();
		
		VBox allRows = new VBox();
		TextField userInputtedValue = new TextField();
		Button userInputSnake = new Button ("Input");
		
		
		Wall wallItemfornow = new Wall();
		String someText = wallItemfornow.getString();
		
		Label displayMaze = getLabel(someText);
//		Label displayMaze = new Label("Text Label");
//		displayMaze.setText("some text");
		allRows.getChildren().addAll(displayMaze,userInputtedValue,userInputSnake);

		
		Scene gameScene = new Scene(allRows);
		Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainStage.setScene(gameScene);
		mainStage.show();
		
		userInputSnake.setOnAction(userInputAction -> getInputValue(userInputtedValue,mainStage));
		
	}
	
	/**
	 * This handles when the user enters WASD, will handle these four cases of
	 * different inputs, and will call Snake class to do their certain action, that
	 * is needed.
	 */
	public void userInteraction(String enteredUserAction,Stage mainStage) {
		int difficulty = 0;
		String userInput = "";
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
					System.out.println("WINNER");
				
					//return;
					//difficultyStage.show();
					Main main = new Main();
					main.start(mainStage);
			}
		}
	}
}
