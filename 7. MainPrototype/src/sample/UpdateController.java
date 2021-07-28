package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {



    @FXML
    private RadioButton high;

    @FXML
    private RadioButton low;

    @FXML
    private AnchorPane anchor2;

    @FXML
    private RadioButton medium;


    @FXML
    public Button undoButton;

    @FXML
    private Label label1;

    @FXML
    private Label label2;


    @FXML
    private Label label3;



    @FXML
    private AnchorPane firstAnchor;

    @FXML
    private Button homeButton;

    private  int flag;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flag =0;

        undoButton.setVisible(false);
        anchor2.setVisible(false);

        Image image =  new Image(getClass().getResourceAsStream("mapLoading2.png"));
        //ImagePattern imageView = new ImagePattern(image);
        //BackgroundImage backgroundImage = new BackgroundImage(image);
        BackgroundImage bgImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        firstAnchor.setBackground(new Background(bgImg));

        homeButton.setOnAction(event -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Main.window.setScene(new Scene(parent, 480, 640));
                Main.window.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        low.setOnAction(event -> {
            medium.setSelected(false);
            high.setSelected(false);
        });
        medium.setOnAction(event -> {
            low.setSelected(false);
            high.setSelected(false);
        });
        high.setOnAction(event -> {
            low.setSelected(false);
            medium.setSelected(false);
        });

    }

    @FXML
    void updateDirectionGiven(MouseEvent e)
    {
        Image image;
        if(flag==0)
        {
            image =  new Image(getClass().getResourceAsStream("setDirection1.png"));
            flag =1;
        }
        else
        {
            image =  new Image(getClass().getResourceAsStream("setDirection2.png"));
            flag =0;
        }
        //ImagePattern imageView = new ImagePattern(image);
        //BackgroundImage backgroundImage = new BackgroundImage(image);
        BackgroundImage bgImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        firstAnchor.setBackground(new Background(bgImg));
        anchor2.setVisible(true);
        low.setSelected(false);
        medium.setSelected(false);
        high.setSelected(false);
        label1.setVisible(false);
        label2.setVisible(true);
        undoButton.setVisible(true);

    }

    @FXML
    void undoUpdate(MouseEvent e)
    {
        Image image =  new Image(getClass().getResourceAsStream("mapLoading2.png"));
        //ImagePattern imageView = new ImagePattern(image);
        //BackgroundImage backgroundImage = new BackgroundImage(image);
        BackgroundImage bgImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        firstAnchor.setBackground(new Background(bgImg));

        anchor2.setVisible(false);
        undoButton.setVisible(false);

    }

    @FXML
    void doUpdate(ActionEvent e)
    {
        Image image =  new Image(getClass().getResourceAsStream("mapLoading2.png"));
        //ImagePattern imageView = new ImagePattern(image);
        //BackgroundImage backgroundImage = new BackgroundImage(image);
        BackgroundImage bgImg = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        firstAnchor.setBackground(new Background(bgImg));


        label2.setVisible(false);


        label3.setVisible(true);


        undoButton.setVisible(false);
        anchor2.setVisible(false);

   }


}
