import java.util.*;

class Puzzle {
    int[][] board;
    int size, blankRow, blankCol;

    public Puzzle(int size, int[][] board) {
        this.size = size;
        this.board = board;
        findBlank();
    }

    public void findBlank() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    blankRow = i;
                    blankCol = j;
                    return;
                }
            }
        }
    }

    public boolean isSolvable() {
        int inversions = 0;
        for (int i = 0; i < size * size - 1; i++) {
            for (int j = i + 1; j < size * size; j++) {
                int row1 = i / size, col1 = i % size;
                int row2 = j / size, col2 = j % size;
                if (board[row1][col1] != 0 && board[row2][col2] != 0 && board[row1][col1] > board[row2][col2]) {
                    inversions++;
                }
            }
        }
        if (size % 2 == 1) {
            return inversions % 2 == 0;
        } else {
            int row = blankRow;
            return (row + inversions) % 2 == 1;
        }
    }

    public List<String> solve() {
        List<String> directions = new ArrayList<>();
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        Set<Node> explored = new HashSet<>();
        Node initialNode = new Node(board, blankRow, blankCol, 0, null);
        frontier.add(initialNode);
        while (!frontier.isEmpty()) {
            Node node = frontier.poll();
            if (node.isGoal()) {
                while (node.parent != null) {
                    int prevRow = node.parent.blankRow;
                    int prevCol = node.parent.blankCol;
                    int currRow = node.blankRow;
                    int currCol = node.blankCol;
                    int rowDiff = prevRow - currRow;
                    int colDiff = prevCol - currCol;
                    if (rowDiff == 1) {
                        directions.add(0, "UP");
                    } else if (rowDiff == -1) {
                        directions.add(0, "DOWN");
                    } else if (colDiff == 1) {
                        directions.add(0, "LEFT");
                    } else if (colDiff == -1) {
                        directions.add(0, "RIGHT");
                    } else {
                        directions.add(0, "UNKNOWN");
                    }
                    node = node.parent;
                }
                break;
            }
            explored.add(node);
            for (Node neighbor : node.neighbors()) {
                if (!explored.contains(neighbor)) {
                    frontier.add(neighbor);
                }
            }
        }
        return directions;
    }

}