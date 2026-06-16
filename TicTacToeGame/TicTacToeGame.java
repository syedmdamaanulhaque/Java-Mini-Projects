import java.util.Scanner;

public class TicTacToeGame {

    static Scanner sc = new Scanner(System.in);

    static int player1Score = 0;
    static int player2Score = 0;
    static int drawScore = 0;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("        TIC TAC TOE GAME");
        System.out.println("=================================");

        System.out.print("Enter Player 1 Name: ");
        String player1 = sc.nextLine();

        System.out.print("Enter Player 2 Name: ");
        String player2 = sc.nextLine();

        char playAgain;

        do {

            System.out.println("\nChoose Board Size:");
            System.out.println("1. 3 X 3");
            System.out.println("2. 4 X 4");
            System.out.println("3. 5 X 5");

            int choice = sc.nextInt();

            int size;

            switch (choice) {
                case 1:
                    size = 3;
                    break;
                case 2:
                    size = 4;
                    break;
                case 3:
                    size = 5;
                    break;
                default:
                    size = 3;
            }

            char[][] board = createBoard(size);

            char currentPlayer = 'X';

            boolean gameOver = false;

            while (!gameOver) {

                printBoard(board);

                String currentName =
                        (currentPlayer == 'X') ? player1 : player2;

                System.out.print(currentName +
                        " (" + currentPlayer +
                        "), enter row and column: ");

                int row = sc.nextInt() - 1;
                int col = sc.nextInt() - 1;

                if (row < 0 || row >= size ||
                        col < 0 || col >= size ||
                        board[row][col] == 'X' ||
                        board[row][col] == 'O') {

                    System.out.println("Invalid move! Try again.");
                    continue;
                }

                board[row][col] = currentPlayer;

                if (checkWinner(board, currentPlayer)) {

                    printBoard(board);

                    System.out.println("\n🎉 Congratulations " +
                            currentName + "!");
                    System.out.println("You won the game!");

                    if (currentPlayer == 'X')
                        player1Score++;
                    else
                        player2Score++;

                    gameOver = true;
                }

                else if (isBoardFull(board)) {

                    printBoard(board);

                    System.out.println("\nGame Draw!");

                    drawScore++;

                    gameOver = true;
                }

                currentPlayer =
                        (currentPlayer == 'X') ? 'O' : 'X';
            }

            System.out.println("\n========= SCOREBOARD =========");
            System.out.println(player1 + " : " + player1Score);
            System.out.println(player2 + " : " + player2Score);
            System.out.println("Draws : " + drawScore);

            System.out.print("\nPlay Again? (Y/N): ");

            playAgain = sc.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\nThanks for playing!");

    }

    static char[][] createBoard(int size) {

        char[][] board = new char[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                board[i][j] = '-';

            }

        }

        return board;
    }

    static void printBoard(char[][] board) {

        System.out.println();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                System.out.print(board[i][j] + " ");

            }

            System.out.println();

        }

        System.out.println();

    }

    static boolean checkWinner(char[][] board,
                               char player) {

        int size = board.length;

        // Rows
        for (int i = 0; i < size; i++) {

            boolean win = true;

            for (int j = 0; j < size; j++) {

                if (board[i][j] != player)
                    win = false;

            }

            if (win)
                return true;
        }

        // Columns
        for (int j = 0; j < size; j++) {

            boolean win = true;

            for (int i = 0; i < size; i++) {

                if (board[i][j] != player)
                    win = false;

            }

            if (win)
                return true;
        }

        // Main diagonal
        boolean win = true;

        for (int i = 0; i < size; i++) {

            if (board[i][i] != player)
                win = false;

        }

        if (win)
            return true;

        // Secondary diagonal
        win = true;

        for (int i = 0; i < size; i++) {

            if (board[i][size - 1 - i] != player)
                win = false;

        }

        return win;
    }

    static boolean isBoardFull(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[i][j] == '-')
                    return false;

            }

        }

        return true;
    }
}