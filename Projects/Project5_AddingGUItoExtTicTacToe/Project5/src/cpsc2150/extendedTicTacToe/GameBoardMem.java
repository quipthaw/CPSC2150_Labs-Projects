package cpsc2150.extendedTicTacToe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @invariant 3 <= rows <= MAX_ROW AND
 *            3 <= columns <= MAX_COL AND
 *            3 <= numToWin <= MAX_WIN
 *
 * Correspondence self.rows = user_row AND self.columns = user_col AND self.numToWin = user_tally
 */
public class GameBoardMem extends AbsGameBoard implements IGameBoard {

    static int MAX_ROW = 100;
    static int MAX_COL = 100;
    static int MAX_WIN = 25;
    static int MAX_PLAYERS = 12;

    static Map<Character, List<BoardPosition>> mapConBoard;

    private int rows;
    private int columns;
    private int numToWin;
    private char [] players = new char[MAX_PLAYERS];



    /** Default Constructor that creates a new GameBoard out of a HashMap
     * @param user_row Rows
     * @param user_col Columns
     * @param user_tally Number To Win
     *
     * @post [ MapConBoard should be created with correct parameters to initialize the game board ] AND
     *       user_row = #user_row AND
     *       user_col = #user_col AND
     *       user_tally = #user_tally
     *
     * @return HashMap mapConBoard as Initialized Gameboard;
     */
    public GameBoardMem(int user_row, int user_col, int user_tally)
    {
        numToWin = user_tally;
        rows = user_row;
        columns = user_col;
        int size = rows * columns;
        mapConBoard = new HashMap<Character, List<BoardPosition>>(size);
        initPLayers();

    }


    @Override
    public boolean checkSpace(int r, int c)
    {
        BoardPosition tmp = new BoardPosition(r,c);
        if(r > rows || c > columns){ return false; }
        else if(whatsAtPos(tmp) == ' ') { return true; }
        else {return false;}
    }

    @Override
    public int getNumRows() { return rows; }

    @Override
    public int getNumColumns() { return columns; }

    @Override
    public int getNumToWin() { return numToWin; }


    @Override
    public boolean checkForWinner(BoardPosition pop, char p) {
        {
            if(p == ' '){return false;}
            if(checkVerticalWin(pop, p) || checkHorizontalWin(pop,p) || checkDiagonalWin(pop, p))
            {
                return true;
            }
            else return false;
        }
    }

    public boolean checkForDraw() {
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                BoardPosition tmp = new BoardPosition(j, i);
                if (whatsAtPos(tmp) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void placeMarker(BoardPosition p, char c)
    {

        mapConBoard.get(c).add(p);
    }

    @Override
    public char whatsAtPos(BoardPosition p)
    {
        Integer IntRow = p.getRow();
        Integer IntCol = p.getColumn();
        if(mapConBoard.isEmpty())
        {
            return ' ';
        }

        //new
        for( int i = 0; i < players.length; i++)
        {
            if(mapConBoard.get(players[i]).contains(p)){ return players[i]; }
        }

        return ' ';
    }

    public void initPLayers(){
        String s = new String();
        s = "XYAEIOUPKLWQTRG";

        for(int i = 0; i < MAX_PLAYERS; i++)
        {
            Character tmp = s.charAt(i);
            players[i] = tmp;
            mapConBoard.put(tmp, new LinkedList<BoardPosition>());
        }
    }

    public void setPlayers(char p []) {


        int tmpLength = p.length;
        players = new char[tmpLength];
        players = p;

        for (int i = 0; i < players.length; i++) {
            //System.out.println(players[i]);
            Character tmp = players[i];
            mapConBoard.put(tmp, new LinkedList<BoardPosition>());
        }
    }
}

