import java.util.Random;

public class Board {
    private Cell[][] grid;
    private int size;
    private int totalMines;

    public Board(int size, int mines) {
        this.size = size;
        this.totalMines = mines;
        grid = new Cell[size][size];
        initializeBoard();
        placeMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < totalMines) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            if (!grid[row][col].hasMine()) {
                grid[row][col].setMine(true);
                minesPlaced++;
                updateAdjacentCells(row, col);
            }
        }
    }

    private void updateAdjacentCells(int row, int col) {
        for (int r = Math.max(0, row - 1); r <= Math.min(size - 1, row + 1); r++) {
            for (int c = Math.max(0, col - 1); c <= Math.min(size - 1, col + 1); c++) {
                if (r != row || c != col) {
                    grid[r][c].setAdjacentMines(grid[r][c].getAdjacentMines() + 1);
                }
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public void revealCell(int row, int col) {
        // Add reveal logic, including recursion for empty cells
    }

    public boolean isGameWon() {
        // Add win condition check
        return false;
    }

    public boolean isGameLost() {
        // Add loss condition check
        return false;
    }

    public void printBoard() {
        // Add code to print the current state of the board
    }
}
