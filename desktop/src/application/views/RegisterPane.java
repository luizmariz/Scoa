package application.components;

import application.Http;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterPane {
    private String userId = "WeDoNotHaveLoginYet";
    private Http req;

    @FXML
    private Pane userRegisterPane, classRegisterPane, roomRegisterPane, courseRegisterPane, loginPane, professorDashboard;

    @FXML
    private JFXButton userBtn, classBtn, roomBtn, courseBtn, loginBtn, registerUserBtn, registerClassBtn,
            registerRoomBtn, registerCourseBtn, signOutBtn;

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
    private void initialize () {
        String functions[] = {"Coordenador", "Professor", "Instrutor", "Aluno"};
        userFunctionSelect.setItems(FXCollections.observableArrayList(functions));
        userBtn.setStyle("-fx-background-color: #9e549b30");

        req = new Http("http://webhook.site");
//        Text text = new Text();
//        text.setText("sdfasdfasdfasd");
//        ObservableList<Text> items = FXCollections.observableArrayList(text, text);
//        classes.setItems(items);
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
        String jsonInputString = String.format(
                "{\"nome\": \"%s\", \"cpf\": \"%s\", \"email\": \"%s\", \"senha\": \"%s\", \"tipoUser\": \"%s\"}",
                userNameField.getText(), userCpfField.getText(), userEmailField.getText(), userPasswordField.getText(),
                userFunctionSelect.getValue()
        );
        req.post("/9ecf4a54-6e1b-41de-b0b5-76a40f42415d", jsonInputString);

        userFunctionSelect.setValue(null);
        userNameField.clear();
        userAreaField.clear();
        userCpfField.clear();
        userEmailField.clear();
        userPasswordField.clear();
        userConfirmPasswordField.clear();
        userDegreeField.clear();
    }

    @FXML
    public void handleClassRegister () {
        System.out.println("saving class...");
        String jsonInputString = String.format(
                "{\"adminId\": \"%s\", \"nome\": \"%s\", \"codigo\": \"%s\", \"creditos\": \"%s\", " +
                        "\"cargaHoraria\": \"%s\", \"ementa\": \"%s\"}",
                userId, classNameField.getText(), classCodeField.getText(), classCreditField.getText(),
                classHourField.getText(), classContentField.getText()
        );
        req.post("/9ecf4a54-6e1b-41de-b0b5-76a40f42415d", jsonInputString);

        classNameField.clear();
        classCodeField.clear();
        classCreditField.clear();
        classHourField.clear();
        classContentField.clear();
        classReqField.clear();
        classCourseField.clear();
    }

    @FXML
    public void handleRoomRegister () {
        System.out.println("saving Room...");
        String jsonInputString = String.format(
                "{\"adminId\": \"%s\", \"local\": \"%s\", \"capacidade\": \"%s\"}",
                userId, roomLocalField.getText(), roomCapacityField.getText()
        );
        req.post("/9ecf4a54-6e1b-41de-b0b5-76a40f42415d", jsonInputString);

        roomLocalField.clear();
        roomNameField.clear();
        roomCapacityField.clear();
    }

    @FXML
    public void handleCourseRegister () {
        System.out.println("saving course...");
        String jsonInputString = String.format(
                "{\"adminId\": \"%s\", \"nome\": \"%s\"}",
                userId, courseNameField.getText()
        );
        req.post("/9ecf4a54-6e1b-41de-b0b5-76a40f42415d", jsonInputString);

        courseNameField.clear();
    }
}
