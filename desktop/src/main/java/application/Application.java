package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class Application {

    @FXML private AnchorPane rootPane;

    @FXML
    private void initialize () throws IOException {
        Router.rootPane = rootPane;
        Router.toView("views/login/loginPane.fxml");
    }

}