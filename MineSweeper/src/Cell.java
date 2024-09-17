public class Cell {
    private boolean hasMine;
    private int adjacentMines;
    private boolean isRevealed;

    // Getters and setters
    public boolean hasMine() { return hasMine; }
    public void setMine(boolean hasMine) { this.hasMine = hasMine; }
    public int getAdjacentMines() { return adjacentMines; }
    public void setAdjacentMines(int adjacentMines) { this.adjacentMines = adjacentMines; }
    public boolean isRevealed() { return isRevealed; }
    public void setRevealed(boolean isRevealed) { this.isRevealed = isRevealed; }
}
