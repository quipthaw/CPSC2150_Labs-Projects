package cpsc2150.extendedTicTacToe;

import cpsc2150.extendedTicTacToe.AbsGameBoard;
import cpsc2150.extendedTicTacToe.BoardPosition;

/** cpsc2150.extendedTicTacToe.GameBoard is board containing all methods that
 *  define the rules of the connect four game
 */
public class GameBoard extends AbsGameBoard implements IGameBoard
{
    /**
     * @invariant rows = rows in game board AND columns = columns in game board AND numToWin = amount in a row to win.
     */
    private int rows;
    private int columns;
    private int numToWin;

    /** Default Constructor
     * @post for all cpsc2150.extendedTicTacToe.BoardPosition pos = ' ';
     * @return Initialized Gameboard, all positions set to ' ';
     */
    char[][] board = new char[20][20];
    public GameBoard(int r, int c, int n)
    {
        rows = r;
        columns = c;
        numToWin = n;
        for(int i = 0; i < rows + 1; i++) {
            for(int j = 0; j < columns+1; j++)
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
