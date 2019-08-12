/**
 * Name         : Larry Law
 * Matric. No   : 
 * PLab Acct.   : -
 */

import java.util.*;

public class Censorship {
    // function to check if current word needs to be censored
    private boolean isIn(String[] wordlist, String word) {
        boolean isIn = false;
        for (int i = 0; i < wordlist.length; i++) {
            if (wordlist[i].equalsIgnoreCase(word)) {
                isIn = true;
            }
        } return isIn;
    }
    
    // function to convert the censored word to *'s
    private String convert(String word) {
        String initial = "";
        for (int i = 0; i < word.length(); i++) {
            initial += "*";
        } return initial;
    }

	private void run() {
        // initializing variables
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] badWords = new String[n];
        String currentWord;

        // reading bad words
        for (int i = 0; i < n; i++) {
            badWords[i] = sc.next();
        }

        // running logic
        currentWord = sc.next();
        
        // first word
        if (isIn(badWords, currentWord)) {
            System.out.print(convert(currentWord));
        } else {
            System.out.print(currentWord);
        }
        
        // rest of the words
        while (sc.hasNext()) {
            currentWord = sc.next();
            if (isIn(badWords, currentWord)) {
                System.out.print(" " + convert(currentWord));
            } else {
                System.out.print(" " + currentWord);
            }
        } System.out.println();
        
	} 

	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
