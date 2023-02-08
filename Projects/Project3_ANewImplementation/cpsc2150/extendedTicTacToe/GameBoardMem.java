package cpsc2150.extendedTicTacToe;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GameBoardMem extends AbsGameBoard implements IGameBoard {

    static int MAX_ROW = 100;
    static int MAX_COL = 100;
    static int MAX_WIN = 25;

    /**
     * @invariant name != "" AND monthlyDeptPayments >= 0 AND income >= 0 AND 0 <= creditScore <= MAX_CREDIT_SCORE
     * Correspondence self.CreditScore = creditScore AND self.monthlyDebt = monthlyDebtPayments AND
     *                self.Loan = loan AND self.Income = income AND self.Name = name
     */

    static Map<Character, List<BoardPosition>> mapConBoard;

    private int rows;
    private int columns;
    private int numToWin;
    private char [] players = new char[12];


    public GameBoardMem(int user_row, int user_col, int user_tally)
    {
        numToWin = user_tally;
        rows = user_row;
        columns = user_col;
        int size = rows * columns;
        mapConBoard = new HashMap<Character, List<BoardPosition>>(100);
    }


    @Override
    public boolean checkSpace(int r, int c)
    {
        BoardPosition tmp = new BoardPosition(r,c);
        if(whatsAtPos(tmp) == ' ') { return true; }
        else return false;
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

    @Override
    public boolean isPlayerAtPos(BoardPosition p, char x)
    {
        if(mapConBoard.get(x).contains(p)){ return true; }
        else return false;
    }

    public void setPlayers(char p []) {


        int tmpLength = p.length;
        players = new char[tmpLength];
        players = p;

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
            Character tmp = players[i];
            mapConBoard.put(tmp, new LinkedList<BoardPosition>());
        }
    }
}

