/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
	private ArrayList<String> permutations;
	private String original;

	private void generatePermutations(String current, boolean[] isUsed) {
		if (current.length() == original.length()) {
			permutations.add(current);
		}
		for (int i = 0; i < original.length(); i++) {
			if (isUsed[i]) continue;
			isUsed[i] = true;
			generatePermutations(current + original.charAt(i), isUsed);
			// reset
			isUsed[i] = false;
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		original = sc.next();
		permutations = new ArrayList<>();
		boolean[] isUsed = new boolean[original.length()];
		generatePermutations("", isUsed);
		Collections.sort(permutations);
		permutations.forEach(x -> System.out.println(x));
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
