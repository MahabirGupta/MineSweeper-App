import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testBoardInitialization() {
        Board board = new Board(4, 5);
        assertEquals(4, board.getSize(), "Board size should be 4.");
        // Additional assertions to check mine placement and board initialization
        int mineCount = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).hasMine()) {
                    mineCount++;
                }
            }
        }
        assertEquals(5, mineCount, "Board should contain exactly 5 mines.");
    }

    @Test
    public void testRevealCell() {
        Board board = new Board(4, 5);
        board.revealCell(1, 1);
        // Check if cell is revealed
        assertTrue(board.getCell(1, 1).isRevealed(), "Cell (1,1) should be revealed.");
        // Additional checks can include board state after revealing
    }

    @Test
    public void testGameLost() {
        Board board = new Board(4, 5);
        board.revealCell(0, 0); // Assumes (0,0) has a mine
        assertTrue(board.isGameLost(), "Game should be marked as lost.");
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
        assertTrue(board.isGameWon(), "Game should be marked as won.");
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
