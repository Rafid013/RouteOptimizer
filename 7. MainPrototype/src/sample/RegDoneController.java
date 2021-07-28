package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Created by rafid on 6/5/2017.
 */
public class RegDoneController {
    @FXML
    public void backToStart(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("StartUp.fxml"));
            Main.window.setScene(new Scene(parent, 480, 640));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
