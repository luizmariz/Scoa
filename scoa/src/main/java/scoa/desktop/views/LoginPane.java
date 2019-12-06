package scoa.desktop.views;

import scoa.desktop.Router;
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
        if (role.equals("00000000000")) {
            AdminDashboardPane paneController = Router.<AdminDashboardPane>toView("views/adminDashboardPane.fxml");
            paneController.setUser(userId);
        }
        if (role.equals("11111111111")) {
            Router.toView("views/professorDashboardPane.fxml");
        }if (role.equals("22222222222")) {
            Router.toView("views/alunoDashboardPane.fxml");
        }

    }
}
