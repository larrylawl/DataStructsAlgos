/*
 * author		: [Chen Yuan Bo]
 * matric no.	: [A0183156A]
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  : Takes in 2 lines of input of equal length and lower-case letters only
	 * 		POST-Condition :
	 */
	public static boolean isPalindrome(String str) {
        int count = 0;
        boolean isP = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                isP = false;
                break;
            }
        } return isP;
	}
	
	public static void main(String[] args) {
		// declare the necessary variables
        String a, b, str, output;

		// declare a Scanner object to read input
        Scanner s = new Scanner(System.in);

		// read input and process them accordingly
        a = s.next();
        b = s.next();
        str = a + b;

		// simulate the problem
        if (isPalindrome(str)) {
            output = "YES";
        } else {
            output = "NO";
        }

		// output the result
        System.out.println(output);
	}
}
