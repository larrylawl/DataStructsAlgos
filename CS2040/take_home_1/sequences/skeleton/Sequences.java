/**
 * Name         : Chen Yuan Bo
 * Matric. No   : A0183156A
 * PLab Acct.   : -
 */

import java.util.*;

public class Sequences {
	private void run() {
        // declaring variables needed in the program
        Scanner sc = new Scanner(System.in);
        int numOfTerms, sequence;
        long a = 0, d = 0, r = 0;

        // reading input
        numOfTerms = sc.nextInt();
        sequence = sc.nextInt();
        a = sc.nextLong();
        
        // running logic
        if (sequence == 1) {
            d = sc.nextLong();
            long apFactor = d;

            // printing output
            System.out.print(a);
            for (int i = 1; i < numOfTerms; i++) {
                System.out.print(" " + (long)(a + d));
                d+=apFactor;
            }

        } else {
            r = sc.nextLong();
            long gpFactor = r;

            // printing output
            System.out.print(a);
            for (int i = 1; i < numOfTerms; i++) {
                System.out.print(" " + (long)(a * r));
                r*=gpFactor;
            }
        } System.out.println();

	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
