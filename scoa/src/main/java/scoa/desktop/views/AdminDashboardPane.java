package scoa.desktop.views;

import scoa.desktop.Http;
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
import scoa.desktop.Router;

import java.io.IOException;
import java.util.Random;

public class AdminDashboardPane {
    private long userId;
    private Http req;

    @FXML private Pane userRegisterPane, disciplineRegisterPane, roomRegisterPane, courseRegisterPane, profLinkPane,
            classRegisterPane;
    @FXML private JFXButton userBtn, classBtn, roomBtn, courseBtn, profLinkBtn, disciplineBtn;
    @FXML private TextField userNameField, userCpfField, userEmailField, userDegreeField, userAreaField, disciplineNameField,
            disciplineCourseField, disciplineCodeField, disciplineHourField, disciplineCreditField, courseNameField, roomNameField,
            roomLocalField, roomCapacityField, profLinkIdField, profLinkDIdField;
    @FXML private JFXComboBox<String> userFunctionSelect;
    @FXML private PasswordField userPasswordField, userConfirmPasswordField;
    @FXML private Text userDegreeLabel, userAreaLabel;
    @FXML private JFXTextArea disciplineReqField, disciplineContentField;

    public void setUser(long userId) {
        this.userId = userId;
    }

    @FXML
    private void initialize() {
        String functions[] = {"Coordenador", "Professor", "Instrutor", "Aluno"};
        userFunctionSelect.setItems(FXCollections.observableArrayList(functions));
        userBtn.setStyle("-fx-background-color: #9e549b30");
        req = new Http("http://fesg3-api.herokuapp.com");
    }

    @FXML
    public void handleRegisterPane(ActionEvent event) {
        JFXButton selectedBtn = (JFXButton)event.getSource();

        userBtn.setStyle("-fx-background-color: #9e549b00");
        classBtn.setStyle("-fx-background-color: #9e549b00");
        roomBtn.setStyle("-fx-background-color: #9e549b00");
        courseBtn.setStyle("-fx-background-color: #9e549b00");

        if (selectedBtn == userBtn) {
            userRegisterPane.toFront();
        }
        if (selectedBtn == disciplineBtn) {
            disciplineRegisterPane.toFront();
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
        if (selectedBtn == profLinkBtn) {
            profLinkPane.toFront();
        }

        userBtn.setStyle("-fx-background-color: #9e549b00");
        disciplineBtn.setStyle("-fx-background-color: #9e549b00");
        classBtn.setStyle("-fx-background-color: #9e549b00");
        roomBtn.setStyle("-fx-background-color: #9e549b00");
        courseBtn.setStyle("-fx-background-color: #9e549b00");
        profLinkBtn.setStyle("-fx-background-color: #9e549b00");
        selectedBtn.setStyle("-fx-background-color: #9e549b30");
    }

    @FXML
    public void handleSelectChange(ActionEvent event) {
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

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @FXML
    public void handleUserRegister() {
        System.out.println("saving user...");
        String jsonInputString;
        switch (userFunctionSelect.getValue()) {
            case "Coordenador":
                jsonInputString = String.format(
                        "{\"nome\": \"%s\", \"cpf\": %s, \"email\": \"%s\", \"senha\": \"%s\"}",
                        userNameField.getText(), userCpfField.getText(), userEmailField.getText(), userPasswordField.getText()
                );
                req.post("/administrador", jsonInputString);
                break;
            case "Professor":
                jsonInputString = String.format(
                        "{\"nome\": \"%s\", \"cpf\": %s, \"email\": \"%s\", \"senha\": \"%s\", \"areaAtuacao\": \"%s\"," +
                                "\"formacao\": \"%s\"}",
                        userNameField.getText(), userCpfField.getText(), userEmailField.getText(),
                        userPasswordField.getText(), userAreaField.getText(), userDegreeField.getText()
                );
                req.post("/professor", jsonInputString);
                break;
            case "Aluno":
                jsonInputString = String.format(
                        "{\"nome\": \"%s\", \"cpf\": %s, \"email\": \"%s\", \"senha\": \"%s\", \"matricula\": %d}",
                        userNameField.getText(), userCpfField.getText(), userEmailField.getText(),
                        userPasswordField.getText(), getRandomNumberInRange(1, 255000000)
                );
                req.post("/aluno", jsonInputString);
                break;
            case "Instrutor":
                break;
            default:
                break;
        }

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
    public void handleDisciplineRegister() {
        System.out.println("saving discipline...");
        String jsonInputString = String.format(
                "{\"nome\": \"%s\", \"codigo\": \"%s\", \"creditos\": \"%s\", " +
                        "\"cargaHoraria\": \"%s\", \"ementa\": \"%s\"}",
                disciplineNameField.getText(), disciplineCodeField.getText(), disciplineCreditField.getText(),
                disciplineHourField.getText(), disciplineContentField.getText()
        );
        req.post("/discipline", jsonInputString);

        disciplineNameField.clear();
        disciplineCodeField.clear();
        disciplineCreditField.clear();
        disciplineHourField.clear();
        disciplineContentField.clear();
        disciplineReqField.clear();
        disciplineCourseField.clear();
    }

    @FXML
    public void handleRoomRegister() {
        System.out.println("saving Room...");
        String jsonInputString = String.format(
                "{\"local\": \"%s\", \"capacidade\": \"%s\"}",
                roomLocalField.getText(), roomCapacityField.getText()
        );
        req.post("/classroom", jsonInputString);

        roomLocalField.clear();
        roomNameField.clear();
        roomCapacityField.clear();
    }

    @FXML
    public void handleCourseRegister() {
        System.out.println("saving course...");
        String jsonInputString = String.format(
                "{\"nome\": \"%s\"}",
                courseNameField.getText()
        );
        req.post("/course", jsonInputString);

        courseNameField.clear();
    }

    @FXML
    public void handleProfLink() {
        System.out.println("saving link...");
        String jsonInputString = String.format(
                "{\"profId\": \"%s\", \"classId\": \"%s\"}",
                profLinkIdField.getText(), profLinkDIdField.getText()
        );
        req.post("", jsonInputString);

        profLinkIdField.clear();
        profLinkDIdField.clear();
    }

    @FXML
    public void handleClassRegister() {
        System.out.println("saving link...");
        String jsonInputString = String.format(
                "{\"profId\": \"%s\", \"classId\": \"%s\"}",
                profLinkIdField.getText(), profLinkDIdField.getText()
        );
        req.post("", jsonInputString);

        profLinkIdField.clear();
        profLinkDIdField.clear();
    }

    @FXML
    public void handleLogout() throws IOException {
        Router.toView("views/loginPane.fxml");
    }
}
