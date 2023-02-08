package cpsc2150.extendedTicTacToe;

import cpsc2150.extendedTicTacToe.AbsGameBoard;
import cpsc2150.extendedTicTacToe.BoardPosition;

/**
 * @invariant 3 <= rows <= MAX_ROW AND
 *            3 <= columns <= MAX_COL AND
 *            3 <= numToWin <= MAX_WIN
 *
 * Correspondence self.rows = r AND self.columns = c AND self.numToWin = n
 */
public class GameBoard extends AbsGameBoard implements IGameBoard
{

    static int MAX_ROW = 100;
    static int MAX_COL = 100;
    static int MAX_WIN = 25;

    private int rows;
    private int columns;
    private int numToWin;
    char[][] board;

    /** Default Constructor that creates a Char array that will act as the GameBoard.
     * @param r Rows
     * @param c Columns
     * @param n Number To Win
     *
     * @post for all board[r][c] each position is set to = ' ' AND
     *       r = #r AND
     *       c = #c AND
     *       n = #n
     *
     * @return Array board as Initialized Gameboard, all positions are set to ' ';
     */
    public GameBoard(int r, int c, int n)
    {
        board = new char[r+1][c+1];
        rows = r;
        columns = c;
        numToWin = n;
        for(int i = 0; i < rows + 1; i++) {
            for(int j = 0; j < columns + 1; j++)
            { board[i][j] = ' '; } }
    }


    @Override
    public int getNumRows(){return rows;}

    @Override
    public int getNumColumns() {
        return columns;
    }

    @Override
    public int getNumToWin() {
        return numToWin;
    }

    @Override
    public boolean checkSpace(int r, int c)
    {
        if(r > rows || c > columns){return false;}
        if(board[r][c] == ' ') { return true; }
        else return false;
    }

    @Override
    public void placeMarker(BoardPosition p, char c)
    {
        board[p.getRow()][p.getColumn()] = c;
    }

    @Override
    public char whatsAtPos(BoardPosition p)
    {

        char t = ' ';
        if(p.getRow() < 0|| p.getColumn() < 0){return t;}

        return board[p.getRow()][p.getColumn()];
    }

}