/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Transpose {
	private void run() {
        int row = 0, col = 0;
        String[][] grid;
        Scanner sc = new Scanner(System.in);

        // reading input
        row = sc.nextInt();
        col = sc.nextInt();
        grid = new String[row][col];
        
        for (int r = 0; r < row; r++) {
            String word = sc.next();
            for (int c = 0; c < col; c++) {
                grid[r][c] = Character.toString(word.charAt(c));
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
		Transpose newTranspose = new Transpose();
		newTranspose.run();
	}
}
