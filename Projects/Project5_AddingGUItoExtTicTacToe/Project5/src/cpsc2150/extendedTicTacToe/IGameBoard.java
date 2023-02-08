package cpsc2150.extendedTicTacToe;


/**
 * This will hold the information about a GameBoard, and will handle all calculations for winnings, ties, and marker positions
 *
 * Defines: Rows: R - The number of rows on the board
 *          Columns: R - The number of columns on the board
 *          NumToWin: R - Number of consecutive markers in a row needed to win the game
 *
 * Initialization Ensures: [ A Game Board is created with the right specifications and game regulations ]
 *
 * Constraints: 3 <= Rows <= MAX_ROW_NUM AND
 *              3 <= Columns <= MAX_COLUMN_NUM AND
 *              3 <= NumToWin <= (Columns OR Rows) [ whichever of the two is largest ]
 */
public interface IGameBoard {


    /** Returns true if column is able to accept another token false otherwise.
     *
     * @param c Column Number
     * @pre c >= 0 <= 8
     * @post checkSpace = true iff (!(board[c][0] != '.' OR board[c][1] != '.' OR board[c][2] != '.'
     *                          AND board[c][3] != '.' OR board[c][4] != '.' OR board[c][5] != '.'
     *                          OR board[c][6] != '.' OR board[c][7] != '.' OR board[c][8] != '.'))
     *                          AND returns true if board has empty space.
     * @return true if column has free position
     */
    public boolean checkSpace(int r, int c);


    /** Places a token p in column c on the game board.
     *  The token will be placed in the lowest available row in column c.
     *
     * @param p BoardPosition
     * @param c Column Number
     * @pre 0 <= p.getRow() < MAX_ROW_NUM AND
     *      0 <= p.getColumn() < MAX_COLUMN_NUM AND
     *      [ p was the location where the last marker was placed in ]
     * @post board[c][r] = p iff (checkIfFree = true)
     */
    public void placeMarker(BoardPosition p, char c);



    /** Returns the char that is in position pos of
     *  The game board. If there is no token at the spot it should return a blank space character: ' '.
     *
     * @param p BoardPosition
     * @pre 0 <= p.getRow() < MAX_ROW_NUM AND
     *      0 <= p.getColumn() < MAX_COLUMN_NUM AND
     *      [ p was the location where the last marker was placed in ]
     * @post whatsAtPos = pos OR iff (CheckIfFree at pos = true) | whatsAtPos = ' '
     * @return Type of player at the position
     */
    public char whatsAtPos(BoardPosition p);


    /** Returns true if the player is at that position.
     *
     *
     * @param p Boardposition
     * @param x Which player type
     * @pre 0 < p.getRow < 6 AND 0 < p.getColumn < 8
     * @post isPlayerAtPos = true iff(pos = player)
     * @return true if player is at the position
     */
    default boolean isPlayerAtPos(BoardPosition p, char x)
    {
        if(whatsAtPos(p) == x){return true;}
        else return false;
    };


    /** Returns the number of rows in the game board.
     *
     * @return Number of Rows
     *
     */
    public int getNumRows();


    /** Returns the number of columns in the game board.
     *
     * @return Number of Rows
     */
    public int getNumColumns();


    /** Returns the number in a row to win in the game board.
     *
     * @return Number of Rows
     */
    public int getNumToWin();




    /** Returns true if the last token placed (which was placed in column c) resulted  in the player
     *  winning the game. Otherwise, it returns false.
     *
     * @param p Board Position
     * @param x Player Character
     * @pre 0 <= p.getRow() < MAX_ROW_NUM AND
     *      0 <= p.getColumn() < MAX_COLUMN_NUM AND
     *      [ p was the location where the last marker was placed in ]
     * @post checkForWin = true iff (checkHorizontalWin() = true OR checkVerticalWin() = true OR checkDiagonalWin() = true)
     * @return true if player has won
     */
    default boolean checkForWinner(BoardPosition p, char x)
    {
        if(x == ' '){return false;}

        if(checkDiagonalWin(p,x) || checkHorizontalWin(p, x) || checkVerticalWin(p,x))
        {
            return true;
        }
        else return false;
    }


    /** Returns true if the game board results in a tie game, otherwise it returns false.
     *
     * @pre checkForWinner = false
     * @post checkTie = true iff (forall columnPosition c in checkIfFree() = false AND checkForWin() = false)
     * @return true if no position on the board remain empty
     */
    default boolean checkForDraw()
    {
        for( int i = 0; i < getNumColumns(); i++) {
            for( int j = 0; j < getNumRows(); j++)
                if(checkSpace(j, i) == true){return false;} }
        return true;
    }


