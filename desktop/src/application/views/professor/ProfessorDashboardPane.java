package application.views.professor;

import application.Router;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ProfessorDashboardPane {

    @FXML private JFXListView classesList;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn dreCol, nomeCol, faltasCol, mediaCol;
    @FXML private Pane classPane;

    private void handleSelectClass (MouseEvent event) {
        System.out.println("clicked on " + classesList.getSelectionModel().getSelectedItem());

        ObservableList<Student> data = FXCollections.observableArrayList(
                new Student("1920349", "Ciclano", 0, (float) 0),
                new Student("1920349", "Ciclano", 0, (float) 0)
        );

        studentTable.setItems(data);
        classPane.toFront();
    }

    private void setClassesList (String[] arr) {
        for (String s : arr) {
            classesList.getItems().add(new Label(s));
        }
    }

    @FXML
    private void initialize () {
        String[] sArr = {"MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219"};
        setClassesList(sArr);

        classesList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleSelectClass(event);
            }
        });

        dreCol.setCellValueFactory(new PropertyValueFactory<Student, String>("dre"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<Student, String>("nome"));
        faltasCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("faltas"));
        mediaCol.setCellValueFactory(new PropertyValueFactory<Student, String>("media"));
    }

    @FXML
    public void handleLogout () throws IOException {
        Router.toView("views/login/loginPane.fxml");
    }
}
