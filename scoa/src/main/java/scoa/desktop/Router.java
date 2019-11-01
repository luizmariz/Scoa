package scoa.desktop;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;


public class Router {
    static AnchorPane rootPane;

    /**
     *
     * @param fxml Path to fxml file
     * @param <T> Specifies the expected returned controller type
     * @return Returns a fxml controller
     * @throws IOException
     */
     static public <T> T toView (String fxml) throws IOException {
        System.out.println(fxml);

        FXMLLoader loader = new FXMLLoader();
        Pane menuBtn = FXMLLoader.load(Router.class.getResource("components/menuBtn.fxml"));
        rootPane.getChildren().setAll(
                (Pane)loader.load(Router.class.getResource(fxml).openStream()),
                menuBtn
        );

        return loader.<T>getController();
    }
}
