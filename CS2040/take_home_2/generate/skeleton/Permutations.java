/**
 * Name         : 
 * Matric. No   : 
 * PLab Acct.   : 
 */

import java.util.*;

public class Permutations {

    private ArrayList<ArrayList<Character>> permutate(ArrayList<Character> str) {

        if (str.size() == 0) {
            ArrayList<ArrayList<Character>> result = new ArrayList<>();
            ArrayList<Character> empty = new ArrayList<>();
            result.add(empty);
            return result;
        } else {
            ArrayList<ArrayList<Character>> list = new ArrayList<>();
            for (int i = 0; i < str.size(); i++) {
                ArrayList<Character> newStr = new ArrayList<>(str);
                char ele = newStr.remove(i);
                ArrayList<ArrayList<Character>> subPermutation = permutate(newStr);
                for (ArrayList<Character> ss : subPermutation) {
                    ss.add(0, ele);
                }
                list.addAll(subPermutation);
            }
            return list;
        }

    }

    /*
    public static ArrayList<String> getPermutation(String str) {

        // If string is empty
        if (str.length() == 0) {

            // Return an empty arraylist
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        // Take first character of str
        char ch = str.charAt(0);

        // Take sub-string starting from the
        // second character
        String subStr = str.substring(1);

        // Recurvise call
        ArrayList<String> prevResult = getPermutation(subStr);

        // Store the generated permutations
        // into the resultant arraylist
        ArrayList<String> Res = new ArrayList<>();

        for (String val : prevResult) {
            for (int i = 0; i <= val.length(); i++) {
                Res.add(val.substring(0, i) + ch + val.substring(i));
            }
        }

        // Return the resultant arraylist
        return Res;
    }
    */

	private void run() {
        
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        ArrayList<Character> str = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            str.add(word.charAt(i));
        }

        List<ArrayList<Character>> permutations = permutate(str);

        for (ArrayList<Character> word2 : permutations) {
            System.out.println(word2.toString());
        }
        
	}

	public static void main(String[] args) {
		Permutations newPermutations = new Permutations();
		newPermutations.run();
	}
}
