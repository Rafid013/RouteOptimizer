package sample;

import javafx.event.ActionEvent;
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
public class ProfileController implements Initializable {

    public TextField nameField;
    public TextField emailField;
    public TextField mobileField;
    public TextField coinField;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Main.user[0] != null) {
            nameField.setText(Main.user[0].getName());
            emailField.setText(Main.user[0].getEmail());
            mobileField.setText(Main.user[0].getMobile());
            coinField.setText("5000");
        }
        else {
            nameField.setText("Pranto");
            emailField.setText("toufik@yahoo.com");
            mobileField.setText("01812-121212");
            coinField.setText("5000");
        }
    }

    public void backPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void changePasswordPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
