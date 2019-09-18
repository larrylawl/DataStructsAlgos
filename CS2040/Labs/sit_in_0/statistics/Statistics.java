
/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Statistics {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextLong();
        }
        System.out.println(String.format("Sum: %d", sum));
        System.out.println(String.format("Average: %.2f", (double) sum / n));
    }

    public static void main(String[] args) {
        Statistics newStatistics = new Statistics();
        newStatistics.run();
    }
}
