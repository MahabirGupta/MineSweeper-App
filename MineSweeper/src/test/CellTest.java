package test;

import static org.junit.jupiter.api.Assertions.*;

import main.java.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void testCellInitialization() {
        Cell cell = new Cell();
        Assertions.assertFalse(cell.hasMine(), "main.java.Cell should not have a mine by default.");
        Assertions.assertEquals(0, cell.getAdjacentMines(), "main.java.Cell's adjacent mines should be 0 by default.");
        Assertions.assertFalse(cell.isRevealed(), "main.java.Cell should not be revealed by default.");
    }

    @Test
    public void testSetMine() {
        Cell cell = new Cell();
        cell.setMine(true);
        Assertions.assertTrue(cell.hasMine(), "main.java.Cell should have a mine.");
    }

    @Test
    public void testSetAdjacentMines() {
        Cell cell = new Cell();
        cell.setAdjacentMines(3);
        Assertions.assertEquals(3, cell.getAdjacentMines(), "main.java.Cell's adjacent mines should be updated to 3.");
    }

    @Test
    public void testSetRevealed() {
        Cell cell = new Cell();
        cell.setRevealed(true);
        Assertions.assertTrue(cell.isRevealed(), "main.java.Cell should be revealed.");
    }
}
