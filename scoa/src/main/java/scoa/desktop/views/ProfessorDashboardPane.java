package scoa.desktop.views;

import com.jfoenix.controls.JFXButton;
import javafx.scene.text.Text;
import scoa.desktop.Router;
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
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class ProfessorDashboardPane {

    @FXML private JFXListView disciplineList, classList;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn dreCol, nomeCol, faltasCol, mediaCol;
    @FXML private Pane classPane, profClassPane, profDisciplinePane;
    @FXML private JFXButton backBtn;
    @FXML private Text classCode, disciplineCode;

    Deque<Pane> stack = new ArrayDeque<Pane>();

    @FXML
    private void handleBack() {
        Pane pane = stack.pop();
        pane.toFront();

        if (stack.isEmpty()) {
            backBtn.setVisible(false);
        }
    }

    private void setDisciplineList(String[] arr) {
        for (String s : arr) {
            disciplineList.getItems().add(new Label(s));
        }
    }

    private void setClassList(String[] arr) {
        for (String s : arr) {
            classList.getItems().add(new Label(s));
        }
    }

    private void handleSelectDiscipline(MouseEvent event) {
        String selected = ((Label)disciplineList.getSelectionModel().getSelectedItem()).getText();
        System.out.println("clicked on " + selected);
        disciplineCode.setText(selected);
        profClassPane.toFront();
        stack.push(profDisciplinePane);
        backBtn.setVisible(true);
        setClassList(new String[]{"Turma 202", "Turma 301"});
    }

    private void handleSelectClass(MouseEvent event) {
        String selected = ((Label)classList.getSelectionModel().getSelectedItem()).getText();
        System.out.println("clicked on " + selected);
        classCode.setText(selected);

        ObservableList<Student> data = FXCollections.observableArrayList(
                new Student("1920349", "Ciclano", 0, (float) 0),
                new Student("1920349", "Ciclano", 0, (float) 0)
        );

        studentTable.setItems(data);
        classPane.toFront();
        stack.push(profClassPane);
    }

    @FXML
    private void initialize() {
        String[] sArr = {"MAB489", "FES7219","MAB489", "FES7219","MAB489", "FES7219"};
        setDisciplineList(sArr);

        disciplineList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleSelectDiscipline(event);
            }
        });

        classList.setOnMouseClicked(new EventHandler<MouseEvent>() {
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
    public void handleLogout() throws IOException {
        Router.toView("views/loginPane.fxml");
    }
}
