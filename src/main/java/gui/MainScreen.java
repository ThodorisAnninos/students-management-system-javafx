package gui;

import api.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Database.load();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 522,590);
        primaryStage.setTitle("Διαχείριση Φοιτητών");

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(522);
        primaryStage.setMinHeight(500);
        primaryStage.show();

        primaryStage.setOnCloseRequest(e->{
            Database.save();
        });
    }


}
