package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
	private Pane userRegisterPane, classRegisterPane, roomRegisterPane, courseRegisterPane;
	
	@FXML
	private JFXButton userBtn, classBtn, roomBtn, courseBtn;
	
	@FXML
	private TextField nameField, cpfField, emailField, passwordField, confirmPasswordField, degreeField, areaField;
	
	@FXML
	private Text degreeLabel, areaLabel;
	
	@FXML
	private JFXComboBox<String> functionSelect;
	
	@FXML
	private void initialize() {
		String functions[] = {"Coordenador", "Professor", "Instrutor", "Aluno"};
		functionSelect.setItems(FXCollections.observableArrayList(functions));
		userBtn.setStyle("-fx-background-color: #9e549b30");
	}
	
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
		
		userBtn.setStyle("-fx-background-color: #9e549b00");
		classBtn.setStyle("-fx-background-color: #9e549b00");
		roomBtn.setStyle("-fx-background-color: #9e549b00");
		courseBtn.setStyle("-fx-background-color: #9e549b00");

		if (selectedBtn == userBtn) {
			userRegisterPane.toFront();
		}
		if (selectedBtn == classBtn) {
			classRegisterPane.toFront();
		}
		if (selectedBtn == roomBtn) {
			roomRegisterPane.toFront();
		}
		if (selectedBtn == courseBtn) {
			courseRegisterPane.toFront();
		}
		
		selectedBtn.setStyle("-fx-background-color: #9e549b30");
	}
	
	@FXML
	public void handleSelectChange (ActionEvent event) {
		if (functionSelect.getValue() == "Professor") {
			degreeLabel.setVisible(true);
			areaLabel.setVisible(true);
			degreeField.setVisible(true);
			areaField.setVisible(true);
		} else {
			degreeLabel.setVisible(false);
			areaLabel.setVisible(false);
			degreeField.setVisible(false);
			areaField.setVisible(false);
		}
	}
}