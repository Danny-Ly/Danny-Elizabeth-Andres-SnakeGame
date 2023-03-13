package application;

import java.io.IOException;
import java.io.OutputStream;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 * Gets the printed text from the output console and shows it on a TextArea on the GUI. 
 *
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

