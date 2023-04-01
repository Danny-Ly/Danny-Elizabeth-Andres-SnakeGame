package application;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Controls for the FXML files and the scenes, and buttons for the GUI. 
 * 
 * @author  Written by Danny, assisted and co-written by Andres and Elizabeth.
 *
 */
public class Controller {
	// Initializing/declaring variables that will be used in the class
	private MazeGenerator mazeCreation;
	private Snake snake;
//	private TextArea displayMaze;
//	private PrintStream consoleOut;
	@FXML
	 private Label mediumErrorLabel;
	@FXML
	 private Label hardErrorLabel;
	
	
	private Label counterLabel;
	
	private GridPane grid = new GridPane();
	
	private boolean userInputToggle = true;
	

	/**
	 * This method when pressing the start button in the GUI
	 * will generate and show a difficulty selector scene, 
	 * with a print in there to show button was pressed in console.
	 * @param event an action (button) initiates this method.
	 * @throws IOException
	 */
	// Got this section of code (also syntax) to switch the scene from this video from BroCode.
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
	 * Get the value of a TextField and checks it. Then runs the userInteraction. If the Snake runs into a wall or itself,
	 * then it prints a game over, and allows for user to go back to the main screen. 
	 * @param Action TextField value.
	 * @param mainStage a stage for GUI.
	 * @param allRows VBox container.
	 * @param userInputSnake Button for the input of snake. 
	 */
	void getInputValue(String Action, Stage mainStage, VBox allRows) {

			String line = "something";
			int difficulty = 0;
			String enteredUserAction = "";
		
			enteredUserAction = Action;

			try {
				userInteraction(enteredUserAction,mainStage,allRows);
				
			} catch (RuntimeException ERROR) {
				String conditionOfGame = "GAME OVER";
				endGameCondition(allRows, mainStage, conditionOfGame);				
			}
		

	}
	
