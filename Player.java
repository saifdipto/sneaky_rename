public class Player {

  // Instance 
  String colour; // black/white
  int score;

  // Constructors
  public Player() {
    colour = "black";
    score = 0;
  }

  public Player(String colour, int score) { 
    this.colour = colour;
    this.score = score;
  }

  // Getters
  public String getColour() {
    return colour;
  }

  public int getScore() {
    return score;
  }          

  // Setters
  public void setColour(String colour) {
    this.colour = colour;
  }

  public void setScore(int score) {
    this.score = score;
  }

}