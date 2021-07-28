package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rafid on 7/5/2017.
 */
public class HomePageController{




    public void profilePressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatePressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Update.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void directionPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("SetStart.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void logOutPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("StartUp.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void exitPressed(ActionEvent event) {
        Platform.exit();
    }
}
