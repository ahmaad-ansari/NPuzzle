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