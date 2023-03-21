import java.util.*;

class Node implements Comparable<Node> {
    int[][] board;
    int blankRow, blankCol;
    int cost, totalCost;
    Node parent;

    public Node(int[][] board, int blankRow, int blankCol, int cost, Node parent) {
        this.board = board;
        this.blankRow = blankRow;
        this.blankCol = blankCol;
        this.cost = cost;
        this.totalCost = cost + heuristic();
        this.parent = parent;
    }

    public int heuristic() {
        int h = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    int goalRow = board[i][j] / board.length;
                    int goalCol = board[i][j] % board.length;
                    h += Math.abs(i - goalRow) + Math.abs(j - goalCol);
                }
            }
        }
        return h;
    }

    public int compareTo(Node other) {
        return this.totalCost - other.totalCost;
    }

    public boolean isGoal() {
        int h = heuristic();
        if (h != 0) {
            return false;
        }
        return true;
    }

    public List<Node> neighbors() {
        List<Node> neighbors = new ArrayList<>();
        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] move : moves) {
            int newRow = blankRow + move[0];
            int newCol = blankCol + move[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length) {
                int[][] newBoard = new int[board.length][board.length];
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        newBoard[i][j] = board[i][j];
                    }
                }
                newBoard[blankRow][blankCol] = newBoard[newRow][newCol];
                newBoard[newRow][newCol] = 0;
                Node neighbor = new Node(newBoard, newRow, newCol, cost + 1, this);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }
}