    /** Returns true if the last token placed (which was placed in position pos and player p)
     *  Resulted in the player winning by getting 5 in a row horizontally. Otherwise, it returns false.
     *
     * @param x player type
     * @param p Board Position
     *@pre 0 <= p.getRow() < MAX_ROW_NUM AND
     *     0 <= p.getColumn() < MAX_COLUMN_NUM AND
     *     [ p was the location where the last marker was placed in ]
     * @post checkHorizWin = true iff (#ofSameInRow = NUM_TO_WIN)
     * @return true if player has horizontal win
     */
    default boolean checkHorizontalWin(BoardPosition p, char x)
    {

        int n = getNumToWin();
        int count = 1;
        int c = p.getColumn();
        BoardPosition tmp = new BoardPosition(p.getRow(), p.getColumn() );
        if ((c - 1) >= 0)
        {
            //checks left from board position
            for (int column = p.getColumn(); whatsAtPos(tmp) == x; column--)
            {
                tmp = new BoardPosition(p.getRow(), column);
                if(whatsAtPos(tmp) == x && x != ' '){
                    if(!p.equals(tmp)){count++;}
                }
                if (count >= n) { return true; }
            }

            // Checks right from board position
            tmp = new BoardPosition(p.getRow(), p.getColumn() );
            for (int column = p.getColumn(); whatsAtPos(tmp) == x; column++)
            {
                tmp = new BoardPosition(p.getRow(), column);
                if(whatsAtPos(tmp) == x && x != ' '){
                    if(!p.equals(tmp)){count++;}
                }
                if (count >= n) { return true; }
            }
        }
        return false;
    }


    /** Returns true if the last token placed (which was placed in position pos and player p)
     *  Resulted in the player getting 5 in a row vertically. Otherwise, it returns false.
     *
     * @oaram x Player type
     * @param p BoardPosition
     * @pre 0 <= p.getRow() < MAX_ROW_NUM AND
     *      0 <= p.getColumn() < MAX_COLUMN_NUM AND
     *      [ p was the location where the last marker was placed in ]
     * @post checkVertWin = true iff (#ofSameVertical = NUM_TO_WIN)
     * @return true if player has vertical win
     */
    default boolean checkVerticalWin(BoardPosition p, char x) {
        int count = 1;
        int r = p.getRow();
        int n = getNumToWin();


        BoardPosition tmp = new BoardPosition(p.getRow(), p.getColumn() );
        if ((r - 1) >= 0) {

            //Checks down from board position
            for (int row = p.getRow(); whatsAtPos(tmp) == x; row--)
            {
                tmp = new BoardPosition(row, p.getColumn());
                if(whatsAtPos(tmp) == x && whatsAtPos(tmp) != ' '){
                    if(!p.equals(tmp)){count++;}
                }
                if (count >= n) { return true; }
            }

            //Checks up from board position
            tmp = new BoardPosition(p.getRow(), p.getColumn() );
            for (int row = p.getRow(); whatsAtPos(tmp) == x; row++)
            {
                tmp = new BoardPosition(row, p.getColumn());
                if(whatsAtPos(tmp) == x){
                    if(!p.equals(tmp)){count++;}
                }
                if (count >= n) { return true; }
            }
        }
        return false;
    }

    /** Returns true if the last token placed (which was placed in position pos and player p
     *  Resulted in the player getting 5 in a row diagonally. Otherwise, it returns false.
     *
     * @param x Player Character
     * @param p Last Position of latest play
     * @pre 0 <= p.getRow() < MAX_ROW_NUM AND
     *      0 <= p.getColumn() < MAX_COLUMN_NUM AND
     *      [ p was the location where the last marker was placed in ]
     * @post checkDiagWin = true iff(#ofSameDiagnal = NUM_TO_WIN
     * @return true if player has diagonal win
     */
    default boolean checkDiagonalWin(BoardPosition p, char x) {

        int count = 1;
        BoardPosition tmp = new BoardPosition(p.getRow(),p.getColumn());
        for (int row = p.getRow(), col = p.getColumn(); row >= 0 && col >= 0 &&
                whatsAtPos(tmp) == x; row--, col--)
        {
            tmp = new BoardPosition(row,col);
            if(!p.equals(tmp) && whatsAtPos(tmp)==x && whatsAtPos(tmp) != ' '){ count++; }
            if (count >= getNumToWin()) { return true; }
        }

        tmp = new BoardPosition(p.getRow(),p.getColumn());
        for (int row = p.getRow(), col = p.getColumn(); row < getNumRows() && col < getNumColumns() &&
                whatsAtPos(tmp) == x; row++, col++)
        {
            tmp = new BoardPosition(row,col);
            if(!p.equals(tmp) && whatsAtPos(tmp)==x && whatsAtPos(tmp) != ' '){ count++; }
            if (count >= getNumToWin()) { return true; }
        }


        count = 1;
        tmp = new BoardPosition(p.getRow(),p.getColumn());
        for (int row = p.getRow(), col = p.getColumn(); row < getNumRows() && col >= 0 &&
                whatsAtPos(tmp) == x; row++, col--)
        {
            tmp = new BoardPosition(row,col);
            if(!p.equals(tmp) && whatsAtPos(tmp)==x && whatsAtPos(tmp) != ' '){ count++; }
            if (count >= getNumToWin()) { return true; }

        }
        tmp = new BoardPosition(p.getRow(),p.getColumn());
        for (int row = p.getRow(), col = p.getColumn(); row >= 0 && col < getNumColumns() &&
                whatsAtPos(tmp) == x; row--, col++)
        {
            tmp = new BoardPosition(row,col);
            if(!p.equals(tmp) && whatsAtPos(tmp)==x && whatsAtPos(tmp) != ' '){ count++; }
            if (count >= getNumToWin()) { return true; }

        }
        return false;
    }
}
