package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StartUpController {
    @FXML
    public void registerPressed(ActionEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Main.window.setScene(new Scene(parent, 480, 640));
            Main.window.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void signInPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            Main.window.setScene(new Scene(parent, 480, 640));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
