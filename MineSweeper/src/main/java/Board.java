package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Board {
    private Cell[][] grid;
    private int size;
    private int totalMines;
    private boolean gameLost;

    public Board(int size, int mines) {
        this.size = size;
        this.totalMines = mines;
        this.gameLost = false;
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

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public String revealCell(int row, int col) {
        if (gameLost) {
            return "Game is already lost.";
        }

        Cell cell = grid[row][col];
        if (cell.isRevealed()) {
            return "main.java.Cell is already revealed.";
        }

        cell.setRevealed(true);

        if (cell.hasMine()) {
            gameLost = true;
            return "You hit a mine!";
        }

        if (cell.getAdjacentMines() == 0) {
            // Use BFS to reveal all connected empty cells
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { row, col });

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int i = Math.max(0, r - 1); i <= Math.min(size - 1, r + 1); i++) {
                    for (int j = Math.max(0, c - 1); j <= Math.min(size - 1, c + 1); j++) {
                        if (!grid[i][j].isRevealed() && !grid[i][j].hasMine()) {
                            grid[i][j].setRevealed(true);
                            if (grid[i][j].getAdjacentMines() == 0) {
                                queue.add(new int[] { i, j });
                            }
                        }
                    }
                }
            }
        }

        // If the cell is revealed and no mine is hit, check if it has adjacent mines
        return cell.getAdjacentMines() == 0 ? "This square contains 0 adjacent mines." : "main.java.Cell revealed!";
    }



    public boolean isGameWon() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                if (!cell.hasMine() && !cell.isRevealed()) {
                    return false; // There's at least one non-mine cell that isn't revealed
                }
            }
        }
        return true;
    }

    public boolean isGameLost() {
        return gameLost;
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                if (cell.isRevealed()) {
                    if (cell.hasMine()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(cell.getAdjacentMines() + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
