package cpsc2150.extendedTicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * The TicTacToe controller class will handle communication between our TicTacToeView and our Model (IGameBoard and BoardPosition)
 * <p>
 * This is where you will write code
 * <p>
 * You will need to include your BoardPosition class, the IGameBoard interface
 * and the implementations from previous homeworks
 * If your code was correct you will not need to make any changes to your IGameBoard classes
 */


public class TicTacToeController {

    //our current game that is being played
    private IGameBoard curGame;

    //The screen that provides our view
    private TicTacToeView screen;


    private List<Character> players = new ArrayList<>();
    private boolean end = false;
    private int numPlayers;
    private int curUser = 0;



    public static final int MAX_PLAYERS = 10;

    /**
     * @param model the board implementation
     * @param view  the screen that is shown
     * @param np    The number of players for the game
     *
     * @pre 3 <= np <= MAX_NUM_PLAYERS
     * @post [the controller will respond to actions on the view using the model.]
     * @returns a response to the model and view will correct commands.
     */
    public TicTacToeController(IGameBoard model, TicTacToeView view, int np) {
        this.curGame = model;
        this.screen = view;
        this.numPlayers = np;

        String s = new String();
        s = "XYAEIOUPKLWQ";
        for(int i = 0; i < np; i++)
        {
            players.add(s.charAt(i));
            continue;
        }
    }

    /**
     * @param row the row of the activated button
     * @param col the column of the activated button
     *
     * @pre row and col are in the bounds of the game represented by the view
     * @post The button pressed will show the right token and check if a player has won.
     */
    public void processButtonClick(int row, int col) {

        //Checks to see if it is a new game, and calls newGame() accordingly
        if(end)
        {
            end = false;
            newGame();
        }

        //Re-iterates through players characters if at end
        if(curUser >= numPlayers){ curUser = 0; }

        BoardPosition pos = new BoardPosition(row,col);

        //Checks space availability
        if(!(curGame.checkSpace(row, col)))
        {
            screen.setMessage("That space is unavailable, please pick again...");
            return;
        }

        //Places marker in game
        curGame.placeMarker(pos,players.get(curUser));

        //Places marker on screen
        screen.setMarker(row,col,players.get(curUser));


        //Check for winner
        if(curGame.checkForWinner(pos,players.get(curUser)))
        {
            screen.setMessage("Player " + players.get(curUser) + " Wins! Press any button to play again!");
            end = true;
            return;
        }


        //Check for Draw
        if(curGame.checkForDraw())
        {
            screen.setMessage("The Game is a draw! Press any button to play again!");
            end = true;
            return;
        }

        //Iterates through players
        curUser++;
        if(curUser >= numPlayers){curUser = 0;}
        screen.setMessage("It is " + players.get(curUser) + "'s turn.");

    }

    private void newGame() {
        // You do not need to make any changes to this code.
        screen.dispose();
        GameSetupScreen screen = new GameSetupScreen();
        GameSetupController controller = new GameSetupController(screen);
        screen.registerObserver(controller);
    }
}