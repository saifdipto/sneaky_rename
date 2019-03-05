import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

import javafx.scene.paint.Color;

import javafx.stage.Stage;

public class Graphics extends Application{
  public static Circle createWhitePiece(int midx,int midy){
    Circle whitePiece = new Circle();
    Circle border = new Circle();
    whitePiece.setFill(Color.WHITE);
    whitePiece.setCenterX(int midx);
    whitePiece.setCenterY(int midy);
    whitePiece.setRadius(45);
    border.setCenterX(int midX);
    border.setCenterY(int midY);
    border.setRadius(45);
    border.setStrokeWidth(3);
    Group piece = new Group(whitePiece,border);
    return whitePiece;
  }
  @Override
  public void start(Stage stage) throws FileNotFoundException{
    Image feltTexture = new Image(new FileInputStream("feltboard.png"));
    Image feltTexture2 = new Image(new FileInputStream("greyfelt.jpg"));
    Image woodEdge = new Image(new FileInputStream("woodwalls.jpg"));
    ImageView woodBack = new ImageView();
    ImageView feltBack = new ImageView();
    ImageView scoreFelt = new ImageView();
    woodBack.setImage(woodEdge);
    feltBack.setImage(feltTexture);
    feltBack.setX(25);
    feltBack.setY(25);
    feltBack.setFitWidth(800);
    feltBack.setFitHeight(800);

    scoreFelt.setImage(feltTexture2);
    scoreFelt.setX(875);
    scoreFelt.setY(25);
    scoreFelt.setFitWidth(300);
    scoreFelt.setFitHeight(800);

    Path boardBorder = new Path();
    MoveTo bbstart = new MoveTo(25,25);
    LineTo bb1 = new LineTo(25,826);
    LineTo bb2 = new LineTo(826,826);
    LineTo bb3 = new LineTo(826,25);
    LineTo bb4 = new LineTo(25,25);
    boardBorder.setStrokeWidth(5);
    boardBorder.getElements().add(bbstart);
    boardBorder.getElements().addAll(bb1,bb2,bb3,bb4);
    Path scoreBorder = new Path();
    MoveTo sbstart = new MoveTo(875,25);
    LineTo sb1 = new LineTo(875,825);
    LineTo sb2 = new LineTo(1175,825);
    LineTo sb3 = new LineTo(1175,25);
    LineTo sb4 = new LineTo(875,25);
    scoreBorder.setStrokeWidth(5);
    scoreBorder.getElements().add(sbstart);
    scoreBorder.getElements().addAll(sb1,sb2,sb3,sb4);

    Line v1 = new Line(125,25,125,825);
    Line v2 = new Line(225,25,225,825);
    Line v3 = new Line(325,25,325,825);
    Line v4 = new Line(425,25,425,825);
    Line v5 = new Line(525,25,525,825);
    Line v6 = new Line(625,25,625,825);
    Line v7 = new Line(725,25,725,825);
    Line h1 = new Line(25,125,825,125);
    Line h2 = new Line(25,225,825,225);
    Line h3 = new Line(25,325,825,325);
    Line h4 = new Line(25,425,825,425);
    Line h5 = new Line(25,525,825,525);
    Line h6 = new Line(25,625,825,625);
    Line h7 = new Line(25,725,825,726);





    Group board = new Group(woodBack,feltBack,boardBorder,scoreFelt,scoreBorder,v1,v2,v3,v4,v5,v6,v7,h1,h2,h3,h4,h5,h6,h7);
    Scene testscene = new Scene(board,1200,850);
    testscene.setFill(Color.BLACK);
    //testscene.setResizable(true);

    stage.setTitle("Othello");
    stage.setWidth(1200);
    stage.setHeight(850);
    stage.setScene(testscene);
    stage.sizeToScene();
    stage.show();
  }
  public static void main(String args[]){
    launch(args);
  }
}
