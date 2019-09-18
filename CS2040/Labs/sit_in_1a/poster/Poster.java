
/**
 * Name         : Larry Law
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Poster {

	private void run() {
		// implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		StringJoiner sj = new StringJoiner(" ");
		while (sc.hasNext()) {
			// For every next word
			String w = sc.next();
			// If doesn't exceed, then add to sj (w space as delimiter)
			if (sj.length() + w.length() + 1 > W) {
				String completed = String.format("%-" + W + "s", sj.toString());
				System.out.println("|" + completed + "|");
				sj = new StringJoiner(" ");
			} else {
			}
			// will add word regardless
			sj.add(w);
		}
		String completed = String.format("%-" + W + "s", sj.toString());
		System.out.println("|" + completed + "|");
		sc.close();
	}

	public static void main(String[] args) {
		Poster newPoster = new Poster();
		newPoster.run();
	}
}
