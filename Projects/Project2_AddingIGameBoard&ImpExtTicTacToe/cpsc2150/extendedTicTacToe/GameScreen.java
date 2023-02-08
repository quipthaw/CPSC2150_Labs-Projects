package cpsc2150.extendedTicTacToe;
import java.util.Scanner;

/** GameScreen is the main display of progression of the game
 *  and the program the user will input into
 */
public class GameScreen {

    /**Main function, initializes and displays game board. Prompts players to each enter a
     * column position until one of them has won with 5 of the same tokens in a row. After a win,
     * the program displays the winner then lets the users choose whether or not they wish to play
     * again or quit the program.
     */

    private static char gameState = 'p';
    private static char p = 'X';
    private static char gameType = 'z';
    private static char [] players = new char [12];
    private static int numPlayers = -12;
    private static int numRows = -12;
    private static int numColumns = -12;
    private static int numToWin = 20;
    private static int moves = 0;
    public static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args)
    {
        moves = 0;
        numPlayers = 2;
        players[0] = 'X';
        players[1] = 'O';
        numRows = 5;
        numColumns = 8;
        numToWin = 6;



        GameBoard game = new GameBoard(numRows,numColumns,numToWin);


        while(gameState == 'p')
        {

            moves++;

            //Print game at start

            System.out.println(game.toString());

            //System.out.println(game.toString());
            System.out.println("Player " + p + ", what column do you want to place your marker in?");


            int tmpCol = 16;
            while (tmpCol < 0 || tmpCol >= numColumns)
            {
                if (tmpCol != 16) { System.out.println("Please enter valid input between 0 and " + numColumns); }
                tmpCol = scanner.nextInt();
            }



            System.out.println("Player " + p + ", what row do you want to place your marker in?");
            int tmpRow = 16;
            while (tmpRow < 0 || tmpRow >= numRows)
            {
                if (tmpRow != 16) { System.out.println("Please enter valid input between 0 and " + numRows); }
                tmpRow = scanner.nextInt();
            }






            while (game.checkSpace(tmpRow, tmpCol) == false)
            {
                System.out.println("Position is full please enter another Col & Row");

                System.out.println("Column:");
                tmpCol = scanner.nextInt();

                System.out.println("Row:");
                tmpRow = scanner.nextInt();

            }


            BoardPosition pew = new BoardPosition(tmpRow,tmpCol);
            game.placeMarker(pew,p);


            // checks for a win
            if (game.checkForWinner(pew,p))
            {
                System.out.println(game.toString());
                System.out.println("Player " + p + " has won!\nEnter 1 to play again. Enter 2 to quit");
                int fun = scanner.nextInt();
                if (fun == 2) { gameState = 'q'; }
                else
                {
                    game = new GameBoard(numRows,numColumns,numToWin);
                    p = 'X';
                }
            }

            // checks for a tie
            else if (game.checkForDraw() == true)
            {
                System.out.println(game.toString());
                System.out.println("Game is a tie.\nEnter 1 to play again. Enter 2 to quit");
                int fun = scanner.nextInt();
                if (fun == 2) { gameState = 'q'; }
                else
                {
                    game = new GameBoard(numRows,numColumns,numToWin);
                    p = 'X';
                }
            }
            if (p == 'X') p = 'O';
            else p = 'X';
        }
    }
}
