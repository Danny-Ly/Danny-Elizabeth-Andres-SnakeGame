module test {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
