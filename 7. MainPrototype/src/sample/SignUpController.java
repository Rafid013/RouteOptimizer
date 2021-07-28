package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rafid on 6/5/2017.
 */
public class SignUpController implements Initializable{

    @FXML
    public TextField name;
    @FXML
    public TextField email;
    @FXML
    public TextField mobile;
    @FXML
    public TextField password;
    @FXML
    public TextField rePassword;

    @FXML
    public Label errorMsg;

    @FXML
    public Label nameError;

    @FXML
    public Label emailError;

    @FXML
    public Label passwordError;

    @FXML
    public Label rePasswordError;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void cancel(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("StartUp.fxml"));
            Main.window.setScene(new Scene(parent, 480, 640));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void signUpPressed(ActionEvent event) {
        String nameText = name.getText();
        String emailText = email.getText();
        String mobileText = mobile.getText();
        String passwordText = password.getText();
        String rePasswordText = rePassword.getText();



        boolean showError = false;

        if(nameText.length() == 0) {
            showError = true;
            nameError.setVisible(true);
        }
        else nameError.setVisible(false);
        if(emailText.length() == 0) {
            showError = true;
            emailError.setVisible(true);
        }
        else emailError.setVisible(false);
        if(passwordText.length() == 0) {
            showError = true;
            passwordError.setVisible(true);
        }
        else passwordError.setVisible(false);
        if(!passwordText.equals(rePasswordText)) {
            showError = true;
            rePasswordError.setVisible(true);
        }
        else rePasswordError.setVisible(false);
        if(showError) {
            errorMsg.setVisible(true);
        }
        else {
            errorMsg.setVisible(false);
            Main.user[Main.i] = new User(nameText, emailText, mobileText, passwordText);
            Main.i++;
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("RegDone.fxml"));
                Main.window.setScene(new Scene(parent, 480, 640));
                Main.window.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
