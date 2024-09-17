package main.java;

import main.java.Board;

import java.util.Scanner;

public class MineSweeperGame {
    private Board board;
    private Scanner scanner;

    public MineSweeperGame(int size, int mines) {
        board = new Board(size, mines);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Minesweeper!");
        board.printBoard();
        while (true) {
            System.out.print("Select a square to reveal (e.g. A1): ");
            String input = scanner.nextLine();
            int row = input.charAt(0) - 'A';
            int col = Integer.parseInt(input.substring(1)) - 1;

            board.revealCell(row, col);

            if (board.isGameLost()) {
                System.out.println("Oh no, you detonated a mine! Game over.");
                board.printBoard();
                break;
            }

            board.printBoard();

            if (board.isGameWon()) {
                System.out.println("Congratulations, you have won the game!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Minesweeper!");

        // Get the size of the grid
        System.out.print("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
        int size = scanner.nextInt();

        // Get the number of mines
        System.out.print("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");
        int mines = scanner.nextInt();

        // Create the board
        Board board = new Board(size, mines);
        board.printBoard();

        while (!board.isGameLost() && !board.isGameWon()) {
            System.out.print("Select a square to reveal (e.g. A1): ");
            String input = scanner.next();
            int row = input.charAt(0) - 'A';
            int col = Integer.parseInt(input.substring(1)) - 1;

            // Reveal the selected cell and get the message
            String message = board.revealCell(row, col);
            System.out.println(message);

            // Print the updated board
            System.out.println("Here is your updated minefield:");
            board.printBoard();

            // Check the game state
            if (board.isGameWon()) {
                System.out.println("Congratulations, you have won the game!");
            } else if (board.isGameLost()) {
                System.out.println("Game over! Try again.");
            }
        }
        scanner.close();
    }
}
