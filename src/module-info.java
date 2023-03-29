module test {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.media;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
