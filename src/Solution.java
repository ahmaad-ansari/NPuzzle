import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the board
        int size = scanner.nextInt();

        // Read the initial configuration of the board
        int[][] board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        // Create the Puzzle object
        Puzzle puzzle = new Puzzle(size, board);

        // Solve the puzzle
        List<String> solution = puzzle.solve();

        // Print the solution
        System.out.println(solution.size());
        for (String move : solution) {
            System.out.println(move);
        }
    }
}