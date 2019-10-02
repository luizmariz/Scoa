package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
	private Pane userRegisterPane, classRegisterPane, roomRegisterPane, courseRegisterPane;
	
	@FXML
	private JFXButton userBtn, classBtn, roomBtn, courseBtn;
	
	@FXML
	public void handleCloseButtonAction (ActionEvent event) {
	    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
	@FXML
	public void handleMinimizeButtonAction (ActionEvent event) {
	    ((Stage)(((Button)event.getSource()).getScene().getWindow())).setIconified(true);
	}
	
	@FXML
	public void handleRegisterPane (ActionEvent event) {
		JFXButton selectedBtn = (JFXButton)event.getSource();
		
		if (selectedBtn == userBtn) userRegisterPane.toFront();
		if (selectedBtn == classBtn) classRegisterPane.toFront();
		if (selectedBtn == roomBtn) roomRegisterPane.toFront();
		if (selectedBtn == courseBtn) courseRegisterPane.toFront();
	}
}