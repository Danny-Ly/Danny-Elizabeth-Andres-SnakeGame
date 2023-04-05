package application;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	@FXML
	private Label mediumErrorLabel;
	@FXML
	private Label hardErrorLabel;
	private MazeGenerator mazeCreation;
	private Snake snake;
	private Label pointCounterLabel;
	private GridPane grid = new GridPane();
	private boolean userInputToggle = true;
	private Label creditsLabel = new Label();
	private int pelletCount = 5;
	private int levelCounter = 0;

	/**
	 * This method when pressing the start button in the GUI
	 * will call the gameFunctionality method to generate the game.
	 * @param event an action (button) initiates this method.
	 * @throws IOException
	 */
	// Got this section of code (also syntax) to switch the scene from this video from BroCode.
	// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
	// code allows for switching of scene (JavaFX switch scenes, Jan 11 2021).
	@FXML 
    public void startGameInput(ActionEvent event) throws IOException {
		gameFunctionality (event);
	}
	
	/**
	 * Get the value of a keyboard value, then runs the userInteraction. If the Snake runs into a wall or itself,
	 * then it prints a game over, and goes to endGameCondition.
	 * @param userInput String value for w,a,s,d.
	 * @param mainStage a stage for GUI.
	 * @param allRows VBox container. 
	 */
	void getInputValue(String userInput, Stage mainStage, VBox allRows) {
			String enteredUserAction = "";
			enteredUserAction = userInput;
			try {
				userInteraction(enteredUserAction,mainStage,allRows);
			
			} catch (RuntimeException ERROR) {
				String conditionOfGame = "GAME OVER";
				endGameCondition(allRows, mainStage, conditionOfGame);				
			}
	}
	
	/**
	 * Sets up the scene of the game with credits, the level, the point count, also 
	 * takes the output of the console and also generates a maze. This method also
	 * takes keyboard inputs from the user. 
	 * @param event some action is passed through.
	 */
	public void gameFunctionality (ActionEvent event) {		
		// initialization
		userInputToggle = true;
		int difficultylocal = 0;
		VBox allRows = new VBox();
		HBox someCreditsHBox = new HBox();
		HBox someLevelHBox = new HBox();
		Button creditsButton = new Button("Credits");
		Label levelLabel = new Label();	
		
		pointCounterLabel = new Label("Points: 0");
		//https://jenkov.com/tutorials/javafx/label.html#:~:text=button%20is%20clicked.-,Set%20Label%20Font,use%20a%20different%20text%20style.
		//For setting font and size of a label
		// By Jakob Jenkov on 2020-12-08. 
		pointCounterLabel.setFont(new Font("courier new", 30));
		
		levelCounter++;
		//https://www.javatpoint.com/java-int-to-string
		//setting an Int to string.
		// on JavaTpoint (Java Convert int to String).
		levelLabel.setText("Level: " + String.valueOf(levelCounter));
		levelLabel.setFont(new Font("courier new", 30));
		
		creditsButton.setFont(new Font("courier new", 15));
		//resets the credit label everytime there is a gameover or wins.
		creditsLabel.setText("");	
		creditsLabel.setFont(new Font("courier new", 15));

		//https://docs.oracle.com/javafx/2/layout/size_align.htm#:~:text=Centering%20the%20Buttons,-The%20buttons%20are&text=hbButtons.,nodes%20within%20the%20HBox%20pane.
		// setting the alignments of Boxes in the GUI. 
		// Oracle (2 Tips for Sizing and Aligning Nodes)
		allRows.setAlignment(Pos. CENTER);
		someLevelHBox.setAlignment(Pos.TOP_LEFT);
		someCreditsHBox.setAlignment(Pos. TOP_LEFT);		
		
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
		// used to read and take the output of the console
		// By Ernest Friedman-Hill (on Jan 3, 2012), and edited by rekire (on Jan 4, 2019) 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	PrintStream old = System.out;
    	System.setOut(ps);
    	
    	// generates the maze by calling MazeGenerator class.
		mazeCreation = new MazeGenerator(difficultylocal, pelletCount);
		snake = new Snake(mazeCreation);
		mazeCreation.boundary();
		
		// credits reset everytime the player gets on a new level.
		if (creditsLabel.getText()==""){
			creditsButton.setOnAction(creditsPressed->creditsLabel.setText("  Danny, Andres, Elizabeth in CPSC 219"));
		}
		else{
			creditsButton.setOnAction(creditsPressed->creditsLabel.setText(""));
		}
		
		someLevelHBox.getChildren().addAll(levelLabel);
		someCreditsHBox.getChildren().addAll(creditsButton,creditsLabel);
		allRows.getChildren().addAll(someLevelHBox,someCreditsHBox,pointCounterLabel,grid );
		
		// I also used the code section from BroCode here:
		// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		// creation of the scene for the game (JavaFX switch scenes, Jan 11 2021).
		Scene gameScene = new Scene(allRows,840,560);
		Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		mainStage.setScene(gameScene);
		mainStage.show();
		
		// creation of a grid with images. 
		transferStringToShape(baos,old);
	
		//based off of the code in this video by BroCode:
		//https://www.youtube.com/watch?v=tq_0im9qc6E&ab_channel=BroCode
		//Gets the keyboard input from the player and sends it to the 
		//getInputValue method (JavaFX KeyEvent, Mar 15 2021).
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
	 * If the condition for beating a level is met, creates continue button and that button
	 * on action regenerates a new map. 
	 * @param allRows VBox for containing.
	 */
	public void winGameContinue(VBox allRows) {
		// if you beat the round, then pops up the continue button to continue the game
		Button continueButton = new Button ("Continue");
		//Everytime the user clears a level, the pellet increases by 1.
		pelletCount++;
		
		allRows.getChildren().add(continueButton);
		continueButton.setOnAction(event -> gameFunctionality(event));
	}
	
	/**
	 * Creation of a go back button if the player either loses or wins, will disable 
	 * keyboard interaction, if the player wins then goes to winGameContinue. 
	 * @param allRows
	 * @param mainStage
	 * @param conditionOfGame
	 */
	public void endGameCondition(VBox allRows, Stage mainStage, String conditionOfGame) {
		//initialization
		Main main = new Main();
		Label someLabel = new Label(conditionOfGame);
		Button backButton= new Button ("Go Back");
		// this was changed from true to false to turn off w,a,s,d controls
		userInputToggle = false;	

		// when you win or its gameover, it prompts the go back button.
		// when pressed go back to start method in main.
		backButton.setOnAction(userInputAction ->main.start(mainStage));
		allRows.getChildren().addAll(someLabel,backButton);
		
		if (conditionOfGame == "WINNER!") {
			winGameContinue(allRows);
		}	
	}
	
	/**
	 * 
	 * @param baos
	 * @param old
	 */
	public void transferStringToShape(ByteArrayOutputStream baos,PrintStream old) {
		char[][] someMaze;
		
		//Parisa helped me with this		
		//initialize the images
		
        // brick wall image reference: https://opengameart.org/content/pixel-art-brick-tiles
        Image wallImage = new Image(getClass().getResource("/ImagesFolder/brickImage.png").toString());
        // yellow pellet image reference: http://pixelartmaker.com/art/69c534c1f4fac20
    	Image imagePellet = new Image(getClass().getResource("/ImagesFolder/yellowPelletImage.png").toString());
		//bomb image reference: http://pixelartmaker.com/art/cf8800006625ade
       	Image bombImage = new Image(getClass().getResource("/ImagesFolder/gameBomb.png").toString());
        // ninjastar image reference: http://pixelartmaker.com/art/fb575e0da47165a
    	Image ninjaStarImage = new Image(getClass().getResource("/ImagesFolder/gameNinjaStar.png").toString());
        // ground image reference: http://pixelartmaker.com/art/454c9a9174136b1
    	Image groundImage = new Image(getClass().getResource("/ImagesFolder/gameGround.png").toString());
    	// I drew this image on Procreate on the Ipad.
    	Image snakeImage = new Image(getClass().getResource("/ImagesFolder/snakeTexture.png").toString());
		 
		//https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
    	// turn the output of the console to a string variable.
		System.out.flush();
    	System.setOut(old);
    	String output = baos.toString();
         
    	// https://stackoverflow.com/questions/454908/split-java-string-by-new-line
        String[] mazeString = output.split("\\r?\n");
        
        // put the string output into a char array.
        int mazeStringSize = mazeString.length; 
        someMaze = new char[mazeStringSize][];
        int rowCharMaze = 0;
        // increase the row while after turning the elements into a char element of a char array
        while (rowCharMaze < mazeStringSize) {
        	//https://www.geeksforgeeks.org/java-string-tochararray-example/
        	// conversion of string into sequence of char.
        	someMaze[rowCharMaze] = mazeString[rowCharMaze].toCharArray();
        	rowCharMaze++;
        }
       
        // https://stackoverflow.com/questions/27066484/remove-all-children-from-a-group-without-knowing-the-containing-nodes
        // clears the grid to avoid constant object build up in the maze.
        grid.getChildren().clear();
        
        int rowGridMaze = 0;
        while (rowGridMaze < someMaze.length) {
        	int columnGridMaze = 0;
            while (columnGridMaze < someMaze[rowGridMaze].length) {
            	//Initialize ImageView's, someOtherView is for background. 
            	
            	//https://www.tabnine.com/code/java/methods/javafx.scene.shape.Rectangle/setWidth
            	// First example used as a reference for height and width.
            	ImageView someBackgroundView = new ImageView();
            	someBackgroundView.setFitHeight(40);
            	someBackgroundView.setFitWidth(40);
            	
            	ImageView someImageView = new ImageView();
            	someImageView.setFitHeight(40);
            	someImageView.setFitWidth(40);
            	
                if (someMaze[rowGridMaze][columnGridMaze] == '#') {  
                	someImageView.setImage(wallImage);
                	//https://www.tutorialspoint.com/javafx/layout_gridpane.htm
                	grid.add(someImageView, columnGridMaze, rowGridMaze);
                }
                if (someMaze[rowGridMaze][columnGridMaze] == '.') {
                	someImageView.setImage(imagePellet);
                	someBackgroundView.setImage(groundImage);
                    grid.add(someBackgroundView, columnGridMaze, rowGridMaze);
                    grid.add(someImageView, columnGridMaze, rowGridMaze);
                }
                if (someMaze[rowGridMaze][columnGridMaze] == '@') {
                	someImageView.setImage(bombImage);
                	someBackgroundView.setImage(groundImage);
                    grid.add(someBackgroundView, columnGridMaze, rowGridMaze);
                    grid.add(someImageView, columnGridMaze, rowGridMaze);
                }
                if (someMaze[rowGridMaze][columnGridMaze] == '*') {                	
                    someImageView.setImage(ninjaStarImage);
                    someBackgroundView.setImage(groundImage);
                    grid.add(someBackgroundView, columnGridMaze, rowGridMaze);
                	grid.add(someImageView, columnGridMaze, rowGridMaze);
                }
                if (someMaze[rowGridMaze][columnGridMaze] == ' ') {
                	someImageView.setImage(groundImage);
                    grid.add(someImageView, columnGridMaze, rowGridMaze);
                }  
                if (someMaze[rowGridMaze][columnGridMaze] == 'o') {
                    someImageView.setImage(snakeImage);
                    grid.add(someImageView, columnGridMaze, rowGridMaze);  
                }
                	 columnGridMaze++;
                }
                rowGridMaze++;
            }
        }
	
	/**
	 * 
	 * @param row_movement
	 * @param column_movement
	 */
	public void movementOfSnake (int row_movement, int column_movement) {
		int mainCounter;
		
		//https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
		//Takes in output from the console.
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	PrintStream old = System.out;
    	System.setOut(ps);
    	
		snake.moveSnake(mazeCreation, row_movement, column_movement);
		mazeCreation.boundary();
		
		// transfer the point value to controller from Snake class
		mainCounter = snake.returnPointCounter();
		pointCounterLabel.setText("Points: " + String.valueOf(mainCounter));
		
		transferStringToShape(baos, old);
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
					movementOfSnake (row_movement, column_movement);
			        } 
				}
				if (enteredUserAction.equalsIgnoreCase("s")) {
					int row_movement = 1;
					int column_movement = 0;
					movementOfSnake (row_movement, column_movement);
				}
				// checks if all pellets are consumed and initiates end game if so (victory).
				if (mazeCreation.ifVictory() == false) {
					String conditionOfGame = "WINNER!";
					endGameCondition(allRows, mainStage, conditionOfGame);
			}
		}
	}

