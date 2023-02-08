package cpsc2150.extendedTicTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGameBoard
{

    private IGameBoard Board(int row, int col, int numToWin) {
        return new GameBoard(row, col, numToWin);
    }
    private String TestBoard(char[][] b)
    {
        String curr = "  ";
        for (int i = 0; i <= b.length - 1; i++)
        {
            for (int j = 0; j <= b[0].length - 1; j++)
            {
                if (i == 0 && j == 0)
                {
                    curr += " ";
                    for (int k = 0; k <= b[0].length - 1; k++)
                    {
                        if (k >= 9) { curr += k + "|"; }
                        else {curr += k + "| ";}
                    }
                    curr += "\n";
                }
                if (j == 0)
                {
                    if (i <= 9) { curr += i; }
                    curr += "|";
                }
                char id = b[i][j];
                curr += id + " |";

                if (j == b[0].length - 1) { curr += "\n"; }
            }
        }
        return curr;
    }

    //constructor
    @Test
    public void test_constructor_5x5_() {
        char[][] tmp = new char[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                tmp[i][j] = ' ';
            }
        }
        IGameBoard gb = Board(5, 5, 3);
        String expected = TestBoard(tmp);
        assertEquals(expected, gb.toString());
    }

    @Test
    public void test_constructor_5x10_()
    {
        char[][] tmp = new char[5][10];
        for (int i = 0; i <= 4; i++)
        {
            for (int j = 0; j < 10; j++) { tmp[i][j] = ' '; }
        }
        IGameBoard gb = Board(5, 10, 3);
        String expected = TestBoard(tmp);
        assertEquals(expected, gb.toString());
    }

    @Test
    public void test_constructor_10x5_() {
        char[][] tmp = new char[10][5];
        for (int i = 0; i <= 9; i++)
        {
            for (int j = 0; j <= 4; j++) { tmp[i][j] = ' '; }
        }
        IGameBoard gb = Board(10, 5, 3);
        String expected = TestBoard(tmp);
        assertEquals(expected, gb.toString());
    }



    //Check Space
    @Test
    public void test_checkSpace_empty_space() {
        boolean expected = true;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(0, 2);
        BoardPosition two = new BoardPosition(1, 2);
        BoardPosition three = new BoardPosition(1,1);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.checkSpace(1,1));
    }

    @Test
    public void test_checkSpace_taken_space() {
        boolean expected = false;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(0, 2);
        BoardPosition two = new BoardPosition(1, 2);
        BoardPosition three = new BoardPosition(1,1);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.checkSpace(1,2));
    }

    @Test
    public void test_checkSpace_space_out_of_bounds() {
        boolean expected = false;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(0, 2);
        BoardPosition two = new BoardPosition(1, 2);
        BoardPosition three = new BoardPosition(1,1);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.checkSpace(4,4));
    }





    //Horizontal
    @Test
    public void test_Horizontal_Win_middle_() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(2, 5);
        BoardPosition three = new BoardPosition(2, 6);
        BoardPosition four = new BoardPosition(3, 3);
        BoardPosition five = new BoardPosition(3, 4);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkHorizontalWin(two, 'X'));
    }

    @Test
    public void test_Horizontal_Win_left_() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(2, 5);
        BoardPosition three = new BoardPosition(2, 6);
        BoardPosition four = new BoardPosition(3, 3);
        BoardPosition five = new BoardPosition(3, 4);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkHorizontalWin(one, 'X'));
    }

    @Test
    public void test_Horizontal_Win_right_() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(2, 5);
        BoardPosition three = new BoardPosition(2, 6);
        BoardPosition four = new BoardPosition(3, 3);
        BoardPosition five = new BoardPosition(3, 4);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkHorizontalWin(three, 'X'));
    }

    @Test
    public void test_Horizontal_middle_empty() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(2, 5);
        BoardPosition three = new BoardPosition(2, 7);
        BoardPosition four = new BoardPosition(2, 8);
        BoardPosition five = new BoardPosition(3, 3);
        BoardPosition six = new BoardPosition(3, 4);
        BoardPosition seven = new BoardPosition(3, 5);
        boolean expected = false;
        IGameBoard gb = Board(10, 10, 5);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'X');
        gb.placeMarker(five, 'O');
        gb.placeMarker(six, 'O');
        gb.placeMarker(seven, 'O');
        assertEquals(expected, gb.checkHorizontalWin(four, 'X'));
    }

    @Test
    public void test_Vertical_Win_middle_() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(3, 4);
        BoardPosition three = new BoardPosition(4, 4);
        BoardPosition four = new BoardPosition(5, 3);
        BoardPosition five = new BoardPosition(5, 4);
        boolean expected = true;
        IGameBoard gb = Board(6, 6, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkVerticalWin(two, 'X'));
    }

    @Test
    public void test_Vertical_Win_top_() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(3, 4);
        BoardPosition three = new BoardPosition(4, 4);
        BoardPosition four = new BoardPosition(5, 3);
        BoardPosition five = new BoardPosition(5, 4);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkVerticalWin(one, 'X'));
    }

    @Test
    public void test_Vertical_Win_bottom_() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(3, 4);
        BoardPosition three = new BoardPosition(4, 4);
        BoardPosition four = new BoardPosition(5, 3);
        BoardPosition five = new BoardPosition(5, 4);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkVerticalWin(three, 'X'));
    }

    @Test
    public void test_Vertical_middle_empty() {
        BoardPosition one = new BoardPosition(2, 4);
        BoardPosition two = new BoardPosition(3, 4);
        BoardPosition three = new BoardPosition(5, 4);
        BoardPosition four = new BoardPosition(6, 4);
        BoardPosition five = new BoardPosition(1, 3);
        BoardPosition six = new BoardPosition(5, 8);
        BoardPosition seven = new BoardPosition(5, 5);
        boolean expected = false;
        IGameBoard gb = Board(10, 10, 5);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'X');
        gb.placeMarker(five, 'O');
        gb.placeMarker(six, 'O');
        gb.placeMarker(seven, 'O');
        assertEquals(expected, gb.checkVerticalWin(three, 'X'));
    }



    //Diagonal
    @Test
    public void test_Diagonal_Win_bottom_left_() {
        BoardPosition one = new BoardPosition(4, 4);
        BoardPosition two = new BoardPosition(3, 5);
        BoardPosition three = new BoardPosition(2, 6);
        BoardPosition four = new BoardPosition(1, 3);
        BoardPosition five = new BoardPosition(5, 8);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkDiagonalWin(one, 'X'));
    }

    @Test
    public void test_Diagonal_Win_top_right_() {
        BoardPosition one = new BoardPosition(4, 4);
        BoardPosition two = new BoardPosition(3, 5);
        BoardPosition three = new BoardPosition(2, 6);
        BoardPosition four = new BoardPosition(1, 3);
        BoardPosition five = new BoardPosition(5, 8);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkDiagonalWin(three, 'X'));
    }

    @Test
    public void test_Diagonal_Win_bottom_right_() {
        BoardPosition one = new BoardPosition(4, 4);
        BoardPosition two = new BoardPosition(5, 5);
        BoardPosition three = new BoardPosition(6, 6);
        BoardPosition four = new BoardPosition(1, 3);
        BoardPosition five = new BoardPosition(5, 8);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkDiagonalWin(three, 'X'));
    }

    @Test
    public void test_Diagonal_Win_top_left_() {
        BoardPosition one = new BoardPosition(4, 4);
        BoardPosition two = new BoardPosition(5, 5);
        BoardPosition three = new BoardPosition(6, 6);
        BoardPosition four = new BoardPosition(1, 3);
        BoardPosition five = new BoardPosition(5, 8);
        boolean expected = true;
        IGameBoard gb = Board(10, 10, 3);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'O');
        gb.placeMarker(five, 'O');
        assertEquals(expected, gb.checkDiagonalWin(one, 'X'));
    }


    @Test
    public void test_Diagonal_2nd_to_last_from_right_() {
        BoardPosition one = new BoardPosition(0, 9);
        BoardPosition two = new BoardPosition(1, 8);
        BoardPosition three = new BoardPosition(2, 7);
        BoardPosition four = new BoardPosition(3, 6);
        BoardPosition five = new BoardPosition(4, 5);

        boolean expected = true;
        IGameBoard gb = Board(10, 10, 5);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'X');
        gb.placeMarker(five, 'X');
        assertEquals(expected, gb.checkDiagonalWin(two, 'X'));
    }

    @Test
    public void test_Diagonal_second_to_last_from_left_() {
        BoardPosition one = new BoardPosition(9, 8);
        BoardPosition two = new BoardPosition(5, 4);
        BoardPosition three = new BoardPosition(6, 5);
        BoardPosition four = new BoardPosition(7, 6);
        BoardPosition five = new BoardPosition(8, 7);
        BoardPosition six = new BoardPosition(7,6 );

        boolean expected = true;
        IGameBoard gb = Board(10, 10, 5);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'X');
        gb.placeMarker(five, 'X');
        assertEquals(expected, gb.checkDiagonalWin(three, 'X'));
    }

    @Test
    public void test_Diagonal_middle_() {
        BoardPosition one = new BoardPosition(9, 9);
        BoardPosition two = new BoardPosition(5, 5);
        BoardPosition three = new BoardPosition(6, 6);
        BoardPosition four = new BoardPosition(7, 7);
        BoardPosition five = new BoardPosition(8, 8);
        BoardPosition six = new BoardPosition(7,7 );

        boolean expected = true;
        IGameBoard gb = Board(10, 10, 5);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'X');
        gb.placeMarker(three, 'X');
        gb.placeMarker(four, 'X');
        gb.placeMarker(five, 'X');
        assertEquals(expected, gb.checkDiagonalWin(four, 'X'));
    }



    //Check Tie
    @Test
    public void test_Tie_full_board() {
        boolean expected = true;
        IGameBoard gb = Board(5, 5, 5);
        int count = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                BoardPosition temp = new BoardPosition(i, j);
                char curr = ' ';
                if (count % 2 == 0) { curr = 'X'; }
                else { curr = 'O'; }
                if (i == 2 && j == 2) { curr = 'O'; }
                gb.placeMarker(temp, curr);
                count++;
            }
        }

        assertEquals(expected, gb.checkForDraw());
    }

    @Test
    public void test_Tie_Half_board()
    {
        boolean expected = false;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(0, 0);
        BoardPosition two = new BoardPosition(0, 2);
        BoardPosition three = new BoardPosition(0, 1);
        BoardPosition four = new BoardPosition(1, 0);
        BoardPosition five = new BoardPosition(1, 1);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        gb.placeMarker(three, 'O');
        gb.placeMarker(four, 'X');
        gb.placeMarker(five, 'X');
        assertEquals(expected, gb.checkForDraw());
    }

    @Test
    public void test_Tie_empty_board()
    {
        boolean expected = false;
        IGameBoard gb = Board(3, 3, 3);
        assertEquals(expected, gb.checkForDraw());
    }

    @Test
    public void test_Tie_one_left_()
    {
        BoardPosition one = new BoardPosition(0, 0);
        boolean expected = false;
        IGameBoard gb = Board(5, 5, 5);
        int count = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                BoardPosition temp = new BoardPosition(i, j);
                char curr = ' ';
                if (count % 2 == 0) { curr = 'X'; }
                else { curr = 'O'; }
                if (i == 2 && j == 2) { curr = 'O'; }
                gb.placeMarker(temp, curr);
                count++;
            }
        }
        gb.placeMarker(one,' ');

        assertEquals(expected, gb.checkForDraw());
    }





    //Whats at pos
    @Test
    public void test_whatsAtPos_empty_marker() {
        char expected = ' ';
        BoardPosition one = new BoardPosition(0, 2);
        IGameBoard gb = Board(3, 3, 3);
        assertEquals(expected, gb.whatsAtPos(one));
    }

    @Test
    public void test_whatsAtPos_top_right_corner() {
        char expected = 'X';
        BoardPosition one = new BoardPosition(0, 2);
        IGameBoard gb = Board(3, 3, 3);
        gb.placeMarker(one, 'X');
        assertEquals(expected, gb.whatsAtPos(one));
    }

    @Test
    public void test_whatsAtPos_top_left_corner() {
        char expected = 'X';
        BoardPosition one = new BoardPosition(0, 0);
        IGameBoard gb = Board(3, 3, 3);
        gb.placeMarker(one, 'X');
        assertEquals(expected, gb.whatsAtPos(one));
    }

    @Test
    public void test_whatsAtPos_bottom_left_corner() {
        char expected = 'X';
        BoardPosition one = new BoardPosition(2, 0);
        IGameBoard gb = Board(3, 3, 3);
        gb.placeMarker(one, 'X');
        assertEquals(expected, gb.whatsAtPos(one));
    }

    @Test
    public void test_whatsAtPos_bottom_right_corner() {
        char expected = 'X';
        BoardPosition one = new BoardPosition(2, 2);
        IGameBoard gb = Board(3, 3, 3);
        gb.placeMarker(one, 'X');
        assertEquals(expected, gb.whatsAtPos(one));
    }







    //Is Player at pos
    @Test
    public void test_isPlayerAtPos_empty_board() {
        boolean expected = false;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(1, 1);
        assertEquals(expected, gb.isPlayerAtPos(one, 'X'));
    }

    @Test
    public void test_isPlayerAtPos_top_right_corner() {
        boolean expected = true;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(0, 2);
        BoardPosition two = new BoardPosition(1, 2);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.isPlayerAtPos(one, 'X'));
    }

    @Test
    public void test_isPlayerAtPos_top_left_corner() {
        boolean expected = true;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(0, 0);
        BoardPosition two = new BoardPosition(1, 2);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.isPlayerAtPos(one, 'X'));
    }

    @Test
    public void test_isPlayerAtPos_bottom_left_corner() {
        boolean expected = true;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(2, 0);
        BoardPosition two = new BoardPosition(1, 2);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.isPlayerAtPos(one, 'X'));
    }

    @Test
    public void test_isPlayerAtPos_bottom_right_corner() {
        boolean expected = true;
        IGameBoard gb = Board(3, 3, 3);
        BoardPosition one = new BoardPosition(2, 2);
        BoardPosition two = new BoardPosition(1, 2);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        assertEquals(expected, gb.isPlayerAtPos(one, 'X'));
    }




    //PLace Marker
    @Test
    public void test_placeMarker_2players_on_board() {
        char[][] board_mem = new char[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                board_mem[i][j] = ' ';
            }
        }
        board_mem[2][2] = 'X';
        board_mem[2][4] = 'O';
        IGameBoard gb = Board(5, 5, 3);
        BoardPosition one = new BoardPosition(2, 2);
        BoardPosition two = new BoardPosition(2, 4);
        gb.placeMarker(one, 'X');
        gb.placeMarker(two, 'O');
        String expected = TestBoard(board_mem);
        assertEquals(expected, gb.toString());
    }

    @Test
    public void test_placeMarker_bottom_right_corner() {
        char[][] board_mem = new char[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                board_mem[i][j] = ' ';
            }
        }
        board_mem[4][4] = 'X';
        IGameBoard gb = Board(5, 5, 3);
        BoardPosition curr = new BoardPosition(4, 4);
        gb.placeMarker(curr, 'X');
        String expected = TestBoard(board_mem);
        assertEquals(expected, gb.toString());
    }

    @Test
    public void test_placeMarker_top_right_corner() {
        char[][] board_mem = new char[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                board_mem[i][j] = ' ';
            }
        }
        board_mem[0][4] = 'X';
        IGameBoard gb = Board(5, 5, 3);
        BoardPosition curr = new BoardPosition(0, 4);
        gb.placeMarker(curr, 'X');
        String expected = TestBoard(board_mem);
        assertEquals(expected, gb.toString());
    }

    @Test
    public void test_placeMarker_top_left_corner() {
        char[][] board_mem = new char[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                board_mem[i][j] = ' ';
            }
        }
        board_mem[0][0] = 'X';
        IGameBoard gb = Board(5, 5, 3);
        BoardPosition curr = new BoardPosition(0, 0);
        gb.placeMarker(curr, 'X');
        String expected = TestBoard(board_mem);
        assertEquals(expected, gb.toString());
    }

    @Test
    public void test_placeMarker_bottom_left_corner() {
        char[][] board_mem = new char[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                board_mem[i][j] = ' ';
            }
        }
        board_mem[4][0] = 'X';
        IGameBoard gb = Board(5, 5, 3);
        BoardPosition curr = new BoardPosition(4, 0);
        gb.placeMarker(curr, 'X');
        String expected = TestBoard(board_mem);
        assertEquals(expected, gb.toString());
    }
}




