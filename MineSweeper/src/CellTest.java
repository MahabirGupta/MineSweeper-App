import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void testCellInitialization() {
        Cell cell = new Cell();
        assertFalse(cell.hasMine(), "Cell should not have a mine by default.");
        assertEquals(0, cell.getAdjacentMines(), "Cell's adjacent mines should be 0 by default.");
        assertFalse(cell.isRevealed(), "Cell should not be revealed by default.");
    }

    @Test
    public void testSetMine() {
        Cell cell = new Cell();
        cell.setMine(true);
        assertTrue(cell.hasMine(), "Cell should have a mine.");
    }

    @Test
    public void testSetAdjacentMines() {
        Cell cell = new Cell();
        cell.setAdjacentMines(3);
        assertEquals(3, cell.getAdjacentMines(), "Cell's adjacent mines should be updated to 3.");
    }

    @Test
    public void testSetRevealed() {
        Cell cell = new Cell();
        cell.setRevealed(true);
        assertTrue(cell.isRevealed(), "Cell should be revealed.");
    }
}
