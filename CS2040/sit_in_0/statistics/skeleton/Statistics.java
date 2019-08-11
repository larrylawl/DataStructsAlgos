/**
 * Name         : Chen Yuan Bo
 * Matric. No   : A0183156A
 * PLab Acct.   : -
 */

import java.util.*;

public class Statistics {
	private void run() {
        Scanner sc = new Scanner(System.in);
        int numOfInt = sc.nextInt();
        long sum = 0;

        // a for loop to read the numbers in the line
        for (int i = 0; i < numOfInt; i++) {
            long num = sc.nextLong();
            sum += num;
        }

        System.out.println("Sum: " + sum);
        System.out.println(String.format("Average: %.2f", sum / (double) numOfInt));
	}
	
	public static void main(String[] args) {
		Statistics newStatistics = new Statistics();
		newStatistics.run();
	}
}
