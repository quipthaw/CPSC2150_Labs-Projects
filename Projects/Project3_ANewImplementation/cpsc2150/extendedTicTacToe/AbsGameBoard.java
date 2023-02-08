package cpsc2150.extendedTicTacToe;

public abstract class AbsGameBoard implements IGameBoard {

    /** Returns a fully formatted (see example output) string that displays the current game
     *  Board. This does not print to the screen, it returns a String that represents the game board.
     *  Must override equals method.
     *
     * @pre none
     * @post String = board
     * @return new string made from current game board
     */

    @Override
    public String toString()
    {
        int fun = 0;
        String s = "  ";
        for(int i = 0; i < getNumColumns(); i++){
            s = s + " " + i + "|";
        }
        if(getNumColumns() < 9 ){ s = s+" ";}
        s = s + "\n";
        for(int i = 0; i < getNumRows(); i++){
            for(int j = 0; j < getNumColumns(); j++){
                if(j == 0)
                {
                    s = s + fun + "|";
                    fun++;
                }

                BoardPosition pop = new BoardPosition(i,j);
                s = s + whatsAtPos(pop);
                s = s + " |";
            }
            s = s + "\n";
        }
        return s;
    }
}