	public void gameFunctionality (ActionEvent event) {
		userInputToggle = true;
		int difficultylocal = 0;
//		Media media = new Media("sample-3s.mp3");
//		MediaPlayer mediaPlayer = new MediaPlayer(media);
//		mediaPlayer.play();
//
//		File file = new File ("sample-3s.wav");
//		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
//		Clip clip = AudioSystem.getClip();
//		clip.open(audioStream);
//		
//		clip.start();

		counterLabel = new Label("Points: 0");
		//https://jenkov.com/tutorials/javafx/label.html#:~:text=button%20is%20clicked.-,Set%20Label%20Font,use%20a%20different%20text%20style.
		counterLabel.setFont(new Font("courier new", 30));
		
		VBox allRows = new VBox();
		HBox someHBox = new HBox();
		//https://docs.oracle.com/javafx/2/layout/size_align.htm#:~:text=Centering%20the%20Buttons,-The%20buttons%20are&text=hbButtons.,nodes%20within%20the%20HBox%20pane.
		allRows.setAlignment(Pos. CENTER);
		someHBox.setAlignment(Pos. CENTER);
		
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	PrintStream old = System.out;
    	System.setOut(ps);
    	
		mazeCreation = new MazeGenerator(difficultylocal);
		snake = new Snake(mazeCreation);
		mazeCreation.boundary();
		
		
		//someHBox.getChildren().addAll(userInputSnakeLeft,userInputSnakeDown,userInputSnakeRight);
		allRows.getChildren().addAll(counterLabel,/*displayMaze,*/grid /*,runGame/*,userInputtedValue,userInputSnakeUp,someHBox*/);
		// I also used the code section from BroCode here:
		// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		Scene gameScene = new Scene(allRows,840,520);
		
		//allRows.setStyle("-fx-background-color: rgb(211, 235, 204);");
		Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		//runGame.setOnAction(inputAction -> runGame.setVisible(false));
		
		mainStage.setScene(gameScene);
		mainStage.show();
		//boolean gameContinue = true;
		
		transferStringToShape(baos,old);
	
		//based off of the code in this video:
		// https://www.youtube.com/watch?v=tq_0im9qc6E&ab_channel=BroCode
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent someEvent) {
				if (userInputToggle == true) {
				String userInput = someEvent.getCode().toString();
				if (userInput.equalsIgnoreCase("W")||userInput.equalsIgnoreCase("A")||
						userInput.equalsIgnoreCase("S")||userInput.equalsIgnoreCase("D")) {
					getInputValue(userInput,mainStage, allRows);
					}
				}
			}
		});		
	}
	
	/**
	 * This method when pressing the easy button in the GUI
	 * will generate and show a display scene, 
	 * with a print in there to show that button was pressed in console.
	 * @param event an action (button) initiates this method.
	 * @throws IOException
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 */
	@FXML
    public void easyButtonPressed(ActionEvent event) throws IOException{
		gameFunctionality (event);
	}
	
	public void endGameCondition(VBox allRows, Stage mainStage, String conditionOfGame) {
		Main main = new Main();
		Label someLabel = new Label(conditionOfGame);
		Button backButton= new Button ("Go Back");
		// this was chagned from false to true
		userInputToggle = false;
		
		Button continueButton = new Button ("Continue");
		
		allRows.getChildren().addAll(someLabel,backButton,continueButton);
		// when you win it promps the go back button.
		// when pressed go back to start method in main.
		backButton.setOnAction(userInputAction ->main.start(mainStage));
		continueButton.setOnAction(event -> gameFunctionality(event));
	
	}

	
	/**
	 * Sets the text in the difficulty display to "In development" 
	 * if medium button is pressed.
	 * @param event medium button is pressed
	 * @throws IOException
	 */
	 public void mediumButtonPressed(ActionEvent event) throws IOException {
		 mediumErrorLabel.setText("In development.");
	 }
	/**
	 * Sets the text in the difficulty display to "In development" if hard button is pressed.
	 * @param event hard button is pressed
	 * @throws IOException
	 */
	 public void hardButtonPressed(ActionEvent event) throws IOException {
		 hardErrorLabel.setText("In development.");
	 }
	
	public void transferStringToShape(ByteArrayOutputStream baos,PrintStream old) {
		char[][] someMaze;
		//Parisa helped me with this
        Image wallImage = new Image(getClass().getResource("/ImagesFolder/brickImage.png").toString());
    	Image imagePellet = new Image(getClass().getResource("/ImagesFolder/yellowPelletImage.png").toString());
       	Image bombImage = new Image(getClass().getResource("/ImagesFolder/gameBomb.png").toString());
    	Image ninjaStarImage = new Image(getClass().getResource("/ImagesFolder/gameNinjaStar.png").toString());
    	Image groundImage = new Image(getClass().getResource("/ImagesFolder/gameGround.png").toString());
    	Image snakeImage = new Image(getClass().getResource("/ImagesFolder/snakeTexture.png").toString());

//    	Image wallImage = new Image("brickImage.png");
//       	Image imagePellet = new Image("yellowPelletImage.png");
//        Image bombImage = new Image("gameBomb.png");
//       	Image ninjaStarImage = new Image("gameNinjaStar.png");
//       	Image groundImage = new Image("gameGround.png");
//       	Image snakeImage = new Image("snakeTexture.png");
		 
		//https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
		System.out.flush();
    	System.setOut(old);
    	String output = baos.toString();
         
    	// https://stackoverflow.com/questions/454908/split-java-string-by-new-line
        String[] mazeString = output.split("\\r?\n");
        
        someMaze = new char[mazeString.length][];
        for (int i = 0; i < mazeString.length; i++) {
            someMaze[i] = mazeString[i].toCharArray();
        }
        
        // clears the grid to avoid constant object build up in the maze.
        // https://stackoverflow.com/questions/27066484/remove-all-children-from-a-group-without-knowing-the-containing-nodes
        grid.getChildren().clear();
        
        // image ref: bomb: http://pixelartmaker.com/art/cf8800006625ade
        // coin: http://pixelartmaker.com/art/69c534c1f4fac20
        // brick: https://opengameart.org/content/pixel-art-brick-tiles
        // ninja: http://pixelartmaker.com/art/fb575e0da47165a
        // ground: http://pixelartmaker.com/art/454c9a9174136b1
        int rowMaze = 0;
        while (rowMaze < someMaze.length) {
        	int columnMaze = 0;
            while (columnMaze < someMaze[rowMaze].length) {
            	//https://www.tabnine.com/code/java/methods/javafx.scene.shape.Rectangle/setWidth
            	// First example used as a reference for height and width.
            	
            	ImageView someOtherView = new ImageView();
            	someOtherView.setFitHeight(40);
            	someOtherView.setFitWidth(40);
            	
            	ImageView someImageView = new ImageView();
            	someImageView.setFitHeight(40);
            	someImageView.setFitWidth(40);
//            	someImageView.fitHeightProperty().bind());
//            	someImageView.fitWidthProperty().bind(grid.heightProperty());
            	
                if (someMaze[rowMaze][columnMaze] == '#') {
                	//someRect.setFill(Color.GREY);    
                	someImageView.setImage(wallImage);
                	//https://www.tutorialspoint.com/javafx/layout_gridpane.htm
                	// for grid.add
                	grid.add(someImageView, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == '.') {
                	//someRect.setFill(Color.BEIGE);
                	
                	someImageView.setImage(imagePellet);
                	someOtherView.setImage(groundImage);
                    grid.add(someOtherView, columnMaze, rowMaze);
                    grid.add(someImageView, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == '@') {
//                	someCirc.setFill(Color.BLACK);
                	
                	someImageView.setImage(bombImage);
                	someOtherView.setImage(groundImage);
                    grid.add(someOtherView, columnMaze, rowMaze);
                    grid.add(someImageView, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == '*') {
//                	someCirc.setFill(Color.BLUE);
//                	someRect.setFill(Color.BEIGE);
                	
                    someImageView.setImage(ninjaStarImage);
                    someOtherView.setImage(groundImage);
                    grid.add(someOtherView, columnMaze, rowMaze);
                	grid.add(someImageView, columnMaze, rowMaze);
                }

                if (someMaze[rowMaze][columnMaze] == ' ') {
//                	someRect.setFill(Color.BEIGE);
                	someImageView.setImage(groundImage);
                    grid.add(someImageView, columnMaze, rowMaze);
                }  
                //grid.add(someRect, columnMaze, rowMaze);
                if (someMaze[rowMaze][columnMaze] == 'o') {
//                	someRect.setFill(Color.GREEN);
//                	someRect.setWidth(41);
//                	someRect.setHeight(41);
//                    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html
//                    someRect.setStroke(Color.BLACK);
//                    grid.add(someRect, columnMaze, rowMaze);
                    someImageView.setImage(snakeImage);
                    grid.add(someImageView, columnMaze, rowMaze);
                    
                }
                	 columnMaze++;
                }
                rowMaze++;
            }
        }
	 
	public void movementOfSnake (int row_movement, int column_movement) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	// IMPORTANT: Save the old System.out!
    	PrintStream old = System.out;
    	// Tell Java to use your special stream
    	System.setOut(ps);
    	
		snake.moveSnake(mazeCreation, row_movement, column_movement);
		mazeCreation.boundary();
		
		int mainCounter = snake.returnCounter();
		//https://www.javatpoint.com/java-int-to-string
		counterLabel.setText("Points: " + String.valueOf(mainCounter));
		
		
		
		transferStringToShape( baos, old);
	}
	 
	/**
	 * Gets the values from the user and then moves the snake according to the inputed value. Also checks if victory,
	 * if equal to false, then prints "WINNER" and prompts the user to go back to the start method
	 * in main. 
	 * @param enteredUserAction This is the TextField value converted to string.
	 * @param mainStage Stage of GUI.
	 * @param allRows VBox container.
	 * @param userInputSnake Button for inputting a value. 
	 */
	public void userInteraction(String enteredUserAction,Stage mainStage, VBox allRows) {
		int difficulty = 0;
		if (difficulty == 0) {
				// there is the input of a(right), d(left), w(up), and s(down)
				// that calls the snake class to allow for it to function.
				if (enteredUserAction.equalsIgnoreCase("d")) {
					int row_movement = 0;
					int column_movement = 1;
					movementOfSnake (row_movement, column_movement);
					
				}
				
				if (enteredUserAction.equalsIgnoreCase("a")) {
					int row_movement = 0;
					int column_movement = -1;
					movementOfSnake (row_movement, column_movement);
				}

				if (enteredUserAction.equalsIgnoreCase("w")) {
					int row_movement = -1;
					int column_movement = 0;
					 //REFERENCE
					movementOfSnake (row_movement, column_movement);
			        } 
					
				}
				if (enteredUserAction.equalsIgnoreCase("s")) {
					int row_movement = 1;
					int column_movement = 0;
					movementOfSnake (row_movement, column_movement);
				}
				
				
				if (mazeCreation.ifVictory() == false) {
					String conditionOfGame = "WINNER!";
					endGameCondition(allRows, mainStage, conditionOfGame);
			}
		}
	}

