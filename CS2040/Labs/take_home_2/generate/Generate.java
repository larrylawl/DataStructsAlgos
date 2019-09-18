/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
	private ArrayList<String> permutations;
	private ArrayList<String> subsets;
	private String original;

	private void generateSubsets(String result, int index) {
		// Base Case: Iterated through string
		if (index == original.length()) {
			subsets.add(result);
		} else {
			// take or don't take
			generateSubsets(result + original.charAt(index), index + 1);
			generateSubsets(result, index + 1);
		}
	}

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
		subsets = new ArrayList<>();
		boolean[] isUsed = new boolean[original.length()];
		generatePermutations("", isUsed);
		Collections.sort(permutations);
		permutations.forEach(x -> System.out.println(x));

		generateSubsets("", 0);
		Collections.sort(subsets);
		subsets.forEach(x -> System.out.println(x));

		sc.close();
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
