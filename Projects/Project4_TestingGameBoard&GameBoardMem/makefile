
default:	cpsc2150/extendedTicTacToe/AbsGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/IGameBoard.java

	javac	cpsc2150/extendedTicTacToe/AbsGameBoard.java cpsc2150/extendedTicTacToe/BoardPosition.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/GameScreen.java cpsc2150/extendedTicTacToe/IGameBoard.java

run:	cpsc2150/extendedTicTacToe/AbsGameBoard.class cpsc2150/extendedTicTacToe/BoardPosition.class cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/GameBoard.class cpsc2150/extendedTicTacToe/GameScreen.class cpsc2150/extendedTicTacToe/IGameBoard.class

	java cpsc2150.extendedTicTacToe.GameScreen

clean:

	rm -f cpsc2150/extendedTicTacToe/*.class

test: cpsc2150/extendedTicTacToe/AbsGameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/TestGameBoard.java cpsc2150/extendedTicTacToe/TestGameBoardMem.java cpsc2150/extendedTicTacToe/BoardPosition.java

	javac -cp .:/usr/share/java/junit4.jar cpsc2150/extendedTicTacToe/AbsGameBoard.java cpsc2150/extendedTicTacToe/GameBoardMem.java cpsc2150/extendedTicTacToe/GameBoard.java cpsc2150/extendedTicTacToe/IGameBoard.java cpsc2150/extendedTicTacToe/TestGameBoard.java cpsc2150/extendedTicTacToe/TestGameBoardMem.java cpsc2150/extendedTicTacToe/BoardPosition.java

testGB: cpsc2150/extendedTicTacToe/AbsGameBoard.class cpsc2150/extendedTicTacToe/GameBoardMem.class cpsc2150/extendedTicTacToe/GameBoard.class cpsc2150/extendedTicTacToe/IGameBoard.class cpsc2150/extendedTicTacToe/TestGameBoard.class cpsc2150/extendedTicTacToe/TestGameBoardMem.class cpsc2150/extendedTicTacToe/BoardPosition.class

	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedTicTacToe.TestGameBoard

testGBmem: cpsc2150/extendedTicTacToe/AbsGameBoard.class cpsc2150/extendedTicTacToe/GameBoardMem.class cpsc2150/extendedTicTacToe/GameBoard.class cpsc2150/extendedTicTacToe/IGameBoard.class cpsc2150/extendedTicTacToe/TestGameBoard.class cpsc2150/extendedTicTacToe/TestGameBoardMem.class cpsc2150/extendedTicTacToe/BoardPosition.class

	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedTicTacToe.TestGameBoardMem