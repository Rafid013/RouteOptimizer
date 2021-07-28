package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static User user[];
    public static int i;
    public static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("StartUp.fxml"));
        window.setTitle("Traffico");
        window.setScene(new Scene(root));
        window.show();
    }


    public static void main(String[] args) {
        i = 0;
        user = new User[20];
        launch(args);
    }
}
