package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



/**
 * Created by rafid on 7/5/2017.
 */
public class ChangePasswordController {


    public Label newPassError;
    public Label currPassError;
    public PasswordField currPassField;
    public PasswordField newPassField;
    public PasswordField reNewPassField;


    public void cancelPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Main.window.setScene(new Scene(parent));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void changePasswordPressed(ActionEvent event) {
        boolean isError = false;
        if(!currPassField.getText().equals(Main.user[0].getPassword())) {
            currPassError.setVisible(true);
            isError = true;
        }
        else currPassError.setVisible(false);
        if(!newPassField.getText().equals(reNewPassField.getText())) {
            newPassError.setVisible(true);
            isError = true;
        }
        else newPassError.setVisible(false);
        if(!isError) {
            Main.user[0].setPassword(newPassField.getText());
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
                Main.window.setScene(new Scene(parent));
                Main.window.show();
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
