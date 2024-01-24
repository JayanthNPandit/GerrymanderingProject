import java.util.Scanner;

public class Minesweeper {
  private static final int ROWS = 10;
  private static final int COLUMNS = 10;
  private static final int MINES = 10;

  private static char[][] board = new char[ROWS][COLUMNS];
  private static boolean[][] mines = new boolean[ROWS][COLUMNS];
  private static boolean[][] revealed = new boolean[ROWS][COLUMNS];
  private static boolean gameOver = false;

  public static void main(String[] args) {
    // Initialize board
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        board[i][j] = '#';
      }
    }

    // Place mines randomly
    int mineCount = 0;
    while (mineCount < MINES) {
      int row = (int) (Math.random() * ROWS);
      int col = (int) (Math.random() * COLUMNS);
      if (!mines[row][col]) {
        mines[row][col] = true;
        mineCount++;
      }
    }

    // Play the game
    Scanner scanner = new Scanner(System.in);
    while (!gameOver) {
      printBoard();
      System.out.print("Enter row: ");
      int row = scanner.nextInt();
      System.out.print("Enter column: ");
      int col = scanner.nextInt();
      reveal(row, col);
      if (mines[row][col]) {
        gameOver = true;
        System.out.println("Game over! You hit a mine.");
      }
    }
  }

  private static void printBoard() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (revealed[i][j]) {
          if (mines[i][j]) {
            System.out.print("* ");
          } else {
            System.out.print(getAdjacentMines(i, j) + " ");
          }
        } else {
          System.out.print(board[i][j] + " ");
        }
      }
      System.out.println();
    }
  }

  private static void reveal(int row, int col) {
    revealed[row][col] = true;
  }

  private static int getAdjacentMines(int row, int col) {
    int count = 0;
    for (int i = Math.max(0, row - 1); i <= Math.min(ROWS - 1, row + 1); i++) {
      for (int j = Math.max(0, col - 1); j <= Math.min(COLUMNS - 1, col + 1); j++) {
        if (mines[i][j]) {
          count++;
        }
      }
    }
    return count;
  }
}
