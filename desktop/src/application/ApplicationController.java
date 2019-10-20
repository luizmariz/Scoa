package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
    String API_ENDPOINT = "http://webhook.site";
    String userId = "WeDoNotHaveLoginYet";

    private void post (String route, String json) {
        try {
            URL url = new URL(API_ENDPOINT + route);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Pane userRegisterPane, classRegisterPane, roomRegisterPane, courseRegisterPane, loginPane;

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
        this.post("/cb306b0e-bfae-4a71-9e22-87517e87f12a", jsonInputString);

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
        this.post("/cb306b0e-bfae-4a71-9e22-87517e87f12a", jsonInputString);

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
        this.post("/cb306b0e-bfae-4a71-9e22-87517e87f12a", jsonInputString);

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
        this.post("/cb306b0e-bfae-4a71-9e22-87517e87f12a", jsonInputString);

        courseNameField.clear();
    }
}