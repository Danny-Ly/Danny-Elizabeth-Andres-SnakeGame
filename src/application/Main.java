package application;
	
import java.util.Scanner;

public class Main {
	public void start() {
		System.out.println("SnakeMaze");
		System.out.println("Press Enter To Start");
		Scanner inp = new Scanner(System.in); // scans user input
		String line = inp.nextLine(); // creates a string using the last user input
		System.out.println("Your Input is:" + line);
		difficulty = 0;
		
		
		while (line != "") {
			line = inp.nextLine();
			if (line != ""){
				System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to existing string and displays result
			}
		}
		System.out.println("Select difficulty:\n easy \n medium \n hard");
		// Exit the while loop if !(line == "easy" || line == "medium" || line == "hard")
		line.compareTo("easy");
		while (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium") ||line.equalsIgnoreCase("hard"))){
			line = inp.nextLine();
			line = line.toLowerCase().trim();
			if (!(line.equalsIgnoreCase("easy") || line.equalsIgnoreCase("medium") ||line.equalsIgnoreCase("hard"))){
				System.out.println("Please enter a vaild user input. You typed: " + line); // adds user input to existing string and displays result
			}
		}
		
		if (line.equalsIgnoreCase("easy")) {
			difficulty = 0;
		}
		if (line.equalsIgnoreCase("medium")) {
			difficulty = 1;
		}
		if (line.equalsIgnoreCase("hard")){
			difficulty = 2;
		}
		
	}
			

	private int difficulty;
	
	public static void main(String[] args) {
		
		Main application = new Main();
		application.start();	
		
	}	
	
}

