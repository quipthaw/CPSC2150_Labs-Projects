package cpsc2150.extendedTicTacToe;

/** cpsc2150.extendedTicTacToe.BoardPosition holds the values held within each positions of the board
 */
public class BoardPosition
{

    /**
     * @invariant rowPosition = row / r AND columnPosition = column / c
     */
    private int rowPositon;
    private int columnPosition;

    /** Default Constructor
     *@param r Row position
     *@param c Column Position
     * @pre r >= 0 <= 5 AND c >= 0 <= 8
     * @post rowPosiion = r AND
     *       columnPosition = c AND
     *       r = #r AND
     *       c = #c
     * @return the cpsc2150.extendedTicTacToe.BoardPosition
     */

    public BoardPosition(int r, int c)
    {
        rowPositon = r;
        columnPosition = c;
    }

    /** returns the row
     *
     * @post getRow = rowPosition
     * @return the row position
     */
    public int getRow()
    {
        return rowPositon;
    }

    /** returns the column
     *
     * @post getColumn = columnPosition
     * @return the column position
     */
    public int getColumn()
    {
        return columnPosition;
    }

    /**
     * Overrides the equals method
     * @post Returns true if equal, false of not
     * @returns whether equal or not.
     * */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition that = (BoardPosition) o;
        return rowPositon == that.rowPositon && columnPosition == that.columnPosition;
    }

    @Override
    public String toString() {
        return rowPositon + "," + columnPosition;
    }
}
