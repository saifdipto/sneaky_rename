import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.MouseInfo;

import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

public class Graphics extends Application{

  public static void main(String args[]){
    launch(args);
  }

  private Group board = new Group();

  private Parent startup() throws FileNotFoundException{
    initBackGround();
    initBoardGrid();
    initScoreBoard();
    initPlayerInfo();
    return board;
  }

  public void initBackGround() throws FileNotFoundException{
    Image feltTexture = new Image(new FileInputStream("feltboard.png"));
    Image woodEdge = new Image(new FileInputStream("woodwalls.jpg"));
    ImageView woodBack = new ImageView();
    ImageView feltBack = new ImageView();
    woodBack.setImage(woodEdge);
    woodBack.setFitWidth(1200);
    woodBack.setFitHeight(850);
    feltBack.setImage(feltTexture);
    feltBack.setX(25);
    feltBack.setY(25);
    feltBack.setFitWidth(800);
    feltBack.setFitHeight(800);
    Path boardBorder = new Path();
    MoveTo bbstart = new MoveTo(25,25);
    LineTo bb1 = new LineTo(25,826);
    LineTo bb2 = new LineTo(826,826);
    LineTo bb3 = new LineTo(826,25);
    LineTo bb4 = new LineTo(25,25);
    boardBorder.setStrokeWidth(5);
    boardBorder.getElements().add(bbstart);
    boardBorder.getElements().addAll(bb1,bb2,bb3,bb4);

    board.getChildren().addAll(woodBack,feltBack,boardBorder);
  }

  public void initBoardGrid() throws FileNotFoundException{
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

    board.getChildren().addAll(v1,v2,v3,v4,v5,v6,v7,h1,h2,h3,h4,h5,h6,h7);
  }

  public void initScoreBoard() throws FileNotFoundException{
    Image feltTexture2 = new Image(new FileInputStream("greyfelt.jpg"));
    ImageView scoreFelt = new ImageView();
    scoreFelt.setImage(feltTexture2);
    scoreFelt.setX(875);
    scoreFelt.setY(25);
    scoreFelt.setFitWidth(300);
    scoreFelt.setFitHeight(800);
    Path scoreBorder = new Path();
    MoveTo sbstart = new MoveTo(875,25);
    LineTo sb1 = new LineTo(875,825);
    LineTo sb2 = new LineTo(1175,825);
    LineTo sb3 = new LineTo(1175,25);
    LineTo sb4 = new LineTo(875,25);
    scoreBorder.setStrokeWidth(5);
    scoreBorder.getElements().add(sbstart);
    scoreBorder.getElements().addAll(sb1,sb2,sb3,sb4);
    Rectangle exitarea = new Rectangle();
    exitarea.setX(900);
    exitarea.setY(700);
    exitarea.setWidth(250);
    exitarea.setHeight(100);
    exitarea.setFill(Color.SNOW);
    Path exitBorder = new Path();
    MoveTo ebstart = new MoveTo(900,700);
    LineTo eb1 = new LineTo(1150,700);
    LineTo eb2 = new LineTo(1150,800);
    LineTo eb3 = new LineTo(900,800);
    LineTo eb4 = new LineTo(900,700);
    exitBorder.setStrokeWidth(5);
    exitBorder.getElements().add(ebstart);
    exitBorder.getElements().addAll(eb1,eb2,eb3,eb4);
    Text exitText = new Text(940,760,"Click here to exit.");
    exitText.setFont(Font.font("impact",FontWeight.NORMAL,FontPosture.REGULAR,25));

    board.getChildren().addAll(scoreFelt,scoreBorder,exitarea,exitBorder,exitText);
  }

  public void initPlayerInfo() throws FileNotFoundException{
    Text player1Text = new Text(925,100,"Player1");
    Text player2Text = new Text(925,300,"Player2");
    player1Text.setFont(Font.font("impact",FontWeight.NORMAL,FontPosture.REGULAR,25));
    player2Text.setFont(Font.font("impact",FontWeight.NORMAL,FontPosture.REGULAR,25));
    Rectangle playerarea = new Rectangle();
    playerarea.setX(900);
    playerarea.setY(50);
    playerarea.setWidth(250);
    playerarea.setHeight(425);
    playerarea.setFill(Color.SNOW);
    Path playerBorder = new Path();
    MoveTo pbstart = new MoveTo(900,50);
    LineTo pb1 = new LineTo(1150,50);
    LineTo pb2 = new LineTo(1150,475);
    LineTo pb3 = new LineTo(900,475);
    LineTo pb4 = new LineTo(900,50);
    playerBorder.setStrokeWidth(5);
    playerBorder.getElements().add(pbstart);
    playerBorder.getElements().addAll(pb1,pb2,pb3,pb4);

    board.getChildren().addAll(playerarea,playerBorder,player1Text,player2Text);
  }

  public void createWhitePiece(double midx,double midy){
    Circle whitePiece = new Circle();
    Circle border = new Circle();
    whitePiece.setFill(Color.IVORY);
    whitePiece.setCenterX(midx);
    whitePiece.setCenterY(midy);
    whitePiece.setRadius(45);
    border.setCenterX(midx);
    border.setCenterY(midy);
    border.setRadius(45);
    border.setStrokeWidth(3);

    board.getChildren().addAll(whitePiece,border);
  }

  @Override
  public void start(Stage stage) throws FileNotFoundException{
    Scene scene = new Scene(startup(),1200,850);
    scene.setFill(Color.BLACK);
    scene.setOnMouseClicked(mouseHandler);

    stage.setResizable(true);
    stage.setTitle("Othello");
    stage.setScene(scene);
    stage.sizeToScene();
    stage.show();

  }
  private EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>(){
    @Override
    public void handle(MouseEvent mouseEvent){
      double mouseX = mouseEvent.getX();
      double mouseY = mouseEvent.getY();
      if ((mouseX > 900) && (mouseX < 1150) && (mouseY > 700) && (mouseY < 800)){
        System.exit(0);
        //System.out.println("exitarea");
      }
      if ((mouseX > 25) && (mouseX < 825) && (mouseY > 25) && (mouseY < 825)){
        createWhitePiece(mouseX,mouseY);
      }
    }
  };
}
