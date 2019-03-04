import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;

import javafx.stage.Stage;


public class Graphics extends Application{
  @Override
  public void start(Stage stage) throws FileNotFoundException{
    Image feltTexture = new Image(new FileInputStream("feltboard.png"));
  //  Image woodEdge = new Image(new FileInputStream("woodplank.jpg)"));
    ImageView background = new ImageView();
    background.setImage(feltTexture);

    Group board = new Group();
    Scene testscene = new Scene(board);
    testscene.setFill(Color.BLACK);
    HBox backgroundbox = new HBox();
    backgroundbox.getChildren().add(background);
    board.getChildren().add(backgroundbox);

    stage.setTitle("Othello");
    stage.setWidth(1500);
    stage.setHeight(1000);
    stage.setScene(testscene);
    //stage.sizeToScene();
    stage.show();
  }
  public static void main(String args[]){
    launch(args);
  }
}
