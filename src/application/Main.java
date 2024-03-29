// Majority of this program's syntax is based off of the lecture videos 
// and demos on the CPSC 219 D2L shell (WINTER 2019).
package application;

import java.io.FileInputStream;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The class that calls upon Stage to allow
 * all classes to function together properly in unison. 
 * 
 * @author Written by Elizabeth, Danny, and Andres.
 *
 */
public class Main extends Application{
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
			//https://stackoverflow.com/questions/71328159/javafx-scene-background-color-how-to-change
			root.setStyle("-fx-background-color: rgb(211, 235, 204);");
			startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			startStage.setScene(startScene);
			startStage.setTitle("Snake Game");
			startStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Got from the demo's from D2L CPSC 219 for launch(args); as it was the code under main.
		launch(args);
	}
}