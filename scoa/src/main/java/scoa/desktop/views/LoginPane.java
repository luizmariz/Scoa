package scoa.desktop.views;

import scoa.desktop.Router;
import scoa.desktop.views.RegisterPane;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoginPane {
    private long userId = 1234125234;
    // private Http req;

    @FXML private JFXButton loginBtn;
    @FXML private Pane loginPane;
    @FXML private TextField loginCpfField;
    @FXML private PasswordField loginPasswordField;

    @FXML
    public void handleLogin () throws IOException {
        String role = loginCpfField.getText();
        if (role.equals("admin")) {
            RegisterPane paneController = Router.<RegisterPane>toView("views/registerPane.fxml");
            paneController.setUser(userId);
        }
        if (role.equals("professor")) {
            Router.toView("views/professorDashboardPane.fxml");
        }
    }
}
