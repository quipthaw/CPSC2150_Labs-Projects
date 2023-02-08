package cpsc2150.extendedTicTacToe;
import java.util.Scanner;

/** GameScreen is the main display of progression of the game
 *  and the program the user will input into
 */
public class GameScreen {

    /**
     * Main function, initializes and displays game board. Prompts players to each enter a
     * column position until one of them has won with 5 of the same tokens in a row. After a win,
     * the program displays the winner then lets the users choose whether or not they wish to play
     * again or quit the program.
     */


    private static char gameState = 'p';
    private static char p = 'X';
    private static char gameType = 'z';
    private static char[] players = new char[12];
    private static int numPlayers = -12;
    private static int numRows = -12;
    private static int numColumns = -12;
    private static int numToWin = 30;
    private static int moves = 0;
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        while (gameType == 'z') {
            System.out.println("Would you like a Fast Game (f/F), or a Memory Effecient game (m/M)? ");
            gameType = scanner.next().charAt(0);
            if (gameType == 'f' || gameType == 'F' || gameType == 'm' || gameType == 'M') {
            } else {
                gameType = 'z';
                System.out.println("Invalid Game Type, Must be m/M or f/F, Try again");
            }
        }
        initialize();
        if (gameType == 'f' || gameType == 'F') {
            FastGame();
        } else if (gameType == 'm' || gameType == 'M') {
            MemoryGame();
        }
    }




    public static void initialize() {
        while (numPlayers < 2 || numPlayers > 10) {
            if (numPlayers != -12) {
                if (numPlayers > 9) {
                    System.out.println("number of players must be fewer than 10");
                }
                if (numPlayers < 2) {
                    System.out.println("Must be at least 2 players");
                }
            }
            System.out.println("How Many Players?");
            numPlayers = scanner.nextInt();
        }

        // can be any character
        players = new char[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter the character to represent player " + (i + 1));
            //System.out.println("Must choose between x, o, t, or w");

            char lit = scanner.next().charAt(0);
            lit = Character.toUpperCase(lit);
            players[i] = lit;

            for (int joy = 0; joy < i; joy++) {
                if (players[joy] == players[i]) {
                    System.out.println(players[i] + " is already taken as a player token!");
                    i--;
                    break;
                }
            }
        }


        // gets row number
        while (numRows < 3 || numRows > 100) {
            if (numRows != -12) {
                System.out.println("invalid Row amount, try again");
            }
            System.out.println("Enter the number of rows");
            numRows = scanner.nextInt();
        }
        // gets col number
        while (numColumns < 3 || numColumns > 100) {
            if (numColumns != -12) {
                System.out.println("invalid Column amount, try again");
            }
            System.out.println("Enter the number of columns");
            numColumns = scanner.nextInt();
        }
        // gets num to win
        while (numToWin > numColumns || numToWin > numRows || numToWin < 3 || numToWin > 25) {
            if (numToWin != 30) {
                System.out.println("Ivalid number to win. Must be less than 26, less than number of rows and columns, and greater than 2");
            }
            System.out.println("Enter the number of tokens in a row to win");
            numToWin = scanner.nextInt();
        }
    }





    public static void FastGame() {
        moves = 0;
        GameBoard game = new GameBoard(numRows, numColumns, numToWin);

        while (gameState == 'p') {

            p = players[moves];
            moves++;
            if (moves == numPlayers) {
                moves = 0;
            }

            if (numColumns == -12) {
                initialize();
                game = new GameBoard(numRows, numColumns, numToWin);
            }


            System.out.println(game.toString());
            System.out.println("Player " + p + ", what column would you like to place your marker in?");

            int tmpCol = 16;
            while (tmpCol < 0 || tmpCol >= numColumns) {
                if (tmpCol != 16) {
                    System.out.println("Please enter valid input between 0 and " + numColumns);
                }
                tmpCol = scanner.nextInt();
            }

            System.out.println("Player " + p + ", what row do you want to place your marker in?");
            int tmpRow = 16;
            while (tmpRow < 0 || tmpRow >= numRows) {
                if (tmpRow != 16) {
                    System.out.println("Please enter valid input between 0 and " + numRows);
                }
                tmpRow = scanner.nextInt();
            }


            while (game.checkSpace(tmpRow, tmpCol) == false) {
                System.out.println("Position is full please enter another Col & Row");

                System.out.println("Column:");
                tmpCol = scanner.nextInt();

                System.out.println("Row:");
                tmpRow = scanner.nextInt();

            }


            BoardPosition pew = new BoardPosition(tmpRow, tmpCol);
            game.placeMarker(pew, p);


            if (game.checkForWinner(pew, p)) {
                System.out.println(game.toString());
                System.out.println("Player " + p + " has won!\nEnter 1 to play again. Enter 2 to quit");
                int fun = scanner.nextInt();

                if (fun == 2) {
                    gameState = 'q';
                } else {
                    game = new GameBoard(0, 0, 0);
                    numPlayers = -12;
                    numRows = -12;
                    numColumns = -12;
                    numToWin = 30;
                    moves = 0;
                }
            } else if (game.checkForDraw() == true) {
                game.toString();
                System.out.println("Game is a tie.\nEnter 1 to play again. Enter 2 to quit");
                int fun = scanner.nextInt();
                if (fun == 2) {
                    gameState = 'q';
                } else {
                    game = new GameBoard(0, 0, 0);
                    numPlayers = -12;
                    numRows = -12;
                    numColumns = -12;
                    numToWin = 30;
                    moves = 0;
                }
            }
        }
    }




    public static void MemoryGame() {

        numToWin = numToWin + 1;

        moves = 0;
        GameBoardMem game = new GameBoardMem(numRows, numColumns, numToWin);

        game.setPlayers(players);

        while (gameState == 'p') {

            p = players[moves];
            moves++;
            if (moves == numPlayers) {
                moves = 0;
            }

            if (numColumns == -12) {
                initialize();
                game = new GameBoardMem(numRows, numColumns, numToWin);
                game.setPlayers(players);
            }


            System.out.println(game.toString());
            System.out.println("Player " + p + ", what column would you like to place your marker in?");


            int tmpCol = 16;
            while (tmpCol < 0 || tmpCol >= numColumns) {
                if (tmpCol != 16) {
                    System.out.println("Please enter valid input between 0 and " + numColumns);
                }
                tmpCol = scanner.nextInt();
            }

            System.out.println("Player " + p + ", what row do you want to place your marker in?");
            int tmpRow = 16;
            while (tmpRow < 0 || tmpRow >= numRows) {
                if (tmpRow != 16) {
                    System.out.println("Please enter valid input between 0 and " + numRows);
                }
                tmpRow = scanner.nextInt();
            }


            while (game.checkSpace(tmpRow, tmpCol) == false) {
                System.out.println("Position is full please enter another Col & Row");

                System.out.println("Column:");
                tmpCol = scanner.nextInt();

                System.out.println("Row:");
                tmpRow = scanner.nextInt();

            }


            BoardPosition pew = new BoardPosition(tmpRow, tmpCol);
            game.placeMarker(pew, p);


            if (game.checkForWinner(pew, p)) {
                System.out.println(game.toString());
                System.out.println("Player " + p + " has won!\nEnter 1 to play again. Enter 2 to quit");
                int fun = scanner.nextInt();

                if (fun == 2) {
                    gameState = 'q';
                } else {
                    game = new GameBoardMem(0, 0, 0);
                    numPlayers = -12;
                    numRows = -12;
                    numColumns = -12;
                    numToWin = 30;
                    moves = 0;
                    game.setPlayers(players);
                }
            } else if (game.checkForDraw() == true) {
                game.toString();
                System.out.println("Game is a tie.\nEnter 1 to play again. Enter 2 to quit");
                int fun = scanner.nextInt();
                if (fun == 2) {
                    gameState = 'q';
                } else {
                    game = new GameBoardMem(0, 0, 0);
                    numPlayers = -12;
                    numRows = -12;
                    numColumns = -12;
                    numToWin = 30;
                    moves = 0;
                    game.setPlayers(players);
                }
            }
        }
    }
}



