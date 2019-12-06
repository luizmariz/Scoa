package scoa.desktop.views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import scoa.desktop.Router;
import java.io.IOException;

public class AlunoDashboardPane {
    @FXML private Pane disciplinesPane;
    @FXML private JFXButton inscriptionBtn;
    @FXML private JFXListView classesList;

    @FXML
    private void initialize() {
        String[] sArr = {"MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219"};
        setClassesList(sArr);

        classesList.setOnMouseClicked(event -> handleSelectClass(event));
    }

    @FXML
    public void handleRegisterPane(ActionEvent event) {
        JFXButton selectedBtn = (JFXButton)event.getSource();

        inscriptionBtn.setStyle("-fx-background-color: #9e549b00");

        if (selectedBtn == inscriptionBtn) {
            disciplinesPane.toFront();
        }

        inscriptionBtn.setStyle("-fx-background-color: #9e549b00");
        selectedBtn.setStyle("-fx-background-color: #9e549b30");
    }

    private void setClassesList(String[] arr) {
        for (String s : arr) {
            classesList.getItems().add(new Label(s));
        }
    }

    private void handleSelectClass(MouseEvent event) {
        String selected = ((Label)classesList.getSelectionModel().getSelectedItem()).getText();
        System.out.println("clicked on " + selected);
    }

    @FXML
    public void handleLogout() throws IOException {
        Router.toView("views/loginPane.fxml");
    }
}
