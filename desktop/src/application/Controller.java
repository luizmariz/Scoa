package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
	@FXML
	public void handleMinimizeButtonAction(ActionEvent event) {
	    ((Stage)(((Button)event.getSource()).getScene().getWindow())).setIconified(true);
	}
}