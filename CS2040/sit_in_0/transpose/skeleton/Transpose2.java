/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Transpose2 {
	private void run() {
        int row = 0, col = 0;
        char[][] grid;
        Scanner sc = new Scanner(System.in);

        // reading input
        row = sc.nextInt();
        col = sc.nextInt();
        grid = new char[row][col];
        
        for (int r = 0; r < row; r++) {
            char[] word = sc.next().toCharArray();
            for (int c = 0; c < col; c++) {
                grid[r][c] = word[c];
            }
        }
        
        // printing output
        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		Transpose2 newTranspose = new Transpose2();
		newTranspose.run();
	}
}
