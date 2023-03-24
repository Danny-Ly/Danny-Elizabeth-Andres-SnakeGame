package application;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	private TextArea displayMaze;
	private PrintStream consoleOut;
	@FXML
	 private Label mediumErrorLabel;
	@FXML
	 private Label hardErrorLabel;
	
	private GridPane grid = new GridPane();
	
	private boolean userInputToggle = true;
	
	Shape[][] shapes = new Shape[10][20];

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
				System.out.println("GAME OVER");			
				Main main = new Main();				
				Label gameoverLabel = new Label("GAME OVER");
				Button gameoverButton= new Button ("Go Back");
				// disables the user input when it is gameover. 
				// this actually sets the private boolean of userInput that was 
				// initialized above to false. 
				userInputToggle = false;
				
				allRows.getChildren().addAll(gameoverLabel,gameoverButton);
				// when you lose it promps the go back button.
				gameoverButton.setOnAction(userInputAction -> main.start(mainStage));
				
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

		VBox allRows = new VBox();
		HBox someHBox = new HBox();
		Button runGame = new Button ("Run Game!");  
		TextArea displayMaze = new TextArea("SNAKE GAME \n");
		
		// set the font so that everything is same size.
		// this snippet of code was referenced by:
		// https://docs.oracle.com/javafx/2/text/jfxpub-text.htm on specifically example 8.
		displayMaze.setFont(Font.font("Monospaced", FontWeight.BOLD, 16));
		
		// not allow the user to edit the display TextArea in the GUI. 
		// this code is referenced by:
		//https://stackoverflow.com/questions/20205145/javafx-how-to-show-read-only-text#:~:text=You%20can%20use%20following%20statement,setEditable(false)%3B
		//Answered by Ben on Dec 6, 2020, and edited by mahendrabishnoi2 on Mar 17, 2021. 
		displayMaze.setEditable(false);
		
		// change the dimensions of the TextArea in GUI
		//https://stackoverflow.com/questions/37458555/how-to-set-height-and-width-of-javafx-textarea
		// answered on Oct 12, 2017 by Michael Cenzoprano.
		displayMaze.setPrefHeight(240);
		displayMaze.setPrefWidth(250);
		
		//https://docs.oracle.com/javafx/2/layout/size_align.htm#:~:text=Centering%20the%20Buttons,-The%20buttons%20are&text=hbButtons.,nodes%20within%20the%20HBox%20pane.
		allRows.setAlignment(Pos. CENTER);
		someHBox.setAlignment(Pos. CENTER);
		
		// https://stackoverflow.com/questions/33494052/javafx-redirect-console-output-to-textarea-that-is-created-in-scenebuilder
		// alot of this code is from the reply of James_D on Nov 3, 2015 on how to redirect console output to a TextArea. 
		PrintStream printStream = new PrintStream(new DisplayOfGUIFromConsole(displayMaze), true);
        System.setOut(printStream);
        System.setErr(printStream);
        
        
        //https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	PrintStream old = System.out;
    	System.setOut(ps);
    	
    	
		mazeCreation = new MazeGenerator(difficultylocal);
		snake = new Snake(mazeCreation);
		mazeCreation.boundary();
		
		
		//someHBox.getChildren().addAll(userInputSnakeLeft,userInputSnakeDown,userInputSnakeRight);
		allRows.getChildren().addAll(displayMaze,grid, runGame/*,userInputtedValue,userInputSnakeUp,someHBox*/);
		// I also used the code section from BroCode here:
		// https://www.youtube.com/watch?v=hcM-R-YOKkQ&ab_channel=BroCode
		Scene gameScene = new Scene(allRows,400,500);
		//gameScene.requestFocus();
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
	 * Allows for the printing output of the console and it shows this to the TextArea in the GUI.
	 * (This code was from James_D on stack overflow [refer to the link below])
	 * https://stackoverflow.com/questions/33494052/javafx-redirect-console-output-to-textarea-that-is-created-in-scenebuilder
	 */
	//https://stackoverflow.com/questions/33494052/javafx-redirect-console-output-to-textarea-that-is-created-in-scenebuilder
	// this code is from the reply of James_D on Nov 3, 2015 on how to redirect console output to a TextArea. 
	public class DisplayOfGUIFromConsole extends OutputStream {
	        private TextArea textForGUI;
	        
	        DisplayOfGUIFromConsole(TextArea textForGUI) {
	            this.textForGUI = textForGUI;
	        }
	        
	        public void appendText(String valueOf) {
	            Platform.runLater(() ->textForGUI.appendText(valueOf));
	        }
	        
	        public void write(int b) throws IOException {
	            // Append the output to the TextArea
	       
	        	appendText(String.valueOf((char) b));
	        }
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
        
        //CAN REMOVE THIS CODE WHEN DONE WITH THE TEXATAREA
        for (int i = 0; i < someMaze.length; i++) {
            for (int j = 0; j < someMaze[i].length; j++) {
                System.out.print(someMaze[i][j]);
            }
            System.out.println();
        }
        // maybe change this to while loops?
        for (int rowMaze = 0; rowMaze < someMaze.length; rowMaze++) {
            for (int columnMaze = 0; columnMaze < someMaze[rowMaze].length; columnMaze++) {
            	//https://www.tabnine.com/code/java/methods/javafx.scene.shape.Rectangle/setWidth
            	// First example used as a reference for height and width.
            	Rectangle someRect = new Rectangle();
            	someRect.setWidth(21);
            	someRect.setHeight(21);
            	
            	Circle someCirc = new Circle();
            	someCirc.setRadius(10);
                if (someMaze[rowMaze][columnMaze] == '#') {
                	someRect.setFill(Color.GREY);
                	
                	//https://www.tutorialspoint.com/javafx/layout_gridpane.htm
                	// for grid.add
                	grid.add(someRect, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == ' ') {
                	someRect.setFill(Color.WHITE);
                    grid.add(someRect, columnMaze, rowMaze);
                }  
                //grid.add(someRect, columnMaze, rowMaze);
                if (someMaze[rowMaze][columnMaze] == 'o') {
                	someCirc.setFill(Color.GREEN);
                    //https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Shape.html
                    someCirc.setStroke(Color.BLACK);
                    grid.add(someCirc, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == '.') {
                	someCirc.setFill(Color.YELLOW);
                	someCirc.setStroke(Color.ORANGE);

                   grid.add(someCirc, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == '@') {
                	someCirc.setFill(Color.BLACK);
                    grid.add(someCirc, columnMaze, rowMaze);
                }
                if (someMaze[rowMaze][columnMaze] == '*') {
                	someCirc.setFill(Color.BLUE);
                	grid.add(someCirc, columnMaze, rowMaze);
                }
               
                
            }
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
					System.out.println("WINNER");	
					Main main = new Main();
					
					Label winLabel = new Label("YOU WIN");
					Button winButton= new Button ("Go Back");
					userInputToggle = false;
					
					allRows.getChildren().addAll(winLabel,winButton);
					// when you win it promps the go back button.
					// when pressed go back to start method in main.
					winButton.setOnAction(userInputAction ->main.start(mainStage));
			}
		}
	}

