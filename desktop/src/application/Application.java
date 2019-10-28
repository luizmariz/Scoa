package application;

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

    private String userId = "WeDoNotHaveLoginYet";
    // private Http req;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Pane loginPane;

    @FXML
    private TextField loginCPField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    public void handleMinimizeButtonAction (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).setIconified(true);
    }

    @FXML
    public void handleCloseButtonAction (ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    public void handleLogin () {

    }
}