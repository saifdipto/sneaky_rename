public class Othello {

  /**
   * This method will determine when the game is over.
   * The game is over when the board is filled with pieces.
   *
   * @return true when there are no valid moves left, false otherwise.
   */
  private boolean gameOver() {

    boolean full = false;
    int countTotal = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (grid[i][j]== blackpiece || grid[i][j]== whitepiece) {
          countTotal++;
        }
      }
    }
    if (countTot==64) {
      full = true;
    }
    return full;
  }


 public void play() {
   // First move is made by blackpiece
   char move = blackpiece; // or, int move = 0;
   while (!gameOver()) // while not board full
   {
     int x = 0; // row
     int y = 0; // column
     boolean validmove = false;

     // wait for player in turn to make a valid move
     while (!validmove)
     {
       // check valid moves
       // make move
     }

     // taketurn(z, x, y);
     // player switched after the turn
     if (movemade == blackpiece) {
       movemade = whitepiece;
     } else {
       movemade = blackpiece;
     }
   }
   // endgameconditions();
   // check and stop refreshing board to end game
 }

 public static void main(String[] args) {
   Othello game = new Othello(); // constructor Othello
   game.play(); // runs on while loop
 }

}
