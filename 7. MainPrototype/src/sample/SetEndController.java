package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rafid on 7/5/2017.
 */
public class SetEndController implements Initializable {
    @FXML
    private AnchorPane anchor2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image =  new Image(getClass().getResourceAsStream("Map.png"));
        //ImagePattern imageView = new ImagePattern(image);
        //BackgroundImage backgroundImage = new BackgroundImage(image);
        BackgroundImage bgImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        anchor2.setBackground(new Background(bgImg));
        anchor2.setOnMouseClicked(event -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("ShowMap.fxml"));
                Main.window.setScene(new Scene(parent, 480, 640));
                Main.window.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    @FXML
    public void backPressed(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("SetStart.fxml"));
            Main.window.setScene(new Scene(parent, 480, 640));
            Main.window.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
