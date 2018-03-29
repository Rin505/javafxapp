package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class Main extends Application {

    @Override
        public void start(Stage primaryStage) {
            try {
                BorderPane root = new BorderPane();
                Scene scene = new Scene(root,400,400);
                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }

        // My code
        primaryStage.setTitle("Первая визуальная программа");
        Button btn = new Button();
        btn.setText("Сказать условную фразу");
        btn.setOnAction(event -> primaryStage.setTitle("Hello, world!"));
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
