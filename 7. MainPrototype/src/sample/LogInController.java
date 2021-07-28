package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Created by rafid on 6/5/2017.
 */
public class LogInController {

    @FXML
    TextField name;
    @FXML
    TextField pass;

    @FXML
    Label errorMsg;


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
    public void logInPressed(ActionEvent event) {
        if(name.getText().equals("a") && pass.getText().equals("a")){
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Main.window.setScene(new Scene(parent));
                Main.window.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(Main.user[0] != null) {
            User u = Main.user[0];
            if(!u.getName().equals(name.getText())){
                errorMsg.setVisible(true);
            }
            else if(!u.getPassword().equals(pass.getText())){
                errorMsg.setVisible(true);
            }
            else {
                errorMsg.setVisible(false);
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    Main.window.setScene(new Scene(parent));
                    Main.window.show();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        else
        {
            errorMsg.setVisible(true);
        }
    }
}
