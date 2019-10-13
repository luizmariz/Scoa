package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicationController {
	
	@FXML
	private Pane userRegisterPane, classRegisterPane, roomRegisterPane, courseRegisterPane, loginPane;
	
	@FXML
	private JFXButton userBtn, classBtn, roomBtn, courseBtn, loginBtn, registerUserBtn, registerClassBtn, registerRoomBtn,
										registerCourseBtn, signOutBtn;
	
	@FXML
	private TextField userNameField, userCpfField, userEmailField, userDegreeField, userAreaField, classNameField,
										classCourseField, classCodeField, classHourField, classCreditField, courseNameField, roomNameField,
										roomLocalField, roomCapacityField, loginCPField;

	@FXML
	private JFXComboBox<String> userFunctionSelect;

	@FXML
	private PasswordField loginPasswordField, userPasswordField, userConfirmPasswordField;

	@FXML
	private Text userDegreeLabel, userAreaLabel;

	@FXML
	private JFXTextArea classReqField, classContentField;

	@FXML
	private void initialize() {
		String functions[] = {"Coordenador", "Professor", "Instrutor", "Aluno"};
		userFunctionSelect.setItems(FXCollections.observableArrayList(functions));
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
		if (selectedBtn == signOutBtn) {
			loginPane.toFront();
		}
		
		selectedBtn.setStyle("-fx-background-color: #9e549b30");
	}
	
	@FXML
	public void handleSelectChange (ActionEvent event) {
		if (userFunctionSelect.getValue() == "Professor") {
			userDegreeLabel.setVisible(true);
			userAreaLabel.setVisible(true);
			userDegreeField.setVisible(true);
			userAreaField.setVisible(true);
		} else {
			userDegreeLabel.setVisible(false);
			userAreaLabel.setVisible(false);
			userDegreeField.setVisible(false);
			userAreaField.setVisible(false);
		}
	}

	@FXML
	public void handleLogin () {
		loginPane.toBack();
	}

	@FXML
	public void handleUserRegister () {
			System.out.println("saving user...");
	}

	@FXML
	public void handleClassRegister () {
			System.out.println("saving class...");
	}

	@FXML
	public void handleRoomRegister () {
			System.out.println("saving Room...");
	}

	@FXML
	public void handleCourseRegister () {
			System.out.println("saving course...");
	}
}