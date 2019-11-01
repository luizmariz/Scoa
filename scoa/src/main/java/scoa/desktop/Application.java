package scoa.desktop;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class Application {

    @FXML private AnchorPane rootPane;

    @FXML
    private void initialize () throws IOException {
        Router.rootPane = rootPane;
        Router.toView("views/loginPane.fxml");
    }

}