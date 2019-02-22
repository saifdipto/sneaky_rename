import java.util.*;

public class Othello{
    public static void main(String[] args){
        Board board = new Board(); // creates a new Board object
        int player = 0;// sets player to 0, this means there are no players at this time
        Player player_1 = new Player();
        Player player_2 = new Player();
        /**
         * Use math.random to decide which players turn it is if the number generated is
         * <= 0.5 then it is black's turn, else it is white's turn
         */
        double init_turn = Math.random();
        if (init_turn <= 0.5){
            player = 1;
            player_1.setColour("Black");
            player_2.setColour("White");
        }
        else{
            player = 2;
            player_2.setColour("Black");
            player_1.setColour("White");
        }
        //System.out.println("It is " + player + "'s turn");
        int playerOneScore = player_1.getScore();
        int playerTwoScore = player_2.getScore();


        /** gameOver checks whether board is full of pieces */
        while (board.gameOver() == false) {
            if (player == 1) {
                board.printBoard();
                System.out.println("It is " + player + "'s turn");
                Scanner coord = new Scanner(System.in);
                System.out.println("Enter a number between 1 to 8 for the x coordinate");
                int x = coord.nextInt();
                System.out.println("Enter a number between 1 to 8 for the y coordinate");
                int y = coord.nextInt();

                int[] flipped = board.move(x, y, player);

                if (flipped[0] != 0) {
                    board.updateBoard(x, y, player, flipped);
                    playerOneScore = board.turnScore(player);
                    player_1.setScore(playerOneScore);
                    System.out.println("Player 1 score is "+ playerOneScore);
                }
                player = 2;
            }

            else if (player == 2) {
                board.printBoard();
                System.out.println("It is " + player + "'s turn");
                Scanner coord = new Scanner(System.in);
                System.out.println("Enter a number between 1 to 8 for the x coordinate");
                int x = coord.nextInt();
                System.out.println("Enter a number between 1 to 8 for the y coordinate");
                int y = coord.nextInt();
                int[] flipped = board.move(x, y, player);

                if (flipped[0] != 0) {
                    board.updateBoard(x, y, player, flipped);
                    playerTwoScore = board.turnScore(player);
                    player_2.setScore(playerTwoScore);
                    System.out.println("Player 2 is score is " + playerTwoScore);
                }
                
                player = 1;
            }
        }

        if (board.gameOver() == true) {
        if (player_1.getScore() > player_2.getScore()){
            System.out.println("Player 1 wins!");
        }
        else if (player_1.getScore() < player_2.getScore()){
            System.out.println("Player 2 wins!");
        }
        else{
            System.out.println("This game was a tie");
        }
        }
    }
}