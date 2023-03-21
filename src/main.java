import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int k = input.nextInt();
		int N = (k * k) - 1;
		int puzzle[][] = new int [k][k];
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				puzzle[i][j] = input.nextInt();
			}
		}
		
		print2DArray(puzzle);
		

	}
	
	public static void print2DArray(int board[][]) {
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.println(board[i][j]);
			}
			System.out.println();
		}
	}

}
