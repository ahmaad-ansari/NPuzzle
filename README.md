# N Puzzle Solver
This is a Java program that solves the sliding puzzle using an A* search algorithm with the Manhattan distance heuristic.

## Getting Started
### Prerequisites
To run the program, you will need to have Java installed on your computer. You can download Java from the official website.

### Running the program
To run the program, you can use any Java IDE or execute the code from the command line.

#### Using an IDE
1. Clone this repository or download the source code.
2. Open the project in your preferred Java IDE.
3. Run the `Solution` class.

#### Using the command line
1. Clone this repository or download the source code.
2. Open a terminal or command prompt and navigate to the directory containing the source code.
3. Compile the code by running the following command: javac Solution.java
4. Run the program by running the following command: java Solution

### Input
The program reads input from the standard input (stdin) in the following format:
1. The first line contains a single integer size (3 ≤ size ≤ 10), the size of the board.
2. The next size lines contain size integers each, separated by a space. These integers represent the initial configuration of the board, where 0 represents the empty space.

## Output
The program outputs the solution to the puzzle as a list of moves. Each move is a string that represents the direction of the movement. The possible directions are `UP`, `DOWN`, `LEFT`, and `RIGHT`. The first line of the output contains a single integer, the number of moves in the solution.

## How it works
The program uses the A* search algorithm to find the optimal solution to the sliding puzzle. In this algorithm, we maintain a priority queue of nodes (i.e., board configurations) to explore. We start with the initial node (i.e., the starting configuration of the board) and explore its neighbors. We compute the cost of each neighbor (i.e., the number of moves required to reach that neighbor from the initial node) and the heuristic cost (i.e., an estimate of the number of moves required to reach the goal node from that neighbor). The total cost of a node is the sum of its cost and heuristic cost. We add the neighbor nodes to the priority queue and explore the node with the lowest total cost.

We use the Manhattan distance heuristic to estimate the number of moves required to reach the goal node from a given board configuration. The Manhattan distance between two tiles is the sum of the absolute differences of their row and column positions. The heuristic cost of a board configuration is the sum of the Manhattan distances of each tile from its goal position.

We stop the search when we find a node that represents the goal configuration (i.e., all tiles are in their goal positions).