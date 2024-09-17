package test;

import static org.junit.jupiter.api.Assertions.*;

import main.java.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testBoardInitialization() {
        Board board = new Board(4, 5);
        Assertions.assertEquals(4, board.getSize(), "main.java.Board size should be 4.");
        // Additional assertions to check mine placement and board initialization
        int mineCount = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).hasMine()) {
                    mineCount++;
                }
            }
        }
        assertEquals(5, mineCount, "main.java.Board should contain exactly 5 mines.");
    }

    @Test
    public void testRevealCell() {
        Board board = new Board(4, 5);
        board.revealCell(1, 1);
        // Check if cell is revealed
        Assertions.assertTrue(board.getCell(1, 1).isRevealed(), "main.java.Cell (1,1) should be revealed.");
        // Additional checks can include board state after revealing
    }

    @Test
    public void testGameLost() {
        Board board = new Board(4, 5);

        // Find a cell with a mine to reveal
        boolean mineRevealed = false;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).hasMine()) {
                    board.revealCell(i, j);
                    mineRevealed = true;
                    break;
                }
            }
            if (mineRevealed) break;
        }

        Assertions.assertTrue(board.isGameLost(), "Game should be marked as lost.");
    }

    @Test
    public void testGameWon() {
        Board board = new Board(4, 1); // Only 1 mine on a 4x4 board
        // Simulate revealing all non-mine cells
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (!board.getCell(i, j).hasMine()) {
                    board.revealCell(i, j);
                }
            }
        }
        Assertions.assertTrue(board.isGameWon(), "Game should be marked as won.");
    }

    @Test
    public void testPrintBoard() {
        Board board = new Board(4, 5);
        // Simulate revealing some cells
        board.revealCell(1, 1);
        // Capture the printed output and validate it
        // For simplicity, you might want to visually inspect the output in this case.
        board.printBoard();
    }
}